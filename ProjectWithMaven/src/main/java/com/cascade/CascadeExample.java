package com.cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1 = new Question();
		
		q1.setQuestion_id(6003);
		q1.setQuestion("What is COmputer Sciene");
		
		Answer a1 = new Answer(10141, "1. In CS it is a important concept");
		Answer a2 = new Answer(20242, "2. In CS it is a important concept");
		Answer a3 = new Answer(30444, "3. In CS it is a important concept");
		
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);	
		
		q1.setAnswers(list);
		
		
		//Entity - cascade=CascadeType.ALL
		
		Transaction tx = s.beginTransaction();
				s.save(q1);
				//While using casccade we dont need to specify answer 
//				s.save(a1);
//				s.save(a2);
//				s.save(a3);
				
		tx.commit();
		s.close();
		factory.close();
	}
	
}
