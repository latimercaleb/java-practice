package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class OneToManyUniTest {

	public static void main(String[] args) {
		// Declare arguments of the correct url and password
		String jdbcString = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			// Test connection to ensure that db and jdbc is setup correctly
			System.out.println("Connection to: " + jdbcString);
			Connection testConn = DriverManager.getConnection(jdbcString, user, pass);
			System.out.println("Connection success!");
		}
		catch(Exception e) {
			System.out.println("Issue detected");
			e.printStackTrace();
			System.out.println("Connection failed!");
		}

	}

}
