package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.EmployeePayrollDTO;
import com.company.exception.EmployeePayrollException;
import com.company.model.EmployeePayrollData;
import com.company.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeeRepository;

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
		payrollData = new EmployeePayrollData(employeePayrollDTO);
		log.debug("Emp Data: " + payrollData.toString());
		employeePayrollList.add(payrollData);
		return employeeRepository.save(payrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		payrollData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(payrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		employeeRepository.delete(payrollData);

	}
	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeesById(department);
	}

}