package com.crm.Vtiger.GenericPac;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class
{
	public WebDriver driver;
	public FileUtils fileutil = new FileUtils();
	public WebDriverUtility webutil = new WebDriverUtility();
	public JavaUtil jv = new JavaUtil();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void makeConnections() 
	{
		System.out.println("==Before Suite==");
		System.out.println("==DB Connection==");
	}

	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest() 
	{
		System.out.println("==Before Test==");
	}

	@BeforeClass(groups = {"smoke","regression"})
	public void launchbrowser_driver_Initilize() throws IOException {

		System.out.println("==launch browser==");

		WebDriverManager.chromedriver().setup();

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void logintoApp() throws IOException {

		System.out.println("==Login to App==");
		
		LoginPage loginpage = new LoginPage(driver);

		loginpage.getUsernametxtfld().sendKeys(fileutil.readDatafromPropfile("UN"));

		loginpage.getPasswordtxtfld().sendKeys(fileutil.readDatafromPropfile("PWD"));

		loginpage.getLoginbtn().click();
	}

	@AfterMethod(groups = {"smoke","regression"})
	public void logoutFromApp()
	{
		HomePage homepage = new HomePage(driver);
		WebElement signoutimg = homepage.getSignoutimg();

		webutil.movetoelement(driver, signoutimg);

		homepage.getSignoutlink().click();
		System.out.println("==Logout form App==");
	}

	@AfterClass(groups = {"smoke","regression"})
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.close();
	}

}
