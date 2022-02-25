package testng.practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base 
{
	@BeforeSuite()
	public void bs() {
		System.out.println("Before Siute Executed");
		Assert.assertTrue(false);
	}
	
	@AfterSuite
	public void as() {
		System.out.println("After Suite Executed");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("Before Class");
		Assert.assertTrue(false);
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("After Method");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void at() {
		System.out.println("After Test");
	}

	
}
