package TestRun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import Config_manager.FileReadManager;
import Utils_Manager.FileOperation;

public class RetryFailedTest {

	@Test
	public  void TestRun() throws Throwable {
	
		String endpoint = FileReadManager.getInstance().getCr().getEndpoint();
		String in_XMLpath = FileReadManager.getInstance().getCr().getResponse_XML();
		
		
		 File[] failedXMLCount = FileOperation.getFailedXMLCount();
		
		for (int i = 0; i < failedXMLCount.length; i++) {
			
			File requestfile = failedXMLCount[i];
	  
	  // File requestfile=new File("C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\Request_XML\\Request.xml");
		HttpClient client=HttpClientBuilder.create().build();
		
		HttpPost post=new HttpPost(endpoint);
		
		post.setEntity(new InputStreamEntity(new FileInputStream(requestfile)));

		post.setHeader("Content-Type","text/xml");
		
		HttpResponse reponse=client.execute(post);
		
		int statusCode = reponse.getStatusLine().getStatusCode();
	
		if(statusCode==200)
		{
		System.out.println("["+failedXMLCount[i]+" ] STATUS= " +statusCode+ " PASS");
		
	
		
		}else {
		
			File failedXML = failedXMLCount[i];
			String absolutePath = failedXML.getAbsolutePath();
			Reporter.log(absolutePath);
			
		System.err.println("["+failedXMLCount[i]+" ] STATUS= " +statusCode+ " FAIL");
		
		}
	
		
		 
	        
	      
		BufferedReader br=new BufferedReader(new InputStreamReader(reponse.getEntity().getContent()));
		String line=" ";
		
		StringBuffer sb=new StringBuffer();
		
		while((line=br.readLine())!=null)
		{
			sb.append( line);
		}
		//PrintWriter pw=new PrintWriter(in_XMLpath);
		
		PrintWriter pw=new PrintWriter(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML\\Reponse"+i+".xml");
		pw.write(sb.toString());
		pw.close();
		pw.flush();
}}
}
	


