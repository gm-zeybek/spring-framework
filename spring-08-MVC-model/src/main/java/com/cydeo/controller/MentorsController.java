package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Students;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")    // class level mapping
public class MentorsController {
    @RequestMapping("/list")  // method level mapping localhost:8080/mentor/list
    public String table(Model model){
        Students student1 = new Students("Mike", "Smith",15, Gender.MALE);
        Students student2 = new Students("Olivia", "Smith",17, Gender.FEMALE);
        Students student3 = new Students("Sam", "Smith",15, Gender.FEMALE);
        Students student4 = new Students("John", "Smith",12, Gender.MALE);
        List<Students> students = new ArrayList<Students>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        model.addAttribute("students",students);
        return "task/table";
    }
}
