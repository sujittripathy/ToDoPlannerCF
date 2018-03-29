package com.todolist.ToDoPlannerCF.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ToDoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String taskName;
    private int duration;
    private LocalDate taskDate;

    public ToDoEntity(){

    }
    public ToDoEntity(String taskName, int duration, LocalDate taskDate) {
        this.taskName = taskName;
        this.duration = duration;
        this.taskDate = taskDate;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    @Override
    public String toString() {
        return "ToDoEntity{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", duration=" + duration +
                ", taskDate=" + taskDate +
                '}';
    }
}
