package DB_Manager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	public static void main(String[] args) {
		
		try {
		
			 Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");  
		
		System.out.println("succes");
	}catch (Exception e)
		{
		e.printStackTrace();
		}
	
}
}