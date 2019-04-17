package hib.onetomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class DeleteCoursesOnetoManyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("OneToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			// Make object for detail
			int fetchId = 10;
			Course delCourse = session.get(Course.class, fetchId);
			System.out.println("Deleting Instructor Details " + delCourse.getCourseDetails());
			System.out.println("Deleting Instructor " + delCourse.getInstructor().getInstructorName());
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
