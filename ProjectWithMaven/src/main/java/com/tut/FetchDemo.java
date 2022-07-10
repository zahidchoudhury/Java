package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		// get & load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//get-student-106
		//load
		Address ad= (Address)session.load(Address.class, 1);
		System.out.println(ad);
		System.out.println(ad.getStreet()+" : "+ad.getCity());
		//get
		Student student= (Student)session.get(Student.class, 102);
		System.out.println(student);
		System.out.println(student.getName()+":"+student.getCity());


		
		
		session.close();
		factory.close();
		
		System.out.println("------------------Done------------------");
	

	}

}
