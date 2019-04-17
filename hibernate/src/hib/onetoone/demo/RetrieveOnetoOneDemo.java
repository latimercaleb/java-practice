package hib.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class RetrieveOnetoOneDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("OneToOne.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			// Make object for detail
			int fetchId = 1;
			InstructorDetail teachDeets = session.get(InstructorDetail.class, fetchId);
			// Make relation of objects 
			teach.setInstructorDetail(teachDeets);
			teach1.setInstructorDetail(teachDeets2);
			
			session.save(teach);
			session.save(teach1);
			session.getTransaction().commit();
			System.out.println("Session is saved" + teach);
		}
		finally {
			factory.close();
		}
	}
}
