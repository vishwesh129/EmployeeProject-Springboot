package com.springboot.demo.EmployeeProject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	// Get all employees
	@GetMapping("/")
	public List<EmployeeDAO> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	// get employee by id rest api
	@GetMapping("/{id}")   
	public EmployeeDAO getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
	}
	
	// create employee
	@PostMapping("/employee")
	public EmployeeDAO creatEmployee(@RequestBody EmployeeDAO employeeDAO) {
		return employeeService.creatEmployee(employeeDAO);
	}
	
	// update employee details
	@PutMapping("/employee/{id}")
	public EmployeeDAO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDAO updatedEmployee) {
		return employeeService.updateEmployee(id, updatedEmployee);
	}
	
	// delete employee
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " has been deleted.";

	}
	
}