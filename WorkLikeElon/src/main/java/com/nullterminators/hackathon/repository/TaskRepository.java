package com.nullterminators.hackathon.repository;

import com.nullterminators.hackathon.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findById(int id);

    List<Task> findAll();

    void deleteAll();

    void deleteById(int id);

}
