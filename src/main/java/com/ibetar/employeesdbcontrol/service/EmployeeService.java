package com.ibetar.employeesdbcontrol.service;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import com.ibetar.employeesdbcontrol.persistence.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeByUsername (String username) {
        return employeeRepository.findByUsername(username);
    }

    public Employee createEmployee(Employee employee){
        employeeRepository.findByUsername(employee.getUsername()).ifPresentOrElse(
                s-> {
                    System.out.println(s.getUsername() + " :already exist in Database");
                }, ()->{
                    System.out.println("Inserting Employee to Database..." + employee.getFirstname()+ " " +employee.getLastname());
                employeeRepository.insert(employee);
            });
        return employee;
    }

//    public void deleteEmployee(String username){
//        employeeRepository.findByUsername(username.toLowerCase()).ifPresentOrElse(
//                s-> {
//                    System.out.println(s.getUsername() + " :Is being deleted");
//                    employeeRepository.delete();
//                }, ()->{
//                    System.out.println("User with username:" + username.toLowerCase());
//                });
//    }


}
