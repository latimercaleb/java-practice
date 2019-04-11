package hib.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class UpdateStudents {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			// Method 1: Auto-update via commit
			int sId = 1;
			session.beginTransaction();
			// Fetch a student
			Student firstStudent = session.get(Student.class, sId);
			// Call Setter to change object
			firstStudent.setFirstName("Claire");
			// Saving transaction saves to database
			session.getTransaction().commit();
			// Method 2: HQL + execute 
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='updatedTest@testMail.com'").executeUpdate();
			session.getTransaction().commit();
			
			// Update modified bulk update 
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student as st set st.email='reworked@test.com' WHERE st.id >= 3 AND st.id < 5").executeUpdate();
			session.getTransaction().commit();
			
			
			System.out.println("Session is updated");
		}
		finally {
			factory.close();
		}
	}

}
