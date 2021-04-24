package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.dto.EmployeePayrollDTO;
import com.company.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	//get all
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}
	
	//get by id
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.get(empId - 1);
	}
	
	//create
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = null;
		payrollData = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
		employeePayrollList.add(payrollData);
		return payrollData;
	}
	
	//update
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		payrollData.setName(employeePayrollDTO.name);
		payrollData.setSalary(employeePayrollDTO.salary);
 		employeePayrollList.set(empId - 1, payrollData);
		return payrollData;
	}
	
	//delete
	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId - 1);

	}

}