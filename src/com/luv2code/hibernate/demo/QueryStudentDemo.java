package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
			// begin a transaction
			
			
			// query student
			List<Student> theStudents;
			theStudents = session.createQuery("from Student s WHERE s.email LIKE '%email.com'").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students wtih lastName='Doe' or firstName = 'Daffy'
			theStudents = session.createQuery("from Student s where "
					+" s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			// commit a transaction
			
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents ) {
			System.out.println(tempStudent);
		}
	}

}
