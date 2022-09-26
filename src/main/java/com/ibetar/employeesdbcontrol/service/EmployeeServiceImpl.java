package com.ibetar.employeesdbcontrol.service;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import com.ibetar.employeesdbcontrol.persistence.entity.Role;
import com.ibetar.employeesdbcontrol.persistence.repository.EmployeeRepository;
import com.ibetar.employeesdbcontrol.persistence.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl  implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
//        log.info("saving new user {} to the database" + employee.getFirstname());
//        employee.setPassword(passwordEncoder.);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database"+ role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToEmployee(String username, String roleName) {
//        log.info("Adding role {} to the user {}"+ roleName, username);
//        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(username);
//        Role role = roleRepository.findByName(roleName);
//        employee.get().getRoles().add(role);

    }

    @Override
    public Employee getEmployee(String username) {
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }
}
