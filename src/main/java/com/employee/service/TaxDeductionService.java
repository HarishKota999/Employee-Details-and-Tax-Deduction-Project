package com.employee.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.entity.TaxDeductionResponse;
import com.employee.repository.EmployeeRepository;

@Service
public class TaxDeductionService {
	
	
	@Autowired
    private EmployeeRepository employeeRepository;

    public TaxDeductionResponse getTaxDeductions(String employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }

        double yearlySalary = employee.getSalary() * getMonthsWorked(employee.getDoj());
        double taxAmount = calculateTax(yearlySalary);
        double cessAmount = calculateCess(yearlySalary);

        return new TaxDeductionResponse(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                yearlySalary,
                taxAmount,
                cessAmount
        );
    }

    private double calculateTax(double salary) {
        if (salary <= 250000) return 0;
        if (salary <= 500000) return (salary - 250000) * 0.05;
        if (salary <= 1000000) return 12500 + (salary - 500000) * 0.10;
        return 37500 + (salary - 1000000) * 0.20;
    }

    private double calculateCess(double salary) {
        if (salary > 2500000) {
            return (salary - 2500000) * 0.02;
        }
        return 0;
    }

    private long getMonthsWorked(String doj) {
        LocalDate joiningDate = LocalDate.parse(doj);
        LocalDate currentDate = LocalDate.now();
        long totalDays = ChronoUnit.DAYS.between(joiningDate, currentDate);
        return totalDays / 30;
    }
}

