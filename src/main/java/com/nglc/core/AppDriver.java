package com.nglc.core;



import java.io.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AppDriver {
	
	public static WebDriver driver;
	public static Properties Config=new Properties();
	public static Properties Obj=new Properties();
	public static Logger log=Logger.getLogger("devpinoyLogger");

	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeClass
	public  void startTest()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
    	String repName="Test-Report-"+timeStamp+".html";
    	extent=new ExtentReports(System.getProperty("user.dir")+ "//Reports//"+repName);
		extent.addSystemInfo("OS", "Linux Centos 8");
		extent.addSystemInfo("TesterName", "Moosa Khan");
	}
	
	@BeforeMethod
	//@Parameters("browser")
	public void launchApp() throws Exception
	{	
		
		long startTime = System.currentTimeMillis();
		FileInputStream fis_config=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//nglc//properties//Config.properties");  //("/home/innobit/eclipse-workspace/nglc-webui-automation/src/main/java/com/nglc/properties/Config.properties");
		Config.load(fis_config);
		FileInputStream fis_obj=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//nglc//properties//Object.properties"); //("/home/innobit/eclipse-workspace/nglc-webui-automation/src/main/java/com/nglc/properties/Object.properties");
		Obj.load(fis_obj);
		if(Config.getProperty("browser").equalsIgnoreCase("Chrome")){
			log.info("Opening Chrome Browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver");
			driver=new ChromeDriver();
		}
		else if(Config.getProperty("browser").equalsIgnoreCase("IE")){
			log.info("Opening IE Browser");
			//System.setProperty("webdriver.chrome.driver", Config.getProperty("driverpath"));
			driver=new InternetExplorerDriver();
		}
		else if(Config.getProperty("browser").equalsIgnoreCase("Firefox")){
			log.info("Opening Firefox Browser");
			//System.setProperty("webdriver.chrome.driver", Config.getProperty("driverpath"));
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(Config.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
			
		//test.log(LogStatus.PASS, "Browser Launched Successfully");
		//test.log(LogStatus.INFO,"Total Page Load Time: " + totalTime + " milliseconds");
		
	}

	@AfterMethod
	public void postCondition(ITestResult result) throws Exception 
	{

		 if(result.getStatus() == ITestResult.FAILURE){
			 //test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
    		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			 
			 String screenshotPath = Screenshots.photo(driver, result.getName());
			 //To add it in the extent report 
			 
			  test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			 }
		 else if(result.getStatus() == ITestResult.SKIP)
			 {
				 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			 }
				
		driver.close();	
		test.log(LogStatus.PASS, "Browser Closed Successfully");
		extent.endTest(test);

	}
	@AfterClass
	public static void afterclass()
	{
		extent.flush();
		extent.close();
	    
	}
	
}



