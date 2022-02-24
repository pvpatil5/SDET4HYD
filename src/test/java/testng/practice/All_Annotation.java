package testng.practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class All_Annotation 
{
	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void as() {
		System.out.println("After suite");
	}

	@Test
	public void CreateContact() {
		System.out.println("Home Page then click on contact");
		System.out.println("Contact info Click on + Btn");
		System.out.println("Create Contact Page enter Details");
		Assert.assertEquals(true, false);
		System.out.println("Validation ");
	}

	@Test
	public void CreateContactwithPhone() {
		System.out.println("Home Page then click on contact");
		System.out.println("Contact info Click on + Btn");
		System.out.println("Create Contact Page enter Details");
		System.out.println("Validation ");
		System.out.println("Create Contact with Phone Success");
		Assert.assertEquals(true, true);
	}
	@BeforeClass
	public void bc() {
		System.out.println("Before class");
	}

	@AfterClass
	public void ac() {
		System.out.println("After Class");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("Login Success");
	}

	@AfterMethod
	public void am() {
		System.out.println("Logout Success");
	}
}
