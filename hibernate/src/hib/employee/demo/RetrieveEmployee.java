package hib.employee.demo;

import java.util.List;

import hib.employee.Employee;
import hib.employee.EmployeeSession;

public class RetrieveEmployee {
	public static void main(String[] args) {
		EmployeeSession em = new EmployeeSession();
		try {
			em.session.beginTransaction();
			List<Employee> roster =  em.session.createQuery("from Employee as e WHERE e.lastName LIKE '%.'").getResultList();
			// roster.forEach(solider -> System.out.println(soldier));
			for(Employee soldier : roster) {
				System.out.println("Reporting in: " + soldier.getFirstName() + ", " + soldier.getLastName() + " of " + soldier.getCompany() + "!");
			}
			em.session.getTransaction().commit();
		}
		finally {
			Boolean closed;
			closed = em.delete();
			System.out.print("Close result is: " + closed);
		}

	}

}
