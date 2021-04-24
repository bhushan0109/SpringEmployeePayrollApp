package com.company.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class EmployeePayrollDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	public String name;

	@Min(value = 500, message = "Min wage should be more than 500")
	public long salary;

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}

}