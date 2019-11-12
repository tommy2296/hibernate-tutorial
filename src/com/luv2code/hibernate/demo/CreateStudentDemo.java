package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			System.out.println("Creating object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@email.com");
			// create a student object
			
			
			session.beginTransaction();
			// begin a transaction
			
			
			session.save(tempStudent);			
			// save the student object
			
			
			session.getTransaction().commit();
			// commit a transaction
			
		}
		finally {
			factory.close();
		}
		
	}

}
