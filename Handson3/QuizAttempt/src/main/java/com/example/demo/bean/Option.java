package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class Option {
	
	@Id
	@Column(name="op_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="op_text")
	private String optionText;
		
	@ManyToOne
	@JoinColumn(name="op_qt_id")
	private Question  question;
	
	@Column(name="op_score")
	private double score;
	
	
	public Option() {
		// TODO Auto-generated constructor stub
	}


	public Option(int id, String optionText, Question question, double score) {
		super();
		this.id = id;
		this.optionText = optionText;
		this.question = question;
		this.score = score;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOptionText() {
		return optionText;
	}


	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Option [id=");
		builder.append(id);
		builder.append(", optionText=");
		builder.append(optionText);
	//	builder.append(", question=");
	//	builder.append(question);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}
	

}
