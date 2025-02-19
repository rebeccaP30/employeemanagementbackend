package com.demo.employeemanagementbackend.service;
import java.util.List;

import dtos.EmployeeDto;

public interface EmployeeServiceInterface {
	List<EmployeeDto> getAllEmployees();
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long id);
	void deleteEmployee(Long id);
}
