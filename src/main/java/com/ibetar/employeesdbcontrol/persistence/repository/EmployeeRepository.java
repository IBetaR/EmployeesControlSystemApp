package com.ibetar.employeesdbcontrol.persistence.repository;

import com.ibetar.employeesdbcontrol.persistence.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findEmployeeByUsername (String username);

}
