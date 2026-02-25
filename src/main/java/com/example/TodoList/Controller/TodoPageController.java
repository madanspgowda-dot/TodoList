package com.example.TodoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoPageController {
   @GetMapping("/TodoPage")
    public String showTodoPage(){
        return "TodoPage";
    }
}
