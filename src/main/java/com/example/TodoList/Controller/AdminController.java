package com.example.TodoList.Controller;

import com.example.TodoList.Services.SignUpServices;
import com.example.TodoList.Services.TodoPageServices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TodoList.Services.ContactServices;
@Controller
public class AdminController {
    private final ContactServices contactServices;
    private final SignUpServices signupservices;
    public AdminController(ContactServices contactServices, SignUpServices signupservices,
            TodoPageServices todoPageServices) {
        this.contactServices = contactServices;
        this.signupservices = signupservices;
        this.todoPageServices = todoPageServices;
    }
    private final TodoPageServices todoPageServices;
      @GetMapping("/admin")
    public String showdatalistofcontact(Model model){
model.addAttribute("contactlist",contactServices.findallcontact());
          model.addAttribute("signuplist",signupservices.showsignupdata());
          model.addAttribute("todopagelist",todoPageServices.getalltodopageentity());
        return "Pages/admin";
    }

@GetMapping("/admin/delete/{id}")
    public String deleteTodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        todoPageServices.deletetodopageentity(id);
        redirectAttributes.addFlashAttribute("message", "Todo deleted with ID: " + id + " successfully!");
        return "redirect:/admin";
    }
}
