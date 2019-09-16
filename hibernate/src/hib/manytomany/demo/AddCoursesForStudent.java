package hib.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.manytomany.entity.Review;
import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.student.entity.Student;

public class AddCoursesForStudent {
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
			// Retrieve student,make more courses, add student to those courses
			int id = 13;
			Student customStudent = session.get(Student.class, id);
			Course elective = new Course ("Angular 101");
			elective.addStudent(customStudent);
			session.save(elective);
		
			session.getTransaction().commit();
		
		}
		finally {
			factory.close();
		}
	}
}
