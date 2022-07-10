package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//
		Student student1=new Student();
		student1.setId(14141);
		student1.setName("Ankit");
		student1.setCity("LKO");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Andriod");
		certificate.setDuration("2 months");
		student1.setCert(certificate);
		//
		//
		Student student2=new Student();
		student2.setId(121221);
		student2.setName("Rabi");
		student2.setCity("Delhi");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("5 months");
		student2.setCert(certificate1);
		//
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		// object save
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
