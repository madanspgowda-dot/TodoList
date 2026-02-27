package com.example.TodoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TodoList.Entity.TodoPageEntity;
import com.example.TodoList.Services.TodoPageServices;


@Controller
public class TodoPageController {
private final TodoPageServices todoPageServices;

    public TodoPageController(TodoPageServices todoPageServices) {
        this.todoPageServices = todoPageServices;
    }
 @GetMapping("/todolistpage")
public String showForm(Model model) {
    model.addAttribute("todolistdata", new TodoPageEntity());
    return "TodoPage";
}
    @PostMapping("/todolist")
    public String addTodo(@ModelAttribute TodoPageEntity todoPageEntity,RedirectAttributes redirectAttributes) {
        todoPageServices.savetopageentity(todoPageEntity);
        redirectAttributes.addFlashAttribute("message", "Todo added successfully!");
        return "redirect:/todolistpage";
    }
    
}
