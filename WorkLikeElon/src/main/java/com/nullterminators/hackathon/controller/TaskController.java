package com.nullterminators.hackathon.controller;

import com.nullterminators.hackathon.entity.Task;
import com.nullterminators.hackathon.entity.TaskRequest;
import com.nullterminators.hackathon.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<Task> saveTask(@RequestBody TaskRequest taskRequest) throws Exception {
        try {
            Task task = taskService.saveTask(taskRequest);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch(Exception ex) {
            throw ex;
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("allTasks")
    public ResponseEntity<List<Task>> getTaskById() {
        List<Task> taskList = taskService.findAllTasks();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTaskById(@PathVariable int id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllTasks() {
        taskService.deleteAllTasks();
        String message = "All tasks have been deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
