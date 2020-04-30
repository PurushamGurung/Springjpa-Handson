package com.example.demo.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "attempt_question")
@Entity
public class AttemptQuestion {

	@Id
	@Column(name = "aq_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "aq_at_id")
	private Attempt attempt;

	@ManyToOne
	@JoinColumn(name = "aq_qt_id")
	private Question question;
	
	@OneToMany(mappedBy = "attemptQuestion",fetch = FetchType.EAGER)
	private Set<AttemptOption>  attemptOptionList; 

	public AttemptQuestion() {
		// TODO Auto-generated constructor stub
	}

	public AttemptQuestion(int id, Attempt attempt, Question question) {
		super();
		this.id = id;
		this.attempt = attempt;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}

	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("AttemptQuestion [id=");
//		builder.append(id);
//		builder.append(", attempt=");
//		builder.append(attempt);
//		builder.append(", question=");
//		builder.append(question);
//		builder.append("]");
//		return builder.toString();
//	}

}
