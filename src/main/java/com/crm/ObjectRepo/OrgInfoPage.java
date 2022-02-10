package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage 
{
	WebDriver driver;

	public  OrgInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgimg;

	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchtxtbox;

	@FindBy(id="bas_searchfield")
	private WebElement orgtypesdd;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchorgbtn;

	public WebElement getCreateorgimg() {
		return createorgimg;
	}

	public WebElement getSearchtxtbox() {
		return searchtxtbox;
	}

	public WebElement getOrgtypesdd() {
		return orgtypesdd;
	}

	public WebElement getSearchorgbtn() {
		return searchorgbtn;
	}




}
