package stereotype_annotation.model;

import org.springframework.stereotype.Component;

@Component
public class MicroServices {
    public void getTotalHours(){
        System.out.println("total hours : " + 20);
    }
}
