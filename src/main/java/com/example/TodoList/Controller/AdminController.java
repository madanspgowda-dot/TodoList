package com.example.TodoList.Controller;

import com.example.TodoList.Services.SignUpServices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TodoList.Services.ContactServices;
@Controller
public class AdminController {
    private final ContactServices contactServices;
  
    public AdminController(ContactServices contactServices, SignUpServices signupservices) {
        this.contactServices = contactServices;
        this.signupservices = signupservices;
    }
    private final SignUpServices signupservices;
      @GetMapping("/admin")
    public String showdatalistofcontact(Model model){
model.addAttribute("contactlist",contactServices.findallcontact());
          model.addAttribute("signuplist",signupservices.showsignupdata());
        return "Pages/admin";
    }



}
