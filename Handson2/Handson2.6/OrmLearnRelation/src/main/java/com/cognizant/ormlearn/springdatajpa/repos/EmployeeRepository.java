package com.cognizant.ormlearn.springdatajpa.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ormlearn.springdatajpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	


}
