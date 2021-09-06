package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="(//a[@_title='Automation'])[1]")
	WebElement number;
	
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	}
	
	public boolean validateDealsText()
	{
		return deals.isDisplayed();
	}
	
	public void highlightnumber()
	{
		highlight(number);
	}
	
}
