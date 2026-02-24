package com.example.TodoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TodoList.Entity.ContactEntity;
import com.example.TodoList.Services.ContactServices;


@Controller
public class AdminController {
    private final ContactServices contactServices;
  
    public AdminController(ContactServices contactServices) {
        this.contactServices = contactServices;
    }
      @GetMapping("/admin")
    public String showdatalistofcontact(Model model){
model.addAttribute("contactlist",contactServices.findallcontact());
        return "Pages/admin";
    }
}
