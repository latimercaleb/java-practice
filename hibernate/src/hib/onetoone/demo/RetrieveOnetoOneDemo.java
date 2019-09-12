package hib.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class RetrieveOnetoOneDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("OneToOne.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			// Make object for detail
			int fetchId = 3;
			// Test of error handling, close session and catch exception if id is out of range
			// int fetchId = 300;
			InstructorDetail teachDeets = session.get(InstructorDetail.class, fetchId);
			// Use detail methods to support fetching for bidrectional
			System.out.println("Instructor Details " + teachDeets.getDetails());
			System.out.println("Instructor " + teachDeets.getInstructor().getInstructorName());
			session.getTransaction().commit();
		}
		catch(Exception exc) {
			System.out.println("Issue detected");
			exc.printStackTrace();
		}
		finally { // Resolves potential memory leaks
			session.close();
			factory.close();
		}
	}
}
