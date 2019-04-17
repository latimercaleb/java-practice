package hib.onetomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class RetrieveOneToManyCoursesandInstructors {
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
			// To add courses they must have an instructor ID as a foreign key, fetch the instructor first
			int uid = 2; 
			Instructor myInstructor = session.get(Instructor.class, uid);
			System.out.println(myInstructor.getInstructorName());
			System.out.println(myInstructor.getCourses());
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
