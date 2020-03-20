package TestRun;

import java.io.File;

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

@Test
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
	  
	}
// TODO Auto-generated method stub
/*File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML");
   int fileCount=directory.list().length;
  System.out.println("File Count:"+fileCount);
}}*/