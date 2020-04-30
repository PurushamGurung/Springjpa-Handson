package com.example.demo.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	@Id
	@Column(name="qt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="qt_text")
	private String questionText;
	
	//@OrderBy(value="id")
	@OneToMany(mappedBy = "question")
	private Set <Option> optionList;
	
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	

	public Question(int id, String questionText) {
		super();
		this.id = id;
		this.questionText = questionText;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public Set<Option> getOptionList() {
		return optionList;
	}


	public void setOptionList(Set<Option> optionList) {
		this.optionList = optionList;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [id=");
		builder.append(id);
		builder.append(", questionText=");
		builder.append(questionText);
		
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
