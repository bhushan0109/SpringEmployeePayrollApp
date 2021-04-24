package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.dto.EmployeePayrollDTO;
import com.company.exception.EmployeePayrollException;
import com.company.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = null;
		payrollData = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
		employeePayrollList.add(payrollData);
		return payrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		payrollData.setName(employeePayrollDTO.name);
		payrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empId - 1, payrollData);
		return payrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId - 1);

	}

}