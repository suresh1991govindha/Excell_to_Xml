package TestRun;

import java.io.File;

public class SAmp {

	
	public static void main(String[] args) {
		
	
		
		File[] failedXMLCount = UTIL.getFailedXMLCount();
	
		
		for (int i = 0; i < failedXMLCount.length; i++) {
			
			
			System.out.println(failedXMLCount[i]);
		}
	}
}
