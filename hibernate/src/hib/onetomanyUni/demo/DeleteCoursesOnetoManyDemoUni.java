package hib.onetomanyUni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.onettomany.entity.Review;

public class DeleteCoursesOnetoManyDemoUni {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("OneToManyUni.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			// Make object for detail
			int fetchId = 10;
			Course delCourse = session.get(Course.class, fetchId);
			System.out.println("Deleting Course Details " + delCourse.getReviews());
			System.out.println("Deleting Course " + delCourse.getTitle());
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
