package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("users")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";


    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping
    public User[] readAllUser(){
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI,User[].class);
        return responseEntity.getBody();
    }

    @RequestMapping("{id}") // this get any object from api and give to the json // {id}
    public Object getUser(@PathVariable("id") Integer id){  // return object
        String URL = URI + "/{id}";                         // third party url + /{id}
        return restTemplate.getForObject(URL, Object.class, id);
    }

}
