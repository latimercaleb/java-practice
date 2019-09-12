package hib.onetomanyUni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.onettomany.entity.Review;

public class CreateOneToManyCoursesUni {
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
			// Adding course, then review in one cascading create
			Course firstCourse = new Course("Dark Souls: Prepare to live");
			firstCourse.addReview(new Review("Excellent info"));
			firstCourse.addReview(new Review("Geez this is so in depth! Dope!"));
			firstCourse.addReview(new Review("What noob needs this?"));
			
			session.save(firstCourse);
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
