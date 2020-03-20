package Stepdefinition;

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

import Utilities.FileReadManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Stepdefinition {


	
		@Given("^I want to execute service$")
		public void i_want_to_execute_service() throws Throwable {
		
			int count = XML_FileCount.getRequestCount();
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

		@When("^I the POST request as per the data in Excel Worksheet$")
		public void i_the_POST_request_as_per_the_data_in_Excel_Worksheet() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}

		@When("^I validate status code$")
		public void i_validate_status_code() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}

		@When("^I validate mandatory tag in response from Excel Worksheet$")
		public void i_validate_mandatory_tag_in_response_from_Excel_Worksheet() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}

		@When("^I validate response content$")
		public void i_validate_response_content() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}

		@When("^I validate header parameter in response$")
		public void i_validate_header_parameter_in_response() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}



}
