package com.employee.resetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.entity.TaxDeductionResponse;
import com.employee.service.EmployeeService;
import com.employee.service.TaxDeductionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
    private TaxDeductionService taxDeductionService;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Employees";
	}
  
	@PostMapping
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
	
	@GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<TaxDeductionResponse> getTaxDeductions(@PathVariable String employeeId) {
        TaxDeductionResponse response = taxDeductionService.getTaxDeductions(employeeId);
        return ResponseEntity.ok(response);
    }
}
