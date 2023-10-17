package com.springboot.demo.EmployeeProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<EmployeeDAO> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Optional<EmployeeDAO> getEmployeeById(Long id) {
		return employeeRepo.findById(id);
	}
	
	public EmployeeDAO creatEmployee(@RequestBody EmployeeDAO employeeDAO) {
		return employeeRepo.save(employeeDAO);
	}
	
	public EmployeeDAO updateEmployee(Long id, EmployeeDAO updatedEmployee) {
		if(employeeRepo.existsById(id)) {
			updatedEmployee.setId(id);
			return employeeRepo.save(updatedEmployee);
		} else {
			throw new EmployeeNotFoundException("Employee id with " + id + " is not found.");
		}
	}
	
	public void deleteEmployee(Long id) {
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
		}
		else {
			throw new EmployeeNotFoundException("Employee id with " + id + " is not found.");
		}
	}
}
