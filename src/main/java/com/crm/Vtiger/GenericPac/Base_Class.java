package com.crm.Vtiger.GenericPac;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class
{
	
	public WebDriver driver;

	public WebDriver launch_Browser_URL() throws IOException {
		FileUtils fileutil = new FileUtils();

		// Launch browser
		WebDriverManager.chromedriver().setup();
	//	WebDriver driver;

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

		return driver;
	}


	public void logintoApp() {
		LoginPage loginpage = new LoginPage(driver);

		loginpage.getUsernametxtfld().sendKeys(fileutil.readDatafromPropfile("UN"));

		loginpage.getPasswordtxtfld().sendKeys(fileutil.readDatafromPropfile("PWD"));

		loginpage.getLoginbtn().click();
	}

	public void logoutFromApp()
	{
		HomePage homepage = new HomePage(driver);
		WebElement signoutimg = homepage.getSignoutimg();

		webutil.movetoelement(driver, signoutimg);

		homepage.getSignoutlink().click();
	}

	public void tearDown() {
		driver.close();
	}

}
