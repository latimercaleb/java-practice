package hib.eagervslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class EagervsLazyDemo {
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
			int uid = 2; 
			Instructor myInstructor = session.get(Instructor.class, uid);
			// With eager loading on the instructor the object has everything in the memory. One fetch
			// With Lazy, the courses aren't loaded until called for on line 30
			System.out.println("My instructor: " + myInstructor);
			System.out.println(myInstructor.getInstructorName());
			// Fix for lazy loading bug 1: Call getter before session closes, this will cache the data locally and it can be printed or re-used later without trying to lazy load again
			System.out.println(myInstructor.getCourses());
			session.getTransaction().commit();
			// If the courses are called after the session is closed it should through a bad exception for lazy data, eager data doesn't trip this error
			session.close();
			System.out.println(myInstructor.getCourses());
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
