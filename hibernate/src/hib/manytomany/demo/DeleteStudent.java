package hib.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.manytomany.entity.Review;
import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.student.entity.Student;

public class DeleteStudent {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("ManyToMany.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();


		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			// Delete Student
			int fetchId = 13;
			Student delStudent = session.get(Student.class, fetchId);
			session.delete(delStudent);
			session.getTransaction().commit();
		}
		catch(Exception exc) {
			System.out.println("Issue detected");
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
