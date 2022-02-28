package com.Vtiger.TC;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepo.CreateOrgPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.OrgInfoPage;
import com.crm.Vtiger.GenericPac.Base_Class;

public class TC002_CreateOrg_DD extends Base_Class{

	
	@Test(groups = {"regression"})
	public void create_Org_DD() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage homepage= new HomePage(driver);
		homepage.getOrginizationlink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		String orgname= jv.fakecompanyName();

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
		
		Thread.sleep(3000);

		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		Assert.assertEquals(value,orgname);
	}
}
