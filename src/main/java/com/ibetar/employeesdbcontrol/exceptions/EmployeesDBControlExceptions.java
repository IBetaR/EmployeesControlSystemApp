package com.ibetar.employeesdbcontrol.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmployeesDBControlExceptions extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public EmployeesDBControlExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
