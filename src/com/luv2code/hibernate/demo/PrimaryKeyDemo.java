package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				
				try {
					
					System.out.println("Creating objects...");
					Student tempStudent1 = new Student("John", "Doe", "paul@email.com");
					Student tempStudent2 = new Student("Mary", "Public", "mary@email.com");
					Student tempStudent3 = new Student("Scott", "Tiger", "scott@email.com");
					// create 3 student objects
					
					
					session.beginTransaction();
					// begin a transaction
					
					
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					// save the student object
					
					
					session.getTransaction().commit();
					// commit a transaction
					
				}
				finally {
					factory.close();
				}
				
			}
	}

