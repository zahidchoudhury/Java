package com.HQL;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		// COnfiguration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		// Session
		Session s = factory.openSession();

		// HQL Syntax
		//select
		String query = "from Student as s where s.city =:x and s.name=:n";
		Query q = s.createQuery(query);
		q.setParameter("x", "New Delhi");
		q.setParameter("n", "John");

		// single result- unique
		// multiple result- list
		List<Student> list = ((org.hibernate.query.Query) q).list();

		for (Student student : list) {
			System.out.println(student.getName()+ " : " +student.getCert().getCourse());
		}
		
		//delete
		System.out.println("_______________________________________________________");
//		 
//		Transaction tx = s.beginTransaction();
//		Query q2 = s.createQuery("delete from Student as s where s.city=:c");
//		q2.setParameter("c", "New Delhi");
//		int r = q2.executeUpdate();
//		System.out.println("Deleted : "+r);
//		tx.commit();
		//
		
		//update
//		System.out.println("_______________________________________________________");
//		 
//		Transaction tx = s.beginTransaction();
//		Query q3 = s.createQuery("update Student set city=:c where name=:n");
//		q3.setParameter("c", "Delhi");
//		q3.setParameter("n", "Peter");
//
//		int r = q3.executeUpdate();
//		System.out.println("Object Updated : "+r);
//		tx.commit();
		//
		
		//Join Column
		//one to many
		Query q4 = s.createQuery("select q.question, q.question_id, a.answer from Question as q INNER JOIN q.answers as a");


		List<Object[]> list3 = q4.getResultList();
		for(Object[] arr:list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		
		s.close();
		factory.close();

	}

}
