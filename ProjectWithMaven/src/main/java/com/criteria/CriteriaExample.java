package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		
			Criteria c = s.createCriteria(Student.class);
			
			//restriction
			//c.add(Restrictions.eq("cert.course", "Andriod")); //equal
			//c.add(Restrictions.gt("id", 24)); //greaterthan
			c.add(Restrictions.like("certi.course", "java"));
			
			List<Student> students = c.list();
			
			for(Student st:students)
			{
				System.out.println(st);
			}
		
		s.close();
	}

}
