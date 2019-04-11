package hib.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hib.student.entity.Student;

public class EmployeeSession {
	
	public Session session;
	public SessionFactory factory;
	
	public EmployeeSession(){
		 factory = new Configuration()
				.configure("practice8config.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		 session = factory.getCurrentSession();
		
	}
	
	public Boolean delete() {
		this.factory.close();
		return this.factory.isClosed();
	}
}
