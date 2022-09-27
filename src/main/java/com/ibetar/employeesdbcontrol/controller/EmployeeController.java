package com.ibetar.employeesdbcontrol.controller;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import com.ibetar.employeesdbcontrol.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{username}")
    public Optional<Employee> getEmployee(@PathVariable("username") String username) {
        return service.getEmployeeByUsername(username);
    }

    @PostMapping("/employees/new")
    public void save(@RequestBody Employee employee){
         service.createEmployee(employee);
    }

//    @DeleteMapping("/employees/delete/{username}")
//    public void deleteEmployee(@PathVariable("username") String username) {
//         service.deleteEmployee(username);
//    }
}
