package com.cognizant.ormlearn.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.springdatajpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
