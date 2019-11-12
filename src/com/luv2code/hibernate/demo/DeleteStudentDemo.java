package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			int studentId = 4;
			
			// now get a new session
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			// start a transaction
			
			// retrieve a student based on id
			System.out.println("Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
			// BULK UPDATE DELETE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where email LIKE 'foo@gamil.com'").executeUpdate();
			
			
			// commit
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
