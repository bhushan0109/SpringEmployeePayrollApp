package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.EmployeePayrollDTO;
import com.company.dto.ResponseDTO;
import com.company.model.EmployeePayrollData;
import com.company.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> payrollData = null;
		payrollData = employeePayrollService.getEmployeePayrollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	// curl localhost:8080/employeepayrollservice/get/1 -w "\n"

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData payrollData = null;
		payrollData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	//curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary":2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = null;
		payrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	// curl -X PUT -H "Content-Type: application/json" -d '{"name": "bhushan","salary": 21000}' "http://localhost:8080/employeepayrollservice/update/1" -w "\n"
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData updateEmployeePayrollData = null;
		updateEmployeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", updateEmployeePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	//curl -X DELETE -H "Content-Type: application/json" localhost:8080/employeepayrollservice/delete/1 -w "\n"
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "empId " + empId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}