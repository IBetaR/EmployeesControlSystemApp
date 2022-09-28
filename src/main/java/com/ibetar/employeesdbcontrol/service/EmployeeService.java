package com.ibetar.employeesdbcontrol.service;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import com.ibetar.employeesdbcontrol.persistence.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
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

    @Transactional
    public Employee update(String username, Employee employee) throws Exception {
        try {
            Optional<Employee> entityOptional = employeeRepository.findByUsername(username);
            Employee entityUpdate = entityOptional.get();
            entityUpdate = employeeRepository.save(employee);
            return entityUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

//    @Transactional
//    public boolean delete(String username, Employee employee) throws Exception {
//        try {
//            if (employee.getUsername().matches(username)) {
//                employeeRepository.delete(employee);
//                return true;
//            }
//
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//        return false;
//    }

    @Transactional
    public boolean delete(String id) throws Exception {
        try {
            if (employeeRepository.existsById(id)){
                employeeRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
