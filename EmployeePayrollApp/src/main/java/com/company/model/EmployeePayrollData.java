package com.company.model;

import com.company.dto.EmployeePayrollDTO;

import lombok.Data;
@Data
public class EmployeePayrollData {

	private int employeeId;
	private String name;
	private long salary;

	public EmployeePayrollData() {
		// TODO Auto-generated constructor stub
	}

	public EmployeePayrollData(int employeeId, String name, long salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

	public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.employeeId = employeeId;
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
	}

}