package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Street cannot be empty.")
    @Size(min = 1, max = 100, message = "Street should be between 1 and 100 characters.")
    private String street;

    @NotBlank(message = "Country cannot be empty.")
    @Size(min = 1, max = 50, message = "Country should be between 1 and 50 characters.")
    private String country;
    private String flagPngUrl;

    //@NotBlank(message = "State cannot be empty.")
    @Size(min = 1, max = 50, message = "State should be between 1 and 50 characters.")
    private String state;

    @NotBlank(message = "City cannot be empty.")
    @Size(min = 1, max = 50, message = "City should be between 1 and 50 characters.")
    private String city;

    @NotBlank(message = "Postal code cannot be empty.")
    @Pattern(regexp = "\\d{5}", message = "Postal code should be 5 digits long.")
    private String postalCode;


    private String flag;

    @NotNull(message = "Address type cannot be null.")
    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference")
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference")
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")
    private TeacherDTO teacher;

    private Integer currentTemperature;

}
