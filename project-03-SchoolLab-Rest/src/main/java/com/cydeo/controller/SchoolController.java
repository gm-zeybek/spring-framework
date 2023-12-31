package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    //write a method for teachers and return list of teachers

    private final TeacherService teacherService;
    private final StudentService studentService;

    public SchoolController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        return teacherService.findAll();
    }

    // TODO: (WRAPPER CLASS) Add a controller method which hits /students endpoint with specific message "students are successfully retrieved" and status code 200 and success true

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper(
                "students are successfully retrieved",
                studentService.findAll()));
    }

}
