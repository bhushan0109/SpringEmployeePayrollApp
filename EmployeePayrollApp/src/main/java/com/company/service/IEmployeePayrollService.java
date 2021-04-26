package com.company.service;

import java.util.List;

import com.company.dto.EmployeePayrollDTO;
import com.company.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

	void deleteEmployeePayrollData(int empId);

	List<EmployeePayrollData> getEmployeesByDepartment(String department);

}