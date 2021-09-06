package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory/Object Repository type of find the elements
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pswd;

	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
    @FindBy(xpath="//a[text()='Sign Up']")
    WebElement signup;
    
    @FindBy(xpath="//img[@class='img-responsive']")
    WebElement crmlogo;
    
    //---------Initialize the elements created above ------------------//
   //-------------create a constructor --------------------------//
  //Initializing the page objects
    
    public LoginPage()
    {
    	
    	PageFactory.initElements(driver, this);
    	
    }
    
    //Actions, get the title
    
    public String validateLoginPageTitle()
    {
    	return driver.getTitle();
    }
    
    //validate if logo is displayed
    public boolean validateCRMImage()
    {
    	return crmlogo.isDisplayed();
    }
    
    public HomePage login(String un, String password)
    {
    	username.sendKeys(un);
    	pswd.sendKeys(password);
    	submit.click(); //Takes us to the HomePage and should return HomePage Object
    	return new HomePage();
    	
    }
    
}
	

	

