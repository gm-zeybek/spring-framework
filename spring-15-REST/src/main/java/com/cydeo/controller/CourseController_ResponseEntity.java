package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public ResponseEntity<List<CourseDTO>>getCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo V2")
                .header("operation", "Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course));
    }
}