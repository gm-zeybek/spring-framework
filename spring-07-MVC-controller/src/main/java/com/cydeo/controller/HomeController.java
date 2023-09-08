package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller annotation stereotype annotation looking for mapping url
public class HomeController {
    @RequestMapping("/home") // connects with end point
    public String home(){
        return "home.html";
    }

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }

    @RequestMapping("/") // shows base url
    public String home3(){
        return "welcome.html";
    }
}
