package hib.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class PrimaryKeyPractice {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			// Each student will get unique id that is auto-incremented via sql
			Student student = new Student("Foo", "Bar", "bar@test.com");
			Student student2 = new Student("Baz", "Tango", "tango@test.com");
			Student student3 = new Student("Quux", "Diz", "diz@test.com");
			session.beginTransaction();
			session.save(student);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("Session is saved");
		} finally {
			factory.close();
		}

	}

}
