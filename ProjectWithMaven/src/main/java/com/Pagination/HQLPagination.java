package com.Pagination;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Query query= s.createQuery("from Student");
		
		
		//Implement pagination using h9ibernate
		query.setFirstResult(0);
		
		
		query.setMaxResults(5);
		
		List<Student> list = ((org.hibernate.query.Query) query).list();
		for(Student st:list)
		{
			System.out.println(st.getId()+ " : "+st.getName()+" : "+st.getClass());
		}
		
		s.close();
		factory.close();
	}

}
