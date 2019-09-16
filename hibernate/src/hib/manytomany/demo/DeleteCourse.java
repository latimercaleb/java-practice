package hib.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.manytomany.entity.Review;
import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.student.entity.Student;

public class DeleteCourse {
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
			// Delete Course
			int fetchId = 16;
			Course delCourse = session.get(Course.class, fetchId);
			session.delete(delCourse);
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
