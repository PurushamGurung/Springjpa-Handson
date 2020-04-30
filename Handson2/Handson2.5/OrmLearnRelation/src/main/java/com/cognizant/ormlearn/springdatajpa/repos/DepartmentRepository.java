package com.cognizant.ormlearn.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.springdatajpa.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
