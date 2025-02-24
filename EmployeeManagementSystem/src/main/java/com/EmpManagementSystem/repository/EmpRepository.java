package com.EmpManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmpManagementSystem.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {
	
}