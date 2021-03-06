package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// createing question
		Question q1 = new Question();
		q1.setQuestion_id(1111);
		q1.setQuestion("What is Java?");

		// Creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(001);
		answer1.setAnswer("java is Programming language");
		answer1.setQuestion(q1);
//        q1.setAnswer(answer1);
		// for many2one
		Answer answer2 = new Answer();
		answer2.setAnswerId(011);
		answer2.setAnswer("java is a OOP Programming language");
		answer2.setQuestion(q1);

		Answer answer3 = new Answer();
		answer3.setAnswerId(111);
		answer3.setAnswer("java has different type of frameworks");
		answer3.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);

		q1.setAnswers(list);

		// Session
//        Session s = factory.openSession();
//        Transaction tx = s.beginTransaction();        
//        //save
//        s.save(q1);
		//
//    	constructor for one to one
//    	public Question(int question_id, String question, Answer answer) {
//    		super();
//    		this.question_id = question_id;
//    		this.question = question;
//    		this.answer = answer;
//    	}

		// Session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		// save
//        s.save(q2); 
//        s.save(answer1);
//        s.save(answer2);

		// for many to 1
//		s.save(q1);
//		s.save(answer1);
//		s.save(answer2);
//		s.save(answer3);


		// fetching
//       System.out.println("--------------------------------------------------------------");
//       Question newQ = (Question) s.get(Question.class, 222);
//       System.out.println(newQ.getQuestion());
//       System.out.println(newQ.getAnswers.getAnswer());
//       System.out.println("--------------------------------------------------------------");
		
//		 fetching from many to 1
//      System.out.println("--------------------------------------------------------------");
//      Question newQ = (Question) s.get(Question.class, 1111);
//      System.out.println(newQ.getQuestion());
//      	for(Answer a:q1.getAnswers());
//      	System.out.println(newQ.getAnswers());
//      System.out.println("--------------------------------------------------------------");

		
		Question q = (Question) s.get(Question.class, 1111);
      
		System.out.println(q.getQuestion_id());
		System.out.println(q.getQuestion());
//		Lazy
		System.out.println(q.getAnswers().size());
		
		tx.commit();
		s.close();

	}
}
