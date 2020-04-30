package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="attempt_option")
@Entity
public class AttemptOption {

	@Id
	@Column(name = "ao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ao_op_id")
	private Option option;

	@ManyToOne
	@JoinColumn(name = "ao_aq_id")
	private AttemptQuestion attemptQuestion;

	@Column(name="ao_selected")
	private boolean selected;

	public AttemptOption() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public AttemptQuestion getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("AttemptOption [id=");
//		builder.append(id);
//		builder.append(", option=");
//		builder.append(option);
//	//	builder.append(", attemptQuestion=");
//	//	builder.append(attemptQuestion);
//		builder.append(", selected=");
//		builder.append(selected);
//		builder.append("]");
//		return builder.toString();
//	}

}
