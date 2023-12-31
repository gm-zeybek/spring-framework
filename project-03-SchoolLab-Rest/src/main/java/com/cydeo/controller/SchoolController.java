package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.http.HttpStatus;
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

    // write a endpoint which returns all students with using wrapper class
    // with speacific message and 200 status code and
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getStudents(){
        return ResponseEntity
                .status(200)
                .body(new ResponseWrapper("students are successfully retrieved", studentService.findAll()));
    }

}
