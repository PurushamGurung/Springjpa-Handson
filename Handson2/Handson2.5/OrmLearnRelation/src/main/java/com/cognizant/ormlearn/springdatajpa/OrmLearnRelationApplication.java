package com.cognizant.ormlearn.springdatajpa;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.springdatajpa.model.Department;
import com.cognizant.ormlearn.springdatajpa.model.Employee;
import com.cognizant.ormlearn.springdatajpa.service.DepartmentService;
import com.cognizant.ormlearn.springdatajpa.service.EmployeeService;
import com.cognizant.ormlearn.springdatajpa.service.SkillService;

@SpringBootApplication
public class OrmLearnRelationApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnRelationApplication.class);
	@Autowired
	private static EmployeeService employeeService;

	@Autowired
	private static DepartmentService departmentService;

	@Autowired
	private static SkillService skillService;

	private static void testGetEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");

	}

	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee employee = new Employee();
		Department department = departmentService.get(1);
		employee.setName("Puru");
		employee.setDateOfBirth(new Date(98, 07, 07));
		employee.setSalary(10800d);
		employee.setPermanent(true);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", department);
		LOGGER.info("End");

	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(3);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", department);
		LOGGER.info("END");

	}

	private static void testGetDepartment()
	{
		Department department=departmentService.get(3);
		LOGGER.debug("Department:{}",department);
		LOGGER.debug("Employee:{}",department.getEmployeeList());
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnRelationApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		//testGetEmployee();

		// testAddEmployee();

		//testUpdateEmployee();
		
		testGetDepartment();
	}

}
