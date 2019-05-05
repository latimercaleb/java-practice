package hib.eagervslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class HQLLazyLoadingDemo {
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
			// Another option for handling queries in this one would be to query with HQL 
			int uid = 2;
			Query<Instructor> query = session.createQuery("SELECT i from Instructor i " + "JOIN FETCH i.Courses " + "WHERE i.id=:theInstructorId",Instructor.class);
			query.setParameter("theInstructorId",uid);
			
			Instructor myTeach = query.getSingleResult();
			System.out.println("Who are ya? " + myTeach.getFirstName());
			session.getTransaction().commit();
			session.close();
			System.out.println("Courses via lazy load: " + myTeach.getCourses());
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
