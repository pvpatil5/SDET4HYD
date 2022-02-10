package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage 
{
	WebDriver driver;

	@FindBy(name="accountname")
	private WebElement orgname;

	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement orgsavebtn;

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getOrgsavebtn() {
		return orgsavebtn;
	}
	public CreateOrgPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
}
