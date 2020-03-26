package TestRun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Config_manager.FileReadManager;
import Utils_Manager.FileOperation;
import XML_Manager.Excel_BasicXml;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class TestRunner {


	    ExtentHtmlReporter htmlReporter;
	    ExtentReports extent;
	    ExtentTest test;
	    

	  @BeforeTest
	    public void startReport() {
	    	
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/extend-reports/TestRunner.html");
	  	extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("TestRunner Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    }
	     

	
	@Test
		public  void TestRun() throws Throwable {
		

		   String endpoint = FileReadManager.getInstance().getCr().getEndpoint();
			int count = FileOperation.getRequestCount();
			if(count==0)
			{
				
				System.err.println("Request_XML File not Found Count:"+count);
				Assert.assertFalse(true);
			}else {
			for (int i = 0; i < count; i++) {
				
				
		 
		    File requestfile=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Request_XML\\"+i+".xml");
		  // File requestfile=new File("C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\Request_XML\\Request.xml");
			HttpClient client=HttpClientBuilder.create().build();
			
			HttpPost post=new HttpPost(endpoint);
			
			post.setEntity(new InputStreamEntity(new FileInputStream(requestfile)));

			post.setHeader("Content-Type","text/xml");
			
			HttpResponse reponse=client.execute(post);
			
			int statusCode = reponse.getStatusLine().getStatusCode();
		
			if(statusCode>200)
			{
				String failedXML=System.getProperty("user.dir")+"\\src\\test\\resource\\Failed_XML\\Reponse"+i+".xml";
				Reporter.log(failedXML);
				
				System.err.print("["+i+".xml ] STATUS= " +statusCode);	
				
				
				FileOperation.moveFailedXML(requestfile,i);
			//System.out.println(requestfile);  
			  test = extent.createTest(" Test Case ["+i+".xml ] STATUS ", "failed test case");
			  
			  test.log(Status.FAIL, MarkupHelper.createLabel(" FAILED ", ExtentColor.RED));
			}else {
	
			
				System.out.println("["+i+".xml ] STATUS= " +statusCode+ " PASS");
				test = extent.createTest(" Test Case ["+i+".xml ] STATUS  ", "PASSED test case");
			
				  test.log(Status.PASS, MarkupHelper.createLabel(" PASSED ", ExtentColor.GREEN));
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
	

	 @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	     
	    @AfterTest
	    public void tearDown() {
	    	//to write or update test information to reporter
	        extent.flush();
	    }
	}
