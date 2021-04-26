package com.company.model;

import java.time.LocalDate;
import java.util.List;

import com.company.dto.EmployeePayrollDTO;

import lombok.Data;
@Data
public class EmployeePayrollData {

	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;

	public EmployeePayrollData() {

	}

	public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		this.employeeId = employeeId;
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender = employeePayrollDTO.gender;
		this.startDate = employeePayrollDTO.startDate;
		this.note = employeePayrollDTO.note;
		this.profilePic = employeePayrollDTO.profilePic;
		this.departments = employeePayrollDTO.departments;
	}

}