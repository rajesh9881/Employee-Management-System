package com.EmpManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.EmpManagementSystem.model.Employee;
import com.EmpManagementSystem.repository.EmpRepository;
	
	@Service
	public class EmpService {
	    private final EmpRepository empRepository;

	    public EmpService(EmpRepository empRepository) {
	        this.empRepository = empRepository;
	    }

	    public List<Employee> getAllEmployees() {
	        return empRepository.findAll();
	    }

	    public Optional<Employee> getEmployeeById(Long id) {
	        return empRepository.findById(id);
	    }

	    public Employee saveEmployee(Employee employee) {
	        return empRepository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	        empRepository.deleteById(id);
	    }
	    
	    public Employee updateEmployee(Long id, Employee employee) {
	        Optional<Employee> existingEmployee = empRepository.findById(id);
	        if(existingEmployee.isPresent()) {
	            Employee updatedEmployee = existingEmployee.get();
	            updatedEmployee.setName(employee.getName());
	            updatedEmployee.setDepartment(employee.getDepartment());
	            updatedEmployee.setSalary(employee.getSalary());
	            return empRepository.save(updatedEmployee);
	        } else {
	            throw new RuntimeException("Employee not found with id: " + id);
	        }
	    }
	}
