package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper {
    private int code;
    private boolean success;
    private String message;
    private Object data;


    // TODO: ADDING CONSTRUCTOR WITH MESSAGE AND DATA
    public ResponseWrapper(String message, Object data) {
        this.code = HttpStatus.OK.value();
        this.message = message;
        this.success = true;
        this.data = data;
    }

    // TODO: ADDING CONSTRUCTOR JUST WITH CODE AND MESSAGE
    public ResponseWrapper(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
