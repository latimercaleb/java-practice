package hib.employee.demo;
import hib.employee.Employee;
import hib.employee.EmployeeSession;

public class DeleteEmployee {
	public static void main(String[] args) {
		EmployeeSession em = new EmployeeSession();
		try {
			em.session.beginTransaction();
			Employee oldWings = em.session.get(Employee.class, 2);
			em.session.delete(oldWings);
			em.session.getTransaction().commit();
		}
		finally {
			Boolean closed;
			closed = em.delete();
			System.out.print("Close result is: " + closed);
		}

	}

}
