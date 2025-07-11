package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> 
{
	
}
