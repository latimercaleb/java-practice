package hib.employee.demo;

import hib.employee.Employee;
import hib.employee.EmployeeSession;

public class CreateEmployee {

	public static void main(String[] args) {
		EmployeeSession mySession = new EmployeeSession();
		try {
			// Employee newEmp   = new Employee("Mac","n-Cheese","Kraft");
			Employee newEmp2  = new Employee("Wings","n-Dip","Buffalo Wild Wings");
			Employee newEmp3  = new Employee("Chalupas &","Tacos","Taco Bell");
			Employee newEmp4  = new Employee("Caesar","Salad","Cafe");
			Employee newEmp5  = new Employee("Megaman","X","Maverick Hunter Unit A");
			Employee newEmp6  = new Employee("Zero","V.","Maverick Hunter Special Unit G");
			Employee newEmp7  = new Employee("Vincent","Valentine","Avalanche");
			Employee newEmp8  = new Employee("Liu","Kang","White Lotus");
			Employee newEmp9  = new Employee("Noob","Saibot","Brotherhood of Shadow");
			Employee newEmp10 = new Employee("Johnny","Cage","Hollywood");
			
			mySession.session.beginTransaction();
			// mySession.session.save(newEmp);
			mySession.session.save(newEmp2);
			mySession.session.save(newEmp3);
			mySession.session.save(newEmp4);
			mySession.session.save(newEmp5);
			mySession.session.save(newEmp6);
			mySession.session.save(newEmp7);
			mySession.session.save(newEmp8);
			mySession.session.save(newEmp9);
			mySession.session.save(newEmp10);
			mySession.session.getTransaction().commit();
		}
		finally {
			Boolean closed;
			closed = mySession.delete();
			System.out.print("Close result is: " + closed);
		}

	}

}
