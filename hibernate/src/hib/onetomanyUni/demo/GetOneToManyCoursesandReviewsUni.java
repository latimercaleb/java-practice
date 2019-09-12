package hib.onetomanyUni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.onettomany.entity.Review;

public class GetOneToManyCoursesandReviewsUni {
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
			int uid = 10; 
			Course myClass= session.get(Course.class, uid);
			System.out.println(myClass.getReviews());

			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
