package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondCacheExample {
	public static void main(String[] args) {
		
		
		
		//Student class 2nd level cache configured
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session1 = factory.openSession();
		
		//first
		Student student1 = session1.get(Student.class, 102);
		System.out.println(student1);		
		System.out.println("-------------------------------1st Session Closed with Query -----------------------------------");
		session1.close();		
		
		
		//second
		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 102);
		System.out.println(student2);
		
				
		
		session2.close();
	}

}
