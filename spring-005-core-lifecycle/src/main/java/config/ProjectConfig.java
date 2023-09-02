package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.cydeo")
@ComponentScan(basePackages = {"com.cydeo.proxy","com.cydeo.repository","com.cydeo.service"})
public class ProjectConfig {

}
