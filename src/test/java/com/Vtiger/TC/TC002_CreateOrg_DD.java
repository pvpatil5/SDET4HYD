package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.Vtiger.IAutoConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrg_DD {

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("UN"));

		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("PWD"));

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		FileInputStream fisexcel = new FileInputStream(IAutoConstants.excelpath);

		String orgname=WorkbookFactory.create(fisexcel).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

		WebElement industrydd = driver.findElement(By.xpath("//select[@name='industry']"));

		WebElement ratingdd = driver.findElement(By.xpath("//select[@name='rating']"));
		
		WebElement typedd = driver.findElement(By.xpath("//select[@name='accounttype']"));

		
		Select selectIndustry= new Select(industrydd);
		selectIndustry.selectByValue("Hospitality");
		
		Select selectrating= new Select(ratingdd);
		selectrating.selectByIndex(2);
		
		Select selecttype=new Select(typedd);
		selecttype.selectByVisibleText("Customer");
		
		driver.findElement( By.xpath("//input[@class='crmbutton small save']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		Select select = new Select(driver.findElement(By.id("bas_searchfield")));
		select.selectByVisibleText("Organization Name");

		driver.findElement(By.xpath("//input[@name='submit']")).click();

		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PASS");
		}
		else {
			System.out.println("TC Fail");
		}

		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Actions action = new Actions(driver);
		action.moveToElement(signoutimg).build().perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();


		Thread.sleep(10000);
		driver.close();

		
		
		
		
		
		
	}

}
