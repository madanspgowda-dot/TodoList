package com.example.TodoList.Controller;

import com.example.TodoList.Entity.ContactEntity;
import com.example.TodoList.Services.ContactServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {
    private final ContactServices contactser;

    public ContactController(ContactServices contactser) {
        this.contactser = contactser;
    }
    @GetMapping("/contact")
    public String contactpage(Model model){
         model.addAttribute("contactForm", new ContactEntity());
        return "Pages/contact";
    }
    @PostMapping("/contact")
    public String savedataofcontact(@ModelAttribute ContactEntity contactentity,
                                    RedirectAttributes redirectAttributes) {

        contactser.savecontact(contactentity);

        redirectAttributes.addFlashAttribute("successMessage",
                "Message sent successfully!");

        return "redirect:/contact";
    }
}
