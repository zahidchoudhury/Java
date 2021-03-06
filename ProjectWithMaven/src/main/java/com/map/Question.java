package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int question_id;	
	private String question;
	
	//For one to one
//	@OneToOne
//	@JoinColumn(name="a_id")
//	private Answer answer;
	
	//for many to one
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)   //doesnt work mappedBy = "question",
	@JoinColumn(name="a_id")
	private List<Answer> answers;
	

	public Question(int question_id, String question, List<Answer> answers) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.answers = answers;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
		
	}
//	constructor for one to one
//	public Question(int question_id, String question, Answer answer) {
//		super();
//		this.question_id = question_id;
//		this.question = question;
//		this.answer = answer;
//	}
//	public Answer getAnswer() {
//		return answer;
//	}
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
