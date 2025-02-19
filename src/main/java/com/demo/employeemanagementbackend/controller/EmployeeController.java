package com.demo.employeemanagementbackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeemanagementbackend.service.EmployeeService;

import dtos.EmployeeDto;
import dtos.Response;
import jakarta.validation.Valid;
import utilility.MessageConstants;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:3000/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/view")
    public ResponseEntity<Response<List<EmployeeDto>>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        Response<List<EmployeeDto>> response = new Response<>("success", MessageConstants.EMPLOYEES_RETRIEVED_SUCCESS, employees);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Response<EmployeeDto>> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
    	EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        Response<EmployeeDto> response = new Response<>("success", MessageConstants.EMPLOYEE_CREATED_SUCCESS, createdEmployee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Response<EmployeeDto>> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        Response<EmployeeDto> response = new Response<>("success", MessageConstants.EMPLOYEE_RETRIEVED_SUCCESS, employee);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response<EmployeeDto>> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        Response<EmployeeDto> response = new Response<>("success", MessageConstants.EMPLOYEE_UPDATED_SUCCESS, updatedEmployee);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Void>> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        Response<Void> response = new Response<>("success", MessageConstants.EMPLOYEE_DELETED_SUCCESS, null);
        return ResponseEntity.ok(response);
    }
}
