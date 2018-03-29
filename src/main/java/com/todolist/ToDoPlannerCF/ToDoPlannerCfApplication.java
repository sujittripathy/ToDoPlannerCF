package com.todolist.ToDoPlannerCF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ToDoPlannerCfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoPlannerCfApplication.class, args);
    }
}

