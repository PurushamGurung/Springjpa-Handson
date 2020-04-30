package com.cognizant.ormlearn.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="stock")
public class Stock {
	@Id
	@Column(name = "st_id")
	private Integer id;
	
	@Column(name="st_code")
	private String stcode;
	
	@Column(name="st_date")
	private Date stdate;
	
	@Column(name="st_open")
	private Double stopen;
	
	@Column(name="st_close")
	private Double stclose;
	
	@Column(name="st_volume")
	private Double stvolume;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStcode() {
		return stcode;
	}

	public void setStcode(String stcode) {
		this.stcode = stcode;
	}

	public Date getStdate() {
		return stdate;
	}

	public void setStdate(Date stdate) {
		this.stdate = stdate;
	}

	public Double getStopen() {
		return stopen;
	}

	public void setStopen(Double stopen) {
		this.stopen = stopen;
	}

	public Double getStclose() {
		return stclose;
	}

	public void setStclose(Double stclose) {
		this.stclose = stclose;
	}

	public Double getStvolume() {
		return stvolume;
	}

	public void setStvolume(Double stvolume) {
		this.stvolume = stvolume;
	}

	

}
