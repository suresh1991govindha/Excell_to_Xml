package DB_Manager;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
import java.util.ArrayList;

import POJO.Drug_POJO;
import XML_Manager.DB_BasicXml;

public class DButils {
		public static void main(String[] args) throws Throwable {
			
			
			ArrayList<Drug_POJO> list=new ArrayList<Drug_POJO>();
		
			
			try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/student","root","root");  
			
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM studentDetails");  
			while(rs.next())  
			{
				Drug_POJO d=new Drug_POJO();
			d.setColumn1(String.valueOf(rs.getString(1)));
			d.setColumn2(String.valueOf(rs.getString(2)));
			d.setColumn3(String.valueOf(rs.getString(3)));
			d.setColumn4(String.valueOf(rs.getString(4)));
			d.setColumn5(String.valueOf(rs.getString(5)));
			d.setColumn6(String.valueOf(rs.getString(6)));
			d.setColumn7(String.valueOf(rs.getString(7)));
			d.setColumn8(String.valueOf(rs.getString(8)));
			d.setColumn9(String.valueOf(rs.getString(9)));			
			d.setColumn10(String.valueOf(rs.getString(10)));					
			list.add(d);
			}
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i);
			//System.out.println();
			
				DB_BasicXml.getData(list.get(i));
			}
			con.close();  
			
			System.out.println("=============================");
			System.out.println("succes");
			}catch(Exception e){ System.out.println(e);}  
			}  
			}  

