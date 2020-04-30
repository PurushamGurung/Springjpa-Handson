package com.example.demo.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="us_name")
	private String name;
	
	@Column(name="us_email")
	private String email;
	
	
	@OneToMany(mappedBy = "user")
			//,	fetch = FetchType.EAGER)
	private Set<Attempt> attemptList;
	//private List<Attempt> attemptList;
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Set<Attempt> getAttemptList() {
		return attemptList;
	}

	public void setAttemptList(Set<Attempt> attemptList) {
		this.attemptList = attemptList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append("]");
		return builder.toString();
	}
	
	

}
