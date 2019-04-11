package hib.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class DeleteStudents {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			// Method 1: Fetch Object and delete
			session.beginTransaction();
			Student deadStudent = session.get(Student.class, 1);
			System.out.println("Student being deleted is: " + deadStudent.getFirstName() + " , " + deadStudent.getLastName());
			session.delete(deadStudent);
			session.getTransaction().commit();
			
			// Method 2: Delete object via hql
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("DELETE from Student st WHERE st.id = 5").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Session is saved");
		}
		finally {
			factory.close();
		}
	}

}
