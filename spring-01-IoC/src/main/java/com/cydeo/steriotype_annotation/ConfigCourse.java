package com.cydeo.steriotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "com.cydeo")// if the pojos are not same packages
public class ConfigCourse {
}
