package hib.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		// Create factor and new session
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		// Use try finally to retrieve data and close connection
		try {
			// use session object to handle obj and commit it to the database
			Student student = new Student("Foo", "Bar", "test@test.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}

}
