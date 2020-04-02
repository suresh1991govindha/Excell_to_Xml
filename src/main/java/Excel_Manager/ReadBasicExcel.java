package Excel_Manager;

import java.util.ArrayList;

public class ReadBasicExcel {

	public static void main(String[] args) throws Throwable {
		
		
		ArrayList<String> column0 = Read_Column.getColumn0();
	System.out.println(column0);
	
	ArrayList<String> column1 = Read_Column.getColumn1();
	System.out.println(column1);
	
	ArrayList<String> column2 = Read_Column.getColumn2();
	System.out.println(column2);
	
	ArrayList<String> column3 = Read_Column.getColumn3();
	System.out.println(column3);
	}
	
}
