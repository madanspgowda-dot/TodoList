package com.example.TodoList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoList.Entity.TodoPageEntity;

public interface TodoPageRepository extends JpaRepository<TodoPageEntity, Long> {
    
}
