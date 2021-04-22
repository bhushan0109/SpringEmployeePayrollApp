package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.dto.EmployeePayrollDTO;
import com.company.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> payrollDatas = new ArrayList<>();
		payrollDatas.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj", 300000)));
		return payrollDatas;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData payrollDatas = null;
		payrollDatas = new EmployeePayrollData(2, new EmployeePayrollDTO("Bhushan", 40000));
		return payrollDatas;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = null;
		payrollData = new EmployeePayrollData(3, employeePayrollDTO);
		return payrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = null;
		payrollData = new EmployeePayrollData(3, employeePayrollDTO);
		return payrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub

	}

}