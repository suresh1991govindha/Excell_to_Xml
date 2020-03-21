package TestRun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Config_manager.FileReadManager;
import Utils_Manager.FileOperation;
import XML_Manager.BasicXml;

public class TestRunner {



	
	@Test
		public  void TestRun() throws Throwable {
		

		
			int count = FileOperation.getRequestCount();
		
			for (int i = 0; i < count; i++) {
				
		    String endpoint = FileReadManager.getInstance().getCr().getEndpoint();
		    File requestfile=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML\\"+i+".xml");
		  // File requestfile=new File("C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\Request_XML\\Request.xml");
			HttpClient client=HttpClientBuilder.create().build();
			
			HttpPost post=new HttpPost(endpoint);
			
			post.setEntity(new InputStreamEntity(new FileInputStream(requestfile)));

			post.setHeader("Content-Type","text/xml");
			
			HttpResponse reponse=client.execute(post);
			
			int statusCode = reponse.getStatusLine().getStatusCode();
		
			if(statusCode==200)
			{
			System.out.println("["+i+".xml ] STATUS= " +statusCode+ " PASS");
			}else {
			
				
				String failedXML=System.getProperty("user.dir")+"\\src\\test\\resource\\Failed_XML\\"+i+".xml";
				Reporter.log(failedXML);
				
				System.err.print("["+i+".xml ] STATUS= " +statusCode);	FileOperation.moveFailedXML(requestfile,i);
			//	System.out.println(requestfile);
			}
		
			
			 
		        
		      
			BufferedReader br=new BufferedReader(new InputStreamReader(reponse.getEntity().getContent()));
			String line=" ";
			
			StringBuffer sb=new StringBuffer();
			
			while((line=br.readLine())!=null)
			{
				sb.append( line);
			}
			PrintWriter pw=new PrintWriter(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML\\Reponse"+i+".xml");
			
		//	PrintWriter pw=new PrintWriter(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML\\Reponse.xml");
			pw.write(sb.toString());
			pw.close();
			pw.flush();
	}}

		
	

	
	


}
