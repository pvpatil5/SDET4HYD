package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  //Rule 1 : Class name should be page name
{
	WebDriver driver;

	@FindBy(name="user_name")	// Rule 2: Locale element using @find by
	private WebElement usernametxtfld;

	@FindBy(name="user_password")
	private WebElement passwordtxtfld; 

	@FindBy (id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametxtfld() { //Rule 3 : Generate Getters for accessing webelements
		return usernametxtfld;
	}

	public WebElement getPasswordtxtfld() {
		return passwordtxtfld;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}


	public LoginPage(WebDriver driver)  //Rule 4: Create Constructor for avioding stateelement exception
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

}
