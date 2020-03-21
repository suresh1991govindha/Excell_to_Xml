package TestRun;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;


public class UTIL {

	
	public  static int getRequestCount()
	{
		File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML");
		    int fileCount=directory.list().length;
		   // System.out.println("File Count:"+fileCount);
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
	  
public static  void copyFailedXML(File src,int i) throws IOException

{
	
	File des=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Failed_XML\\"+i+".xml");
	
	
	 FileUtils.copyFile(src, des);
	 System.out.println(" FAIL RESPONSE STORED SUCCESSFULLY --->> "+des);
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