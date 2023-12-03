package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false") // whatever repository use this will automatically turn into "SELECT ...WHERE is_deleted=false"
public class User extends BaseEntity {


    private String firstName;
    private String lastName;
    @NotNull
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;
    @ManyToOne // many users can be same role
    @JoinColumn(name = "role_id") // not mandatory optional
    private Role role;
    @Enumerated(EnumType.STRING)
    private Gender gender;




}
