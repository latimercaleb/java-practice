package hib.student.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class HQLStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			// Query existing students and display list
			System.out.println("Query 1");
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			printStudents(theStudents);
			// Query students with a specific last name
			System.out.println("Query 2");
			theStudents = session.createQuery("from Student s where s.lastName = 'Bar'").getResultList();
			printStudents(theStudents);
			// Query students with an OR clause 
			System.out.println("Query 3");
			theStudents = session.createQuery("from Student s where s.lastName='Diz' OR s.firstName='Test'").getResultList();
			printStudents(theStudents);
			// Query students with Like clause 
			System.out.println("Query 4");
			theStudents = session.createQuery("from Student s where s.email LIKE 'diz@test.com'").getResultList();
			printStudents(theStudents);
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}

	private static void printStudents(List<Student> theStudents) {
		for (Student theStudent: theStudents) {
			System.out.println(theStudent);
			System.out.println(theStudent.getFirstName());
		}
	}

}
