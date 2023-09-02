package stereotype_annotation.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@AllArgsConstructor// or @Data with @NonNull constructor
@Component
public class DataStructures {
    ExtraHours extraHours;

    public void getTotalHours(){
        System.out.println("total hours : " + (10 + extraHours.getHours()));
    }
}
