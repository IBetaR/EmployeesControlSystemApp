package com.ibetar.employeesdbcontrol.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Document(value = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    @NotEmpty(message = "Must be a valid name")
    private String firstname;
    @NotEmpty(message = "Must be a valid lastname")
    private String lastname;
    @Email
    private String email;
    private Gender gender;
    private Address address;
    private LocalDateTime localDateTime;
    private EmployeeRole role;
    private String userProfileImageLink;

}
