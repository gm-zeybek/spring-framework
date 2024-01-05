package com.cydeo.controller;

import com.cydeo.client.WeatherClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.WeatherStack;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SchoolController {


    //write a method for teachers and return list of teachers

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;
    private final WeatherClient weatherClient;

    @Value("${weatherstack.access_key}")
    private String access_key;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService, WeatherClient weatherClient) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
        this.weatherClient = weatherClient;
    }


    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        return teacherService.findAll();
    }

    // TODO: (WRAPPER CLASS) Add a controller method which hits /students endpoint with specific message "students are successfully retrieved" and status code 200 and success true

    /*
    [
    {
        "firstName": "John",
        "lastName": "Gotti",
        "phoneNumber": "123123123",
        "email": "john@email",
        "username": "john",
        "birthday": "1972-01-06",
        "status": "ACTIVE",
        "educationLevel": "MASTER",
        "address": {
            "street": "Str. Garibaldi",
            "country": "United Kingdom",
            "city": "London",
            "postalCode": "10000",
            "addressType": "TEACHER"
        }
    },
     */
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper(
                "students are successfully retrieved",
                studentService.findAll()));
    }

    // TODO: (WRAPPER CLASS) add a endpoint which return special header "Parent" value "returned" and special body with message "parents are returned successfully" with status code 202
    /*
    {
    "code": 202,
    "success": true,
    "message": "parents are returned successfully",
    "data": [
        {
            "firstName": "Liridon",
            "lastName": "Morina",
            "profession": "Software Engineer",
            "phoneNumber": "+38345111222",
            "email": "liridon@email.com",
            "username": "liridonmorina",
            "birthday": "1993-07-28",
            "status": "ACTIVE",
            "address": {
                "street": "Str. Mark Isaku",
                "country": "Ireland",
                "city": "Dublin",
                "postalCode": "10000",
                "addressType": "PARENT"
            }
        },
     */
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getAllParents(){

        ResponseWrapper responseWrapper = new ResponseWrapper(
                202,
                true,
                "parents are returned successfully",
                parentService.findAll());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Parent", "returned")
                .body(responseWrapper);
    }


    // TODO: (WRAPPER CLASS) add an individual endpoint for single Address with special message "address ... is successfully retrieved" status code 200 success true and address information

    /**
     * {
     *     "code": 200,
     *     "success": true,
     *     "message": "address1 is successfully retrieved",
     *     "data": {
     *         "street": "Str. Garibaldi",
     *         "country": "United Kingdom",
     *         "city": "London",
     *         "postalCode": "10000",
     *         "addressType": "TEACHER"
     *     }
     * }
     */
   // homework
    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddressDetails(@PathVariable("id") Long id) throws Exception {
        AddressDTO addressDTO = addressService.findById(id);
        WeatherStack weatherStack = weatherClient.getCurrent(access_key, addressDTO.getCity());
        addressDTO.setCurrentTemperature(weatherStack.current.temperature);
        return ResponseEntity.ok(new ResponseWrapper(200,true,"retrieved successfully",addressDTO));
    }
}
