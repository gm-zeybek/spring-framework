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
        model.addAttribute("mentor",new Mentor());
        List<String> batchList = Arrays.asList("JD1", "JD2", "EU1", "EU2");
        model.addAttribute("batchList", batchList);
        return "/mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String postForm(@ModelAttribute("mentor") Mentor mentor, Model model) { // ModelAttribute("<attribute>") accept attribute looking for

        System.out.println(mentor.toString());
//        return "/mentor/confirmation";
        return "redirect:/mentor/register";  // redirect: allows open fresh form again
    }

}
