package hib.onetomanyUni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetomany.entity.Course;
import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class CreateOneToManyDemoUni {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("OneToMany.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			// Make objects 
			Instructor teach = new Instructor("Megaman", "X", "x@teach.com");
			InstructorDetail teachDeets = new InstructorDetail("/ttv","Jumping and Shooting");
			
			Instructor teach2 = new Instructor("Zero", "V", "v@teach.com");
			InstructorDetail teachDeets2 = new InstructorDetail("/ttv","Slashing and Jumping");
			
			// Make relation of objects 
			teach.setInstructorDetail(teachDeets);
			teach2.setInstructorDetail(teachDeets2);
			session.beginTransaction();
			session.save(teach);
			session.save(teach2);
			session.getTransaction().commit();
			System.out.println("Session is saved" + teach);
		}
		finally {
			factory.close();
		}
	}
}
