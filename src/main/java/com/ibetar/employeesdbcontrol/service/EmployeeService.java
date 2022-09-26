package com.ibetar.employeesdbcontrol.service;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import com.ibetar.employeesdbcontrol.persistence.entity.Role;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Role saveRole(Role role);
    void addRoleToEmployee(String username, String roleName);
    Employee getEmployee(String username);
    List<Employee> getEmployees();
}
