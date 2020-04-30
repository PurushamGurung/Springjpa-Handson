package com.cognizant.ormlearn.springdatajpa.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.ormlearn.springdatajpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	//@Query("from Employee e where e.permanent=true")
	//@Query("select e from Employee e where e.permanent=1")
	
	
	@Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1") 
	List<Employee> getAllPermanentEmployees();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e") 
	double getAverageSalary();

	@Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id") 
	double getAverageSalary(@Param("id") int id); 
	
	@Query(value="SELECT * FROM employee", nativeQuery = true) 
	List<Employee> getAllEmployeesNative();
}

