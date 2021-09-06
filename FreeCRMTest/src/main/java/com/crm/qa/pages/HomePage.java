package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;

	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement NewContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserNameLabel()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
	   ContactsLink.click();
	   return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
	   DealsLink.click();
	   return new DealsPage();
	
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();
    }
	
		
//	
//	public TasksPage clickOnTasksLink()
//	{
//	   DealsLink.click();
//	   return new TasksPage();
//	}
	
}
