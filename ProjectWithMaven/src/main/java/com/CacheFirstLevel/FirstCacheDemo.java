package CacheFirstLevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;


public class FirstCacheDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//by default first level cache is available
		Student student = session.get(Student.class, 103);
		System.out.println(student);
		
		System.out.println("working Something..................Many code");
		
		//1st level cache demo
		Student student1 = session.get(Student.class, 103);
		System.out.println(student1);

		//check session is there object
		
		System.out.println(session.contains(student1));
		
		session.close();
	}

}
