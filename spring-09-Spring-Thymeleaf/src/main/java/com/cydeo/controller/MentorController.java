package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String getForm(Model model) {
        model.addAttribute("mentor", new Mentor());
        List<String> batchList = Arrays.asList("JD1", "JD2", "EU1", "EU2");
        model.addAttribute("batchList", batchList);
        return "/mentor/mentor-register";
    }

    @PostMapping("/confirm")
    // ModelAttribute("") capture runtime object as context and use (Model model is not required anymore)
    public String postForm(@ModelAttribute("mentor") Mentor mentor) {

        System.out.println(mentor.toString());
        // instead of
        //         return "/mentor/confirmation";
        // use this one
        //          redirect: allows open fresh form again
        return "redirect:/mentor/register";
    }

}
