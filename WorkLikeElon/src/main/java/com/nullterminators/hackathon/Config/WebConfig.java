package com.nullterminators.hackathon.Config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/focus").setViewName("focus");
    }
}
