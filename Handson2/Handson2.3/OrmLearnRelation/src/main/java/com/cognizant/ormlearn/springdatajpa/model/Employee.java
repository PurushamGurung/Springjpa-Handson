package com.cognizant.ormlearn.springdatajpa.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "em_id")
	private int id;
	@Column(name = "em_name")
	private String name;
	@Column(name = "em_salary")
	private double salary;
	@Column(name = "em_permanent")
	private boolean permanent;
	@Column(name = "em_date_of_birth")
	private Date dateOfBirth;
}
