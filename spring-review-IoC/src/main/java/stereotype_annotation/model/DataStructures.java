package stereotype_annotation.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DataStructures {

    public void getTotalHours(){
        System.out.println("total hours : " + 10);
    }
}
