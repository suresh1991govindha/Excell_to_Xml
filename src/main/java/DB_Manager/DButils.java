package DB_Manager;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

public class DButils {
		public static void main(String[] args) {
			
			try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");  
			
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			
			
			
			con.close();  

			System.out.println("succes");
			}catch(Exception e){ System.out.println(e);}  
			}  
			}  

