package com.cognizant.ormlearn.springdatajpa;

import java.sql.Date;
import java.util.List;

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
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");

	}
	private static void testAddSkillToEmployee()
	{
		Employee employee=employeeService.get(6);//"employee has no skill"
		
		employee.getSkillList().add(skillService.get(1));
		employeeService.save(employee);
		
	}
	
	private static void testGetAverageSalary()
	{
		LOGGER.debug("Average Salary",employeeService.getAverageSalary());
		
	}
	
	private static void testGetAverageSalary(int id)
	{
		LOGGER.debug("Avrage Salary of Dept_id :: 3",employeeService.getAverageSalary(id));
	}
	
	private static void testGetAllEmployeeNative()
	{
		LOGGER.debug("NATIVE Employee Query {}",employeeService.getAllEmployeeNative());
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
	
	public static void testGetAllPermanentEmployees() { 

		LOGGER.info("Start"); 
		List<Employee> employees = employeeService.getAllPermanentEmployees(); 
		LOGGER.debug("Permanent Employees:{}", employees); 
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList())); 
		LOGGER.info("End"); 
		} 
	 
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnRelationApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		//testGetEmployee();

		// testAddEmployee();

		//testUpdateEmployee();
		
		//testGetDepartment();
		//testAddSkillToEmployee();
		//testGetAllPermanentEmployees();
//		testGetAverageSalary();
//		testGetAverageSalary(3);
		testGetAllEmployeeNative();
		
	}

}
