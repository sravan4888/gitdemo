package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage cp1, cp2, cp3;
	TestUtil util = new TestUtil();
	
	
	public ContactsPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		util = new TestUtil();
		util.switchToFrame();
		
		
	}
//	
//	@Test(priority=1)
//	public void verifyContactsLabelTest()
//	{
//		cp1 = homePage.clickOnContactsLink();
//		Assert.assertTrue(cp1.verifyContactsLabel(), "Contacts label is missing on the page");
//	}
//	
//	@Test(priority=2)
//	public void selectContactsByNameTest()
//	{
//	  cp2 = homePage.clickOnContactsLink();
//	  cp2.selectContactsByName("abcd efgh");
//	}
//	
	@Test(dataProvider="getTestData")
	public void validateCreateNewContactTest(String des, String fn, String ln) throws InterruptedException
	{
		homePage.clickOnNewContactLink();
		cp3 = new ContactsPage();
		cp3.createContact(des, fn, ln);
	}
	
	

	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] obj1 = util.data("Sheet1");
		return obj1;
		
	}
	
	@AfterMethod
	public void cleanup()
	{
		driver.close();
	}

}
