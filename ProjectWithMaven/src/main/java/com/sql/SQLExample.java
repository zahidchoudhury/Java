package com.sql;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		//SQL Query
		String q ="select * from student"; //cntr+1
		
		NativeQuery nq = s.createSQLQuery(q);
		List<Object[]> list = nq.list(); //getResult can be used here
		for(Object[] student:list)
		{
			System.out.println(Arrays.deepToString(student));
		}
		
		
		
		s.close();
		factory.close();
	}

}
