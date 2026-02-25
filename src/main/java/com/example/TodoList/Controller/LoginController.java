package com.example.TodoList.Controller;

import com.example.TodoList.Entity.SignUpEntity;
import com.example.TodoList.Services.SignUpServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final SignUpServices signUpServices;

    public LoginController(SignUpServices signUpServices) {
        this.signUpServices = signUpServices;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "Pages/login";   // MUST return String
    }

   
@PostMapping("/login")
public String loginUser(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

    boolean isValid = signUpServices.validateLogin(email, password);

    if (isValid) {

        return "/TodoPage";
    } else {
        model.addAttribute("error", "Invalid Email or Password");
        return "Pages/login";
    }
}
    }
