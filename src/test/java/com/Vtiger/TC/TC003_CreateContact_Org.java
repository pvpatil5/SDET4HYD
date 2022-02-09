package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Vtiger.IAutoConstants;
import com.crm.Vtiger.JavaUtil;
import com.crm.Vtiger.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_CreateContact_Org {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.propfilepath);

		Properties prop= new Properties();

		prop.load(fis);

		WebDriverManager.chromedriver().setup();
		WebDriver driver;

		String BROWSER=prop.getProperty("Browser");

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

		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();

		WebDriverUtility webutil= new WebDriverUtility();
		webutil.pageloadtimeout(driver);

		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("UN"));

		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("PWD"));

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		WebElement saltutiontype = driver.findElement(By.xpath("//select[@name='salutationtype']"));

		webutil.selectfromdd("Mr.", saltutiontype);

		JavaUtil jv = new JavaUtil();

		String firstname=jv.fakefirstName();
		String lastname=jv.fakelastName();

		driver.findElement(By.name("firstname")).sendKeys(firstname);

		driver.findElement(By.name("lastname")).sendKeys(lastname);

		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		
		webutil.swtichtowindow("Accounts", driver);

		Thread.sleep(2000);

		String orgname="MANGO";

		driver.findElement(By.id("search_txt")).sendKeys(orgname);

		driver.findElement(By.name("search")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='1']")).click();
		
		webutil.swtichtowindow("Contacts", driver);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[.='Contacts']")).click();

		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(firstname);
		
		webutil.selectfromdd("firstname", driver.findElement(By.id("bas_searchfield")));

		driver.findElement(By.xpath("//input[@name='submit']")).click();

		Thread.sleep(2000);

		String value=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PAss");
		}
		else {
			System.out.println("TC Fail");
		}

		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		webutil.movetoelement(driver, signoutimg);

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		Thread.sleep(10000);
		driver.close();

	}

}
