package com.example.TodoList.Controller;

import com.example.TodoList.Entity.SignUpEntity;
import com.example.TodoList.Services.SignUpServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {
    private final SignUpServices signupservices;

    public SignUpController(SignUpServices signupservices) {
        this.signupservices = signupservices;
    }

    @GetMapping("/signup")
    public String signuppage(Model model){
        model.addAttribute("signupdetails",new SignUpEntity());
        return "Pages/signup";
    }
    @PostMapping("/signup")
    public String savesignupdata(@ModelAttribute SignUpEntity signUpEntity, RedirectAttributes RedirectAttributes){
        if(signupservices.emailExists(signUpEntity.getEmail())){
            RedirectAttributes.addFlashAttribute("error", "Email already exists!");
            return "redirect:/signup";   // stay on same page
        }

        RedirectAttributes.addFlashAttribute("Success","Registed Succesfully");
        signupservices.savesignpdata(signUpEntity);
        return "redirect:/signup";
    }
}
