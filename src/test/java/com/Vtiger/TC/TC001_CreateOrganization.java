package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Vtiger.FileUtils;
import com.crm.Vtiger.JavaUtil;
import com.crm.Vtiger.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOrganization {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		FileUtils fileutil = new FileUtils();

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

		driver.get(fileutil.readDatafromPropfile("URL"));

		driver.manage().window().maximize();

		WebDriverUtility webutil = new WebDriverUtility();

		webutil.pageloadtimeout(driver);

		driver.findElement(By.name("user_name")).sendKeys(fileutil.readDatafromPropfile("UN"));

		driver.findElement(By.name("user_password")).sendKeys(fileutil.readDatafromPropfile("PWD"));

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//
		//		FileInputStream fisexcel = new FileInputStream(IAutoConstants.excelpath);
		//
		//		String orgname=WorkbookFactory.create(fisexcel).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();

		JavaUtil jv = new JavaUtil();
		String orgname = jv.fakecompanyName();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

		driver.findElement( By.xpath("//input[@class='crmbutton small save']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		WebElement element = driver.findElement(By.id("bas_searchfield"));

		webutil.selectfromdd(element, "Organization Name");

		driver.findElement(By.xpath("//input[@name='submit']")).click();

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

		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		webutil.movetoelement(driver, signoutimg);

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();


		Thread.sleep(10000);
		driver.close();

	}
}
