package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import com.crm.Vtiger.GenericPac.IAutoConstants;
import com.crm.Vtiger.GenericPac.JavaUtil;
import com.crm.Vtiger.GenericPac.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrg_DD {

	public static void main(String[] args) throws InterruptedException, IOException {

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

		//POM Classes
		LoginPage loginpage = new LoginPage(driver);

		loginpage.getUsernametxtfld().sendKeys(fileutil.readDatafromPropfile("UN"));

		loginpage.getPasswordtxtfld().sendKeys(fileutil.readDatafromPropfile("PWD"));

		loginpage.getLoginbtn().click();

		HomePage homepage= new HomePage(driver);
		homepage.getOrginizationlink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		FileInputStream fisexcel = new FileInputStream(IAutoConstants.excelpath);

		JavaUtil jv = new JavaUtil();
		int randomnumber = jv.generateRandomNumber();

		String orgnameexcel=WorkbookFactory.create(fisexcel).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();

		String orgname= orgnameexcel+randomnumber;

		CreateOrgPage createorgpage= new CreateOrgPage(driver);
		createorgpage.getOrgname().sendKeys(orgname);

		webutil.selectfromdd("Hospitality",createorgpage.getIndustry());

		webutil.selectfromdd(2, createorgpage.getRating());

		webutil.selectfromdd(createorgpage.getType(), "Customer");

		createorgpage.getOrgsavebtn();

		Thread.sleep(2000);

		homepage.getOrginizationlink().click();
		
		orginfopage.getSearchtxtbox().sendKeys(orgname);
		
		WebElement element = orginfopage.getOrgtypesdd();
		webutil.selectfromdd(element, "Organization Name");

		orginfopage.getSearchorgbtn().click();

		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PASS");
		}
		else {
			System.out.println("TC Fail");
		}

		WebElement signoutimg = homepage.getSignoutimg();

		webutil.movetoelement(driver, signoutimg);

		homepage.getSignoutlink().click();

		Thread.sleep(10000);
		driver.close();
	}
}
