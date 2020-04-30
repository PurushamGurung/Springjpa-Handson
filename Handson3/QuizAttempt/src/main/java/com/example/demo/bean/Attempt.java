package com.example.demo.bean;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attempt")
public class Attempt {
	@Id
	@Column(name = "at_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "at_us_id")
	private User user;

	@Column(name = "at_date")
	private Date dateOfattempt;

	@Column(name = "at_score")
	private double score;
	
	
	@OneToMany(mappedBy = "attempt")
	private Set<AttemptQuestion> attemptQuestionList;
	
	
	
	
	public Attempt() {
		// TODO Auto-generated constructor stub
	}

	public Attempt(int id, User user, Date dateOfattempt, double score) {
		super();
		this.id = id;
		this.user = user;
		this.dateOfattempt = dateOfattempt;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateOfattempt() {
		return dateOfattempt;
	}

	public void setDateOfattempt(Date dateOfattempt) {
		this.dateOfattempt = dateOfattempt;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	
	
	

	public Set<AttemptQuestion> getAttemptQuestionList() {
		return attemptQuestionList;
	}

	public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
		this.attemptQuestionList = attemptQuestionList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Attempt [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", dateOfattempt=");
		builder.append(dateOfattempt);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}
	
	

}
