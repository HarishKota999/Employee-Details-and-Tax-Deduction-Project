package com.employee.entity;

import java.util.Objects;

public class TaxDeductionResponse {
	
	private String employeeId;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double taxAmount;
    private double cessAmount;
    
    public TaxDeductionResponse() {}
    
	public TaxDeductionResponse(String employeeId, String firstName, String lastName, double yearlySalary,
			double taxAmount, double cessAmount) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
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
	public double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public String toString() {
		return "TaxDeductionResponse [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cessAmount, employeeId, firstName, lastName, taxAmount, yearlySalary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxDeductionResponse other = (TaxDeductionResponse) obj;
		return Double.doubleToLongBits(cessAmount) == Double.doubleToLongBits(other.cessAmount)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName)
				&& Double.doubleToLongBits(taxAmount) == Double.doubleToLongBits(other.taxAmount)
				&& Double.doubleToLongBits(yearlySalary) == Double.doubleToLongBits(other.yearlySalary);
	}
    
    

}
