package com.demo.employeemanagementbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.demo.employeemanagementbackend", "config"})
@EnableJpaAuditing
public class EmployeemanagementbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementbackendApplication.class, args);
	}

}
