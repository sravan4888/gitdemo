package com.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.*;
import com.crm.qa.pages.*;
import org.apache.commons.io.FileUtils;

public class ExtentReportListener extends TestBase {
	private ExtentReports extentreports;
	private ExtentSparkReporter spark;
	private ExtentTest extentest;
	HomePage homepage;
	LoginPage loginpage;
	String path;
		
	public ExtentReportListener()
	{
		super();
		
	}
	
	@BeforeMethod
	public void prereq()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login("groupautomation", "Test@12345");
		
		path = System.getProperty("user.dir")+"\\newreport\\index.html";
		spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("First Document");//Title of the report
		spark.config().setReportName("First Report");//Name of the report
		spark.config().setTheme(Theme.DARK);
		
		extentreports = new ExtentReports();
		extentreports.attachReporter(spark);
		extentreports.setSystemInfo("Tester", "Sravan");
	}
	
	@AfterTest
	public void cleanup()
	{
		extentreports.flush();
	}
	
	@Test
	public void access()
	{
		extentest = extentreports.createTest("Very First Test");
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "notthis");
		
	}
	
	@AfterMethod
	public void validate(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentest.log(Status.FAIL, "Test Case failed is"+ result.getName());
			extentest.log(Status.FAIL, "Test failed is"+result.getThrowable());
			String screenpath = failedscreenshot(driver, result.getName());
			extentest.addScreenCaptureFromPath(screenpath);
		
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentest.log(Status.SKIP, "Test Case Skipped is"+ result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			extentest.log(Status.PASS, "Test Case Passed is"+ result.getName());
			
		}
	}
	
	
	public static String failedscreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date(0));
		System.out.println(date);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\screenshot\\"+screenshotname+date+".png";
		File finaldestination = new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
	}
	

}
