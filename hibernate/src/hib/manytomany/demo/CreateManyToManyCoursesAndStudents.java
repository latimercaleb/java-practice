package hib.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.manytomany.entity.Review;
import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;
import hib.student.entity.Student;

public class CreateManyToManyCoursesAndStudents {
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
			// Make course then save it, then make students to add to it and save that 
			Course mainCourse = new Course("Java Spring 101");
			session.save(mainCourse);
			System.out.println("Session is saved");
			
			Student firstStudent = new Student("Leon", "Kennedy", "starsL@gmail.com");
			Student nextStudent = new Student("Jill", "Valentine", "starsJ@gmail.com");
			Student lastStudent = new Student("Claire", "Redfield", "starsC@gmail.com");
			
			mainCourse.addStudent(firstStudent);
			mainCourse.addStudent(nextStudent);
			mainCourse.addStudent(lastStudent);
			
			session.save(firstStudent);
			session.save(nextStudent);
			session.save(lastStudent);
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}
}
