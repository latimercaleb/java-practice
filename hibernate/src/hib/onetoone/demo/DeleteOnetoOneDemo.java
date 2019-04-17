package hib.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.onetoone.entity.Instructor;
import hib.onetoone.entity.InstructorDetail;

public class DeleteOnetoOneDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("OneToOne.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		// Make objects 
		int delId = 2;

		try {
			Instructor retiredInstructor = session.get(Instructor.class,delId);
			// Delete object, due to cascading setup, it will delete from both tables
			if(retiredInstructor != null) {
				session.delete(retiredInstructor);
			}else {
				System.out.println("Object is already deleted!");
			}
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}
}
