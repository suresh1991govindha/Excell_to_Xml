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

	public class RetryFailedTest {

		    ExtentHtmlReporter htmlReporter;
		    ExtentReports extent;
		    ExtentTest test;
		    

		  @BeforeTest
		    public void startReport() {
		    	
		        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/extend-reports/RetryFailedTest.html");
		  	extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
		        htmlReporter.config().setChartVisibilityOnOpen(true);
		        htmlReporter.config().setDocumentTitle("Failed Response Extent Report");
		        htmlReporter.config().setReportName("RetryFailedTest");
		        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		        htmlReporter.config().setTheme(Theme.DARK);
		        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		    }
		     

	@Test
	public  void TestRun() throws Throwable {
	
		String endpoint = FileReadManager.getInstance().getCr().getEndpoint();
		String in_XMLpath = FileReadManager.getInstance().getCr().getResponse_XML();
		
		
		 File[] failedXMLCount = FileOperation.getFailedXMLCount();
		
		 System.out.println("count == "+failedXMLCount.length);
		for (int i = 0; i < failedXMLCount.length; i++) {
			
			File requestfile = failedXMLCount[i];
	  
	  // File requestfile=new File("C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\Request_XML\\Request.xml");
		HttpClient client=HttpClientBuilder.create().build();
		
		HttpPost post=new HttpPost(endpoint);
		
		post.setEntity(new InputStreamEntity(new FileInputStream(requestfile)));

		post.setHeader("Content-Type","text/xml");
		
		HttpResponse reponse=client.execute(post);
		
		int statusCode = reponse.getStatusLine().getStatusCode();
	
		if(statusCode>200)
		{
		
			File failedXML = failedXMLCount[i];
			String absolutePath = failedXML.getAbsolutePath();
			Reporter.log(absolutePath);
			
		System.err.println("["+failedXMLCount[i]+" ] STATUS= " +statusCode+ " FAIL");
		 test = extent.createTest(" Test Case ["+i+".xml ] STATUS ", "failed test case");
		  
		  test.log(Status.FAIL, MarkupHelper.createLabel(" FAILED ", ExtentColor.RED));
		
		}else {
		
	
		System.out.println("["+failedXMLCount[i]+" ] STATUS= " +statusCode+ " PASS");
		test = extent.createTest(" Test Case ["+i+".xml ] STATUS  ", "PASSED test case");
		
		  test.log(Status.PASS, MarkupHelper.createLabel(" PASSED ", ExtentColor.GREEN));
		//FileOperation.movePassedXML(failedXMLCount[i]);
		
		File pass=failedXMLCount[i];
		String string = pass.toString();
		int length = string.length();
		
		String substring = string.substring(length-5);
		
		System.out.println("deleted ="+substring);
		failedXMLCount[i].delete();
		
	//	File des=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML\\"+substring);
		BufferedReader br=new BufferedReader(new InputStreamReader(reponse.getEntity().getContent()));
		String line=" ";
		
		StringBuffer sb=new StringBuffer();
		
		while((line=br.readLine())!=null)
		{
			sb.append( line);
		}
		//PrintWriter pw=new PrintWriter(in_XMLpath);

		PrintWriter pw=new PrintWriter(System.getProperty("user.dir")+"\\src\\test\\resource\\Response_XML\\Reponse"+substring);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
		}
	
		
		 
	        
	      
	
}}

	
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


