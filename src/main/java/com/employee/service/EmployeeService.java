package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(@Valid Employee employee) {
        return employeeRepository.save(employee);
    }

}
