package com.employee.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "Employee ID is mandatory")
    @Pattern(regexp = "E\\d{3}", message = "Employee ID must follow the format 'E' followed by 3 digits")
	private String employeeId;
	
	
	@NotBlank(message = "First name is mandatory")
	private String firstName;
	
	@NotBlank(message = "Last name is mandatory")
	private String lastName;
	
	@NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
	private String email;
	
	
	@NotEmpty(message = "Phone numbers are mandatory")
	@ElementCollection
	@Pattern(regexp = "\\d{10}", message = "Each phone number must be 10 digits long")
	private List<String> phoneNumbers;
	
	@NotNull(message = "Date of joining is mandatory")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of joining must be in YYYY-MM-DD format")
	private String doj;
	
	@Positive(message = "Salary must be a positive number")
	private Double salary;
	
	public Employee() {}
	

	public Employee(Long id,
			@NotBlank(message = "Employee ID is mandatory") @Pattern(regexp = "E\\d{3}", message = "Employee ID must follow the format 'E' followed by 3 digits") String employeeId,
			@NotBlank(message = "First name is mandatory") String firstName,
			@NotBlank(message = "Last name is mandatory") String lastName,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,
			@NotEmpty(message = "Phone numbers are mandatory") @Pattern(regexp = "\\d{10}", message = "Each phone number must be 10 digits long") List<String> phoneNumbers,
			@NotNull(message = "Date of joining is mandatory") @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of joining must be in YYYY-MM-DD format") String doj,
			@Positive(message = "Salary must be a positive number") Double salary) {
		super();
		Id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.doj = doj;
		this.salary = salary;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", doj=" + doj + ", salary="
				+ salary + ", getId()=" + getId() + ", getEmployeeId()=" + getEmployeeId() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail()
				+ ", getPhoneNumbers()=" + getPhoneNumbers() + ", getDoj()=" + getDoj() + ", getSalary()=" + getSalary()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, doj, email, employeeId, firstName, lastName, phoneNumbers, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(doj, other.doj) && Objects.equals(email, other.email)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumbers, other.phoneNumbers)
				&& Objects.equals(salary, other.salary);
	}
	
	
}
