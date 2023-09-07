package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplications {
// self contained application stand alone
    // java -jar cydeoApplication.jar ( this commmand run cydeo application from command line)
    // war file is used for traditional way to run application
    // @SpringBootApplication annotation consists of
    // @EnableAutoConfiguration
    // @ComponentScan
    // @SpringBootConfiguration





    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Arthur");
        comment.setText("Spring boot");

        ApplicationContext container = SpringApplication.run(CydeoApplications.class, args);
        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);

        System.out.println("Name is " + commentService.k); // printing parameter from bean service

    }

}
