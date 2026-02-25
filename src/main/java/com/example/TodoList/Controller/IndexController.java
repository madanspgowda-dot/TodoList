package com.example.TodoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
  @GetMapping("/")
  public String indexpage(){
    return "index";
  } 
  @GetMapping("/about")
  public String aboutpage(){
    return "Pages/about";
  }
}
