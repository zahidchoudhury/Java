package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

/**
 * @author zahid
 *
 */
public class StateDemo {
	
//												Transient state
//												persistent state
//												detached state
//												removed state
//												
//												session object
//												database
	
	public static void main(String[] args) {
		System.out.println("Example: ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating student object
		Student student= new Student();
		student.setId(1414);
		student.setName("New Me");
		student.setCity("New Delhi");
		student.setCert(new Certificate("Java Hibernate", "2 month"));
		//Student : Transient
		
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//Student : Persistent - Session, database
		student.setName("John");
		
		
		
		tx.commit();
		
		
		//get then remove
		
		
		s.close();
		
		//Detached
		student.setName("Sachin");
		System.out.println(student);
		
		
		f.close();
		
	
	}
	

}
