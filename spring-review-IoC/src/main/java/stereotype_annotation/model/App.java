package stereotype_annotation.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotation.config.Config;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(DataStructures.class).getTotalHours();
        context.getBean(MicroServices.class).getTotalHours();
    }
}
