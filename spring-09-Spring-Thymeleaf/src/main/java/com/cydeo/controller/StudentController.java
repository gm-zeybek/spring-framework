package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")   // @GetMapping is method level applied not class level
public class StudentController {


//    @RequestMapping("/register")
    @GetMapping("/register")  // same as requestmapping
    public String register(Model model) {


        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

//    @RequestMapping("/welcome")
    @GetMapping("/welcome")  // same with requestmapping
    public String welcome(){

        return "student/welcome";
    }
}
