package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info")
    public String carInfo(@RequestParam(value = "citroen", required = false, defaultValue = "tesla") String make, @RequestParam(value = "1000", required = false, defaultValue = "1000") Integer year, Model model) { // REQUEST PARAM ALLOW US FETCH QUEERY PARAMETER KEY -VALUE INTO JAVA CODE
        //@RequestParam(value = "", required = false) have options

        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }

    @RequestMapping("/carinfo/{make}/{year}")// make path parameter  (path variable is not optional)
    public String carInfo2(@PathVariable String make, @PathVariable Integer year, Model model){
        model.addAttribute(make);
        model.addAttribute(year);
        return "/car/car-info";
    }
}
