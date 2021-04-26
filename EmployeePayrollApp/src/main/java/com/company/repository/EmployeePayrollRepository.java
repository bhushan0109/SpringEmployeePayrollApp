package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

}