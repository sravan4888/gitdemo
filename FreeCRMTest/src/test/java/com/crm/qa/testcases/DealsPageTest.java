package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dp;
	TestUtil util;
	
	public DealsPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
		util = new TestUtil();
		util.switchToFrame();
		dp = homepage.clickOnDealsLink();
		
	}
	
	@Test(priority=1)
	public void validateDealsTextTest()
	{
		Assert.assertTrue(dp.validateDealsText());
	}
	
	@Test(priority=2)
	public void highlightnumberTest() throws InterruptedException
	{
		dp.highlightnumber();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void cleanup()
	{
		driver.close();	}
	
	
	

}
