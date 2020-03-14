package datadrrrr.exeeell;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 


{
	
	
	public static void main(String[] args) throws Throwable
	 {
		
		List<Object> list=new ArrayList<Object>();
		
		int columnIndex =0;
		File file=new File("S:\\SHARE25\\Share25-CTS_Core_Pharmacy_QA\\Core_Pharmacy\\12.Misc\\Suresh\\dd\\exeeell\\SAmple.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int numberOfSheets = workbook.getNumberOfSheets();
		
		for (int i = 0; i < numberOfSheets; i++) {
			
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testData"))
			{
				
				XSSFSheet sheet= workbook.getSheetAt(i);
				
				Iterator<Row> row = sheet.iterator();
				
				
				Row cell = row.next();
			
				Iterator<Cell> celliter = cell.iterator();
				int column=0;
				while(celliter.hasNext())
				{
					Cell next = celliter.next();
				
				
					if(next.getStringCellValue().equalsIgnoreCase("Data2"))
					{
						

						columnIndex	= next.getColumnIndex();
						
						String stringCellValue = next.getStringCellValue();
						System.out.println(stringCellValue);
						
						while(row.hasNext()) {
							Row next2 = row.next();
							
							Cell cell2 = next2.getCell(columnIndex);
							
							String stringCellValue2 = cell2.getStringCellValue();
							if(cell2.getCellType().equals(CellType.STRING))
							{
								String stringCellValue3 = cell2.getStringCellValue();
								
								System.out.println(stringCellValue3);
							}else if (cell2.getCellType().equals(CellType.NUMERIC))
							{
								double numericCellValue = cell2.getNumericCellValue();
								
								System.out.println(numericCellValue);
							
								
							}
							}
						}
						System.out.println(columnIndex);
					}
						
		}
				
			
				
				
				
				
		//System.out.println(numberOfSheets);
			
}}}