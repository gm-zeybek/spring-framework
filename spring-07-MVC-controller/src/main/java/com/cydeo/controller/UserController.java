package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){
        return "/user/user.html";// NEED TO SAY SPRINGBOOT EXACTLY WHERE THE
    }
}
