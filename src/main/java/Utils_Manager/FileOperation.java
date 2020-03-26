package Utils_Manager;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;


public class FileOperation {

	
	public  static int getRequestCount()
	{
		File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML");
		    int fileCount=directory.list().length;
		    System.out.println("File Count:"+fileCount);
		return fileCount;
		  }
		


public  static int getResponseCount()
{
	File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML");
	    int fileCount=directory.list().length;
	   // System.out.println("File Count:"+fileCount);
	return fileCount;
	  }


public static void deleteInputXml()
{
	File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML");
	
	File[] listFiles = directory.listFiles();
	for (File file : listFiles) {
		file.delete();
	}
	}
	  

public static  void deleteOutputXml()
{
	File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML");
	
	File[] listFiles = directory.listFiles();
	for (File file : listFiles) {
		file.delete();
	}
	}
	  
public static  void moveFailedXML(File src,int i) throws IOException

{
	
	File des=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Failed_XML\\"+i+".xml");
	
	
	 FileUtils.copyFile(src, des);
	 System.err.println(" FAIL RESPONSE STORED SUCCESSFULLY --->> "+des);
	}

@Test
public static  void movePassedXML(File src) throws IOException

{
	
	String string = src.toString();
	int length = string.length();
	
	String substring = string.substring(length-12);
	
	//System.out.println(substring);
	File des=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML\\"+substring);

	 FileUtils.moveFile(src, des);

	
	 System.err.println(" RetryFailedTest Passed SUCCESSFULLY --->> "+string);
	}

	public  static  File[] getFailedXMLCount()
	{
		File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Failed_XML");
		    int fileCount=directory.list().length;
		    String absolutePath=" ";
		    File[] listFiles = directory.listFiles();
		    
		 
		   
		// System.out.println("File Count:"+fileCount);
		return listFiles;
		  }
		
	

	
}

// TODO Auto-generated method stub
/*File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML");
   int fileCount=directory.list().length;
  System.out.println("File Count:"+fileCount);
}}*/