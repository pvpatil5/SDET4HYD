package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepo.ContactInfoPage;
import com.crm.ObjectRepo.ContactOrg_popup;
import com.crm.ObjectRepo.CreateContactPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.LoginPage;
import com.crm.Vtiger.GenericPac.FileUtils;
import com.crm.Vtiger.GenericPac.JavaUtil;
import com.crm.Vtiger.GenericPac.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_CreateContact_Org {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtils fileutil= new FileUtils();
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

		WebDriverUtility webutil= new WebDriverUtility();
		webutil.pageloadtimeout(driver);

		//POM Classes
		LoginPage loginpage = new LoginPage(driver);

		loginpage.getUsernametxtfld().sendKeys(fileutil.readDatafromPropfile("UN"));

		loginpage.getPasswordtxtfld().sendKeys(fileutil.readDatafromPropfile("PWD"));

		loginpage.getLoginbtn().click();
		
		HomePage homePage =new HomePage(driver);
		homePage.getContactslink().click();
		
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		
		contactInfoPage.getCreatecontactsimg().click();
		
		CreateContactPage createContactPage = new CreateContactPage(driver);

		WebElement saltutiontype = createContactPage.getSaltutiontype();
		
		webutil.selectfromdd("Mr.", saltutiontype);

		JavaUtil jv = new JavaUtil();

		String firstname=jv.fakefirstName();
		String lastname=jv.fakelastName();
		
		createContactPage.getfirstname().sendKeys(firstname);

		createContactPage.getLastNameEdt().sendKeys(lastname);
		
		createContactPage.getOrganizationLookUpImage().click();

		webutil.swtichtowindow("Accounts", driver);

		Thread.sleep(2000);

		String orgname="MANGO";
		
		ContactOrg_popup contactOrg_popup = new ContactOrg_popup(driver);
		
		contactOrg_popup.getSearchorgtxtfld().sendKeys(orgname);

		contactOrg_popup.getSearchbtn().click();
		//driver.findElement(By.name("search")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='1']")).click();

		webutil.swtichtowindow("Contacts", driver);
		
		createContactPage.getSaveBtn().click();

		Thread.sleep(3000);
		
		homePage.getContactslink().click();
		
		contactInfoPage.getSearchcontacttxtfld().sendKeys(firstname);

		webutil.selectfromdd("firstname", contactInfoPage.getSearchforcontactDD());

		contactInfoPage.getSearchcontactbtn().click();
		
		Thread.sleep(2000);

		String value=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PAss");
		}
		else {
			System.out.println("TC Fail");
		}

		WebElement signoutimg = homePage.getSignoutimg();

		webutil.movetoelement(driver, signoutimg);

		homePage.getSignoutlink().click();

		Thread.sleep(10000);
		driver.close();

	}

}
