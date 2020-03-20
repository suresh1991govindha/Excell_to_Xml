package Stepdefinition;

import java.io.File;

import org.junit.Test;

public class XML_FileCount {

	
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
	}
// TODO Auto-generated method stub
/*File directory=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML");
   int fileCount=directory.list().length;
  System.out.println("File Count:"+fileCount);
}}*/