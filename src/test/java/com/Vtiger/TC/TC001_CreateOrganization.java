package com.Vtiger.TC;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepo.CreateOrgPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.OrgInfoPage;
import com.crm.Vtiger.GenericPac.Base_Class;

public class TC001_CreateOrganization extends Base_Class {

	@Test
	public void create_Org() throws InterruptedException
	{
		HomePage homepage= new HomePage(driver);
		homepage.getOrginizationlink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		String orgname = jv.fakecompanyName();

		CreateOrgPage createorgpage= new CreateOrgPage(driver);
		createorgpage.getOrgname().sendKeys(orgname);

		createorgpage.getOrgsavebtn().click();

		Thread.sleep(2000);

		driver.navigate().refresh();

		homepage.getOrginizationlink().click();

		orginfopage.getSearchtxtbox().sendKeys(orgname);

		WebElement element = orginfopage.getOrgtypesdd();
		webutil.selectfromdd(element, "Organization Name");

		orginfopage.getSearchorgbtn().click();
		Thread.sleep(2000);

		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(value);

		//Assert.assertEquals(actual, expected);

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PASS");
		}
		else 
		{
			System.out.println("TC Fail");
		}
	}
}
