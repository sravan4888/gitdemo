package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement saveBtn;
	
//	@FindBy(xpath="//a[text()='abcd efgh']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")
//	WebElement checkbox;
	
		
    //initialize webElements through PageFactory using constructor
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String box) {
		driver.findElement(By.xpath("//a[text()='"+box+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
	}
	
	
	public void createContact(String title, String fn, String ln) throws InterruptedException
	{
		WebElement option = driver.findElement(By.xpath("//select[@name='title']"));
		Select select = new Select(option);
		select.selectByVisibleText(title);
		Thread.sleep(5000);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		saveBtn.click();
		
	}
	
	

}
