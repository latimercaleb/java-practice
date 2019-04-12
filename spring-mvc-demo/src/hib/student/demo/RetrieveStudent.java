package hib.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class RetrieveStudent {

	public static void main(String[] args) {
		// Create factor and new session
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			Student student = new Student("Test", "ForGet", "get@test.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Session is saved");
			System.out.println("Print ID: " + student.getId());
			// Now retrieve that student with new session since we already committed the previous one
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student fetchedStudent = session.get(Student.class, student.getId());
			System.out.println("Fetched student is: "+ fetchedStudent);
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
