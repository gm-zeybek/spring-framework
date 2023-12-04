package com.cydeo.controller;


import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller// either only controller + responseBody = ResponseController
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    @ResponseBody
    public List<CourseDTO> getCourse(){
        List<CourseDTO> list = courseService.getCourses();

        return list;

    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getCourseByCategery(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }
}
