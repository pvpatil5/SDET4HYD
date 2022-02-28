package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.ObjectRepo.CreateOrgPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.OrgInfoPage;
import com.crm.Vtiger.GenericPac.Base_Class;

public class TC001_CreateOrganization_Test extends Base_Class {

	@Test(groups = {"regression"})
	public void create_Org_Test() throws InterruptedException
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

		Assert.assertEquals(value, orgname);
	}

	@Test(groups = {"smoke"})
	public void create_emptyorg_Test() throws InterruptedException 
	{
		HomePage homepage= new HomePage(driver);
		homepage.getOrginizationlink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		CreateOrgPage createorgpage= new CreateOrgPage(driver);

		createorgpage.getOrgsavebtn().click();

		String text =	webutil.getTextFromAlert(driver);
		
		Assert.assertEquals(text, "Organization Name cannot be empty");
		
		webutil.dismissAlert(driver);
		
		


	}
}
