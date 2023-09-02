package bean_practice;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StringConfig {
//    @Primary

    @Bean("Welcome")
    String str(){
        return "Welcome to Cydeo";
    }

    @Bean
    String string(){
        return "Spring core practice";
    }
}
