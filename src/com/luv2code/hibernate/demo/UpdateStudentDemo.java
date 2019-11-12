package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			int studentId = 1;
			
			// now get a new session
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			// start a transaction
			
			// retrieve a student based on id
			System.out.println("Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student " + myStudent);
			
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			// BULK UPDATE TRANSACTION
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gamil.com' where email LIKE '%email.com'").executeUpdate();
			
			
			// commit
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
