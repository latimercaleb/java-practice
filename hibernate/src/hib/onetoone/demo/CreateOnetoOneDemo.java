package hib.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class CreateOnetoOneDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("OneToOne.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			// Make objects 
			Instructor teach = new Instructor("Megaman", "X", "x@teach.com");
			InstructorDetail teachDeets = new InstructorDetail("/ttv","Jumping and Shooting");
			
			Instructor teach1 = new Instructor("Zero", "V", "v@teach.com");
			InstructorDetail teachDeets2 = new InstructorDetail("/ttv","Slashing and Jumping");
			
			// Make relation of objects 
			teach.setInstructorDetail(teachDeets);
			teach1.setInstructorDetail(teachDeets2);
			session.beginTransaction();
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
