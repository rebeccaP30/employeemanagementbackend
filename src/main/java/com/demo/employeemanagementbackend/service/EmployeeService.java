package com.demo.employeemanagementbackend.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.employeemanagementbackend.model.Employee;
import com.demo.employeemanagementbackend.repository.EmployeeRepository;

import Exception.CustomException;
import Exception.CustomException.EmployeeAlreadyExistsException;
import dtos.EmployeeDto;
import mapper.EmployeeMapper;
import utilility.MessageConstants;


@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    //@Autowired
    //private KafkaConsumer kafkaConsumer;

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    //private static final String EMPLOYEE_TOPIC = "employee_topic";
    
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (employeeRepository.findByFirstNameAndLastNameAndEmail(
                employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail()).isPresent()) {
            throw new EmployeeAlreadyExistsException(MessageConstants.EMPLOYEE_ALREADY_EXISTS);
        }

        Employee employee = employeeMapper.toEntity(employeeDto);
        employee = employeeRepository.save(employee);
        
        //kafkaConsumer.consume(String message);
        return employeeMapper.toDto(employee);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomException(MessageConstants.EMPLOYEE_NOT_FOUND));  
        employeeDto.setId(id);
        employeeMapper.updateEmployeeFromDto(employeeDto, employee);
        employee = employeeRepository.save(employee);
        
       // messageSender.sendMessage(EMPLOYEE_TOPIC, "employee updated: " + id);
        return employeeMapper.toDto(employee);
    }

    @Override
    @Transactional
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomException(MessageConstants.EMPLOYEE_NOT_FOUND));
        return employeeMapper.toDto(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new CustomException(MessageConstants.EMPLOYEE_NOT_FOUND);
        }
        employeeRepository.deleteById(id);
        
        //messageSender.sendMessage(EMPLOYEE_QUEUE, "Employee deleted: " + id);
    }
}
