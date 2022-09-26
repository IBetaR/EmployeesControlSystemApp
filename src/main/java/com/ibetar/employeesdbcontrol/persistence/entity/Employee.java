package com.ibetar.employeesdbcontrol.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

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
    private String firstname;
    private String lastname;
    private String email;
    private Gender gender;
    private Address address;
    private LocalDateTime createdAt;
    private EmployeeRole role;
    private String userProfileImageLink;

//    public Employee(String id,
//                    String username,
//                    String password,
//                    String firstname,
//                    String lastname,
//                    String email,
//                    Gender gender,
//                    Address address,
//                    LocalDateTime createdAt) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.gender = gender;
//        this.address = address;
//        this.createdAt = createdAt;
//    }

    //    private Collection<Role> roles = new ArrayList<>();
}
