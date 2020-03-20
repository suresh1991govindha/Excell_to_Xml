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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.FileReadManager;
import XML_update.BasicXml;

public class TestRun {



	
	@Test
		public  void TestRun() throws Throwable {
		

		
			int count = UTIL.getRequestCount();
			String in_XMLpath = FileReadManager.getInstance().getCr().getIn_XMLpath();
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
			
			Assert.assertEquals(200, statusCode);
			 System.out.println("response recieved ="+i+" status code =" +statusCode+ " passed");
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
