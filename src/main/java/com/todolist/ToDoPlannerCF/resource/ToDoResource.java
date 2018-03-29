package com.todolist.ToDoPlannerCF.resource;

import com.todolist.ToDoPlannerCF.entity.ToDoEntity;
import com.todolist.ToDoPlannerCF.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

public class ToDoResource {
    private static Logger logger = LoggerFactory.getLogger(ToDoResource.class);

    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${todoapp.version}")
    private String version;

    @PostMapping("/addTask")
    public long addTask(){
        ToDoEntity te = toDoRepository.save(new ToDoEntity("Cloud Native Book Study", 1, LocalDate.now()));
        logger.info("Saved Entity: "+ te);
        rabbitTemplate.convertAndSend("myQueue", te.getTaskName());
        return te.getId();
    }

    @GetMapping("/fetchTasks")
    public List<ToDoEntity> getTasks(){
        return toDoRepository.findAll();
    }

    @GetMapping("/version")
    public String getVersion(){
        return version;
    }
}
