package hib.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.manytomany.entity.Review;
import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.student.entity.Student;

public class GetCoursesForStudent {
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
			// To add courses they must have an instructor ID as a foreign key, fetch the instructor first
			int uid = 13; 
			Student theStudent = session.get(Student.class, uid);
			System.out.println(theStudent.getFirstName() + ", " + theStudent.getLastName());
			System.out.println("The Courses: " + theStudent.getCourses());
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
