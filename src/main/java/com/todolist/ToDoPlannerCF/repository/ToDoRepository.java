package com.todolist.ToDoPlannerCF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todolist.ToDoPlannerCF.entity.ToDoEntity;


public interface ToDoRepository extends JpaRepository<ToDoEntity,Integer> {
}
