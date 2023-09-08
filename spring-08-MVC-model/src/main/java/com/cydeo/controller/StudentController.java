package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model){  // Call Model as an argument and call methods
        // values coming from inside the method and not visible from another method
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");
        return "/student/welcome"; // NO HTML ANYMORE SINCE IT IS USING THYMELEAF
    }
}
