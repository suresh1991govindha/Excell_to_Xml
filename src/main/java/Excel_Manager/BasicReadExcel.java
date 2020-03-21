package Excel_Manager;

import java.util.ArrayList;
import java.util.HashMap;

import XML_Manager.BasicXml;

public class BasicReadExcel extends BasicXml{

	
	public static void main(String[] args) throws Throwable
	{
		
	
		
		ArrayList<String> column0 = Drug_Sig.getColumn0();
		ArrayList<String> column1 = Drug_Sig.getColumn1();
		ArrayList<String> column2 = Drug_Sig.getColumn2();
		ArrayList<String> column3 = Drug_Sig.getColumn3();
		ArrayList<String> column4 = Drug_Sig.getColumn4();

		int size = column0.size();
		
		System.out.println(size);
/*		System.out.println(column0);
		System.out.println(column1);
		System.out.println(column2);
		System.out.println(column3);
		System.out.println(column4);*/

		
		
		
	}
}
