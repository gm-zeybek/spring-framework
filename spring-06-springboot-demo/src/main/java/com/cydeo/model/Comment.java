package com.cydeo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Comment {
    @Value("Mike")
    private String author;
    private String text;
}
