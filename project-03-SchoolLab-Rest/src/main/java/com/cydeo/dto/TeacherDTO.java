package com.cydeo.dto;

import com.cydeo.enums.EducationLevel;
import com.cydeo.enums.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// TODO: TO REMOVE NON-NULL VALUE FROM PAYLOAD
@JsonInclude(JsonInclude.Include.NON_NULL)
// TODO: TO AVOID FAILING DUE TO UNKNOWN FIELD IN PAYLOAD
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherDTO {
    // TODO: TO IGNORE A FIELD FOR ALL REQUEST
    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String email;
    private String username;
    // TODO: TO AVOID PASSWORD DISPLAYING ON RECEIVING PAYLOAD
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private LocalDate birthday;

    private Status status;

    private EducationLevel educationLevel;
    // TODO: TO AVOID RECURSIVE CALL AMONG OTHER OBJECT
    @JsonManagedReference(value = "teacher-address-reference")
    private AddressDTO address;

}