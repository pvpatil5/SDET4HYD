package testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_1 
{

	public WebDriver driver;

	@Test()
	public void A() {
		
		System.out.println("Launch Browser");
		System.out.println("Get URL");
		System.out.println("Login");
		
		SoftAssert assert1= new SoftAssert();
		assert1.assertEquals("TYSS", "HYd");
		
		//Assert.assertEquals("Pavan", "TYSS");
		
		System.out.println("Test Step 1");
		System.out.println("Test Step 2");
		System.out.println("Test Step 3");
		System.out.println("Test Step 4");
		System.out.println("Test Step 5");
		System.out.println("Logout");
		System.out.println("Close Browser");
		assert1.assertAll();
	}

//	@Test()
//	public void B() {
//		System.out.println("B running from Class TestNG_1");
//	}
//	@Test()
//	public void C() {
//		System.out.println("c running from Class TestNG_1");
//	}
}
