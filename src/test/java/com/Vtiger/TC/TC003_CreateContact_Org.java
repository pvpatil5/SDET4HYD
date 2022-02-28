package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepo.ContactInfoPage;
import com.crm.ObjectRepo.ContactOrg_popup;
import com.crm.ObjectRepo.CreateContactPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.Vtiger.GenericPac.Base_Class;

public class TC003_CreateContact_Org extends Base_Class{

	@Test(groups = {"regression"})
	public  void create_contactwithOrg_Test() throws InterruptedException, IOException {

		HomePage homePage =new HomePage(driver);
		homePage.getContactslink().click();

		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);

		contactInfoPage.getCreatecontactsimg().click();

		CreateContactPage createContactPage = new CreateContactPage(driver);

		WebElement saltutiontype = createContactPage.getSaltutiontype();

		webutil.selectfromdd("Mr.", saltutiontype);

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

		Assert.assertEquals(value, orgname);
	}
	
	@Test(groups = {"smoke"})
	public  void create_contact_Test() throws InterruptedException, IOException {

		HomePage homePage =new HomePage(driver);
		homePage.getContactslink().click();

		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);

		contactInfoPage.getCreatecontactsimg().click();

		CreateContactPage createContactPage = new CreateContactPage(driver);

		WebElement saltutiontype = createContactPage.getSaltutiontype();

		webutil.selectfromdd("Mr.", saltutiontype);

		String firstname=jv.fakefirstName();
		String lastname=jv.fakelastName();

		createContactPage.getfirstname().sendKeys(firstname);

		createContactPage.getLastNameEdt().sendKeys(lastname);

		createContactPage.getSaveBtn().click();

		Thread.sleep(3000);

		homePage.getContactslink().click();

		contactInfoPage.getSearchcontacttxtfld().sendKeys(firstname);

		webutil.selectfromdd("firstname", contactInfoPage.getSearchforcontactDD());

		contactInfoPage.getSearchcontactbtn().click();

		Thread.sleep(3000);

		String value=driver.findElement(By.xpath("//a[@title='Contacts']")).getText();

		Assert.assertEquals(value, firstname);	
	}


}
