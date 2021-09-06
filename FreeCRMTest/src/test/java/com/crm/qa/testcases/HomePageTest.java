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
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage cp;
	DealsPage dp;
	TasksPage tp;
	TestUtil util;
	
	
	public HomePageTest()
	{
		super();
		
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		util = new TestUtil();
		
	}
	
	@AfterMethod
	public void cleanup()
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void checkHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest()
	{
		util.switchToFrame();
		Assert.assertTrue(homePage.verifyUserNameLabel());
		
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		util.switchToFrame();
		cp = homePage.clickOnContactsLink();
		
	}
		
	@Test(priority=4)
	public void clickOnDealsLinkTest() {
		util.switchToFrame();
		dp = homePage.clickOnDealsLink();
		
	}
//	
//	@Test(priority=5)
//	public void clickOnTasksLinkTest() {
//		tp = homePage.clickOnTasksLink();
//		
//	}
	
	
	
	
	
	
	
	
	
}
