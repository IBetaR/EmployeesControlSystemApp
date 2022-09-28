package com.ibetar.employeesdbcontrol.controller;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import com.ibetar.employeesdbcontrol.service.EmployeeService;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
@Slf4j
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("")
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/{username}")
    public Optional<Employee> getEmployee(@PathVariable("username") String username) {
        try {
            log.info("fetching data");
            return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeByUsername(username)).getBody();
        } catch (Exception e) {
            log.error("Error fetching data");
            throw new RuntimeException(e + "Error");
        }

    }

    @PostMapping("/new")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) throws Exception {
        try{
           return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(employee));
        } catch (Exception e) {
            throw new Exception("Error "+e);
        }
    }


    @PutMapping("/update/{username}")
    public ResponseEntity<?> update(@PathVariable String username, @RequestBody Employee employee){
        try {
            log.info("Updating employee: " + employee.getFirstname() + " " + employee.getLastname());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(username, employee));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error Por favor revise la request.\"}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            log.info("Deleting user: " + id);
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error Por favor revise la request.\"}");
        }
    }

}
