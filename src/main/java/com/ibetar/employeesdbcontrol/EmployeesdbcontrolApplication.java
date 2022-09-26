package com.ibetar.employeesdbcontrol;

import com.ibetar.employeesdbcontrol.persistence.entity.*;
import com.ibetar.employeesdbcontrol.persistence.repository.EmployeeRepository;
import com.ibetar.employeesdbcontrol.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class EmployeesdbcontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesdbcontrolApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(EmployeeRepository repository, MongoTemplate mongoTemplate, EmployeeService employeeService){
		return args -> {

			String username = "aru";
			Address address = new Address(
					"Venezuela",
					"Barinas",
					"5201"
			);
			String email = "aru@gmail.com";
			Employee employee = new Employee(
					null,
					username,
					"password",
					"Aruma",
					"Betancourt",
					email,
					Gender.FEMALE,
					address,
					LocalDateTime.now(),
					EmployeeRole.ADMIN,
					"null");


			repository.findEmployeeByUsername(email).ifPresentOrElse(
					s-> {
						System.out.println(s + "already exist in Database");
					}, () -> {
						System.out.println("Inserting Employee to Database..." + employee.getFirstname()+ " " +employee.getLastname());
						repository.insert(employee);
					}
			);
		};

	}

}
