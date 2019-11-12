package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@quack.com");
			// create a student object
			
			
			session.beginTransaction();
			// begin a transaction
			
			
			session.save(tempStudent);			
			// save the student object
			
			
			session.getTransaction().commit();
			// commit a transaction
			
			
			
			// Now we're retrieving the object
			
			// find the object
			System.out.println("Saved student with primary key: " + tempStudent.getId());
			
			// now get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			// start a transaction
			
			// retrieve a student based on id
			System.out.println("Getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
