package com.company.controller;

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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	//curl localhost:8080/employeepayrollservice/get -w "\n"
	@GetMapping("/get")
	public ResponseEntity<String> getEmployeePayrollData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	//curl localhost:8080/employeepayrollservice/get/1 -w "\n"
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
		return new ResponseEntity<String>("Get Call Success for id:" + empId, HttpStatus.OK);
	}
	
	// curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary":2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDto) {
		return new ResponseEntity<String>("Created Employee payroll data for:" + employeePayrollDto, HttpStatus.OK);
	}
	
	//curl -X PUT -H "Content-Type: application/json" -d '{"name": "Lisa","salary": 2000}' "http://localhost:8080/employeepayrollservice/update" -w "\n"
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDto) {
		return new ResponseEntity<String>("Updated Employee payroll Data for: " + employeePayrollDto, HttpStatus.OK);
	}
	
	// curl -X DELETE -H "Content-Type: application/json" localhost:8080/employeepayrollservice/delete/1 -w "\n"
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		return new ResponseEntity<String>("Delete Call Success for id: " + empId, HttpStatus.OK);
	}

}