package com.example.TodoList.Services;

import org.springframework.stereotype.Service;

import com.example.TodoList.Entity.TodoPageEntity;
import com.example.TodoList.Repository.TodoPageRepository;
@Service
public class TodoPageServices {
    private final TodoPageRepository todoPageRepository;
    
    public TodoPageServices(TodoPageRepository todoPageRepository) {
        this.todoPageRepository = todoPageRepository;
    }
    public TodoPageEntity savetopageentity(TodoPageEntity todoPageEntity){
        return todoPageRepository.save(todoPageEntity);
    }
}
