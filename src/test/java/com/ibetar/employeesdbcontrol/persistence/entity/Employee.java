package com.ibetar.employeesdbcontrol.persistence.entity;

import com.mongodb.lang.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Employee {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private LocalDateTime createdAt;

    @Nullable
    private String userProfileImageLink; //s3 key
    private Collection<Role> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getId().equals(employee.getId())
                && getFirstname().equals(employee.getFirstname())
                && getLastname().equals(employee.getLastname())
                && getUsername().equals(employee.getUsername())
                && getPassword().equals(employee.getPassword())
                && getEmail().equals(employee.getEmail())
                && getGender() == employee.getGender()
                && getAddress().equals(employee.getAddress())
                && getCreatedAt().equals(employee.getCreatedAt())
                && getUserProfileImageLink().equals(employee.getUserProfileImageLink())
                && getRoles().equals(employee.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getFirstname(),
                getLastname(),
                getUsername(),
                getPassword(),
                getEmail(),
                getGender(),
                getAddress(),
                getCreatedAt(),
                getUserProfileImageLink(),
                getRoles());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", userProfileImageLink='" + userProfileImageLink + '\'' +
                ", roles=" + roles +
                '}';
    }
}
