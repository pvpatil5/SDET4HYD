package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepo.CreateOrgPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.LoginPage;
import com.crm.ObjectRepo.OrgInfoPage;
import com.crm.Vtiger.GenericPac.FileUtils;
import com.crm.Vtiger.GenericPac.JavaUtil;
import com.crm.Vtiger.GenericPac.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOrganization {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		// File util to read the common data
		FileUtils fileutil = new FileUtils();

		// Launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver;

		String BROWSER=fileutil.readDatafromPropfile("Browser");

		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}
		
		//Get URL

		driver.get(fileutil.readDatafromPropfile("URL"));

		driver.manage().window().maximize();

		// WEb Driver Util for accessing driver methods
		WebDriverUtility webutil = new WebDriverUtility();

		webutil.pageloadtimeout(driver);
		
		//POM Classes
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.getUsernametxtfld().sendKeys(fileutil.readDatafromPropfile("UN"));

		loginpage.getPasswordtxtfld().sendKeys(fileutil.readDatafromPropfile("PWD"));
		
		loginpage.getLoginbtn().click();
		
		HomePage homepage= new HomePage(driver);
		homepage.getOrginizationlink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		JavaUtil jv = new JavaUtil();
		String orgname = jv.fakecompanyName();

		CreateOrgPage createorgpage= new CreateOrgPage(driver);
		createorgpage.getOrgname().sendKeys(orgname);
		
		createorgpage.getOrgsavebtn().click();
	
		Thread.sleep(2000);

		homepage.getOrginizationlink().click();

		orginfopage.getSearchtxtbox().sendKeys(orgname);

		WebElement element = orginfopage.getOrgtypesdd();
		webutil.selectfromdd(element, "Organization Name");

		orginfopage.getSearchorgbtn().click();
		Thread.sleep(2000);

		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(value);
		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PASS");
		}
		else 
		{
			System.out.println("TC Fail");
		}

		WebElement signoutimg = homepage.getSignoutimg();

		webutil.movetoelement(driver, signoutimg);

		homepage.getSignoutlink().click();


		Thread.sleep(10000);
		driver.close();

	}
}
