package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) throws IOException    {
        System.out.println( "Project Started" );
        
        //SessionFactory factory=new Configuration().configure().buildSessionFactory();
        //or
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(102);
        st.setCity("Silchar");
        st.setName("Zahid");
        
        //System.out.println(st);
        
        //Creating object of address class
        Address ad = new Address();
        ad.setStreet("street11232");
        ad.setCity("Silchar");
        ad.setOpen(false);
        ad.setAddedDate(new Date());
        ad.setMarks(12223.33);
                //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/Img/1.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);        
        
        
        
        
        ////Datebase hibernate connection
        //Session session = factory.getCurrentSession();
        Session session = factory.openSession();
        //               
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(st);	//student table
        session.save(ad);	//student address table 
        
        //session.getTransaction().commit();
        tx.commit();

//        System.out.println(factory);  // Found Object org.hibernate.internal.SessionFactoryImpl@18a645fd
//        System.out.println(factory.isClosed());         

        
        System.out.println("-------------------------------done----------------------------------");
    }
}
