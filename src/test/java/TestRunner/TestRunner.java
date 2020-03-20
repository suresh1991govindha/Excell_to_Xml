package TestRunner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import Stepdefinition.XML_FileCount;
import Utilities.FileReadManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.Glue;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="feature",
		glue="Stepdefinition",
		strict=true,
		dryRun=false,
		monochrome=true,
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		tags="@tag1"
		
	)

public class TestRunner   {

	@AfterClass
	 public static void writeExtentReport()  throws Throwable{
	 Reporter.loadXMLConfig(new File(FileReadManager.getInstance().getCr().getReportConfigPath()));
     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "3.7.0");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");
     Reporter.setSystemInfo("SOAP_ENDPOINT",FileReadManager.getInstance().getCr().getEndpoint());
     Reporter.setSystemInfo("Total_Request_Xml",String.valueOf(XML_FileCount.getRequestCount()));
     Reporter.setSystemInfo("Total_Response_Xml",String.valueOf(XML_FileCount.getResponseCount()));
    
	}
	
}
