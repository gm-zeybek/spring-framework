package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("student")
public class StudentController {
    @RequestMapping("/welcome")  // localhost:8080/student/welcome
    public String homePage(Model model){  // Call Model as an argument and call methods
        // values coming from inside the method and not visible from another method
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");
        model.addAttribute("lesson", "data");
        BigInteger studenId = BigInteger.valueOf((long) (Math.random()*1000));
        model.addAttribute("studentId", studenId);

        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(8);
        model.addAttribute("numbers", list);

        Student student = new Student(UUID.randomUUID(), "Mike", "Smith");
        model.addAttribute("student", student);
        return "/student/welcome"; // NO HTML ANYMORE SINCE IT IS USING THYMELEAF
    }
}
