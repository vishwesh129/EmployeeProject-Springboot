package com.springboot.demo.EmployeeProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeDAO, Long>{

}
