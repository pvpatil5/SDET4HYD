package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage { 
	//Rule 1 : Page name should be class name
	 
	WebDriver driver;
	
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement orginizationlink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactslink;

	public WebElement getOrginizationlink() {
		return orginizationlink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutlink;

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	

}
