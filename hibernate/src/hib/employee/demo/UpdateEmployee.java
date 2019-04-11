package hib.employee.demo;

import hib.employee.Employee;
import hib.employee.EmployeeSession;

public class UpdateEmployee {
	public static void main(String[] args) {
		EmployeeSession em = new EmployeeSession();
		try {
			em.session.beginTransaction();
			Employee megamanx = em.session.get(Employee.class, 5);
			megamanx.setLastName("X.");
			em.session.getTransaction().commit();
		}
		finally {
			Boolean closed;
			closed = em.delete();
			System.out.print("Close result is: " + closed);
		}
	}

}
