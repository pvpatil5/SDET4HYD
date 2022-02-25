package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.ObjectRepo.CreateOrgPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.OrgInfoPage;
import com.crm.Vtiger.GenericPac.Base_Class;
import com.crm.Vtiger.GenericPac.IAutoConstants;
import com.crm.Vtiger.GenericPac.JavaUtil;

public class TC002_CreateOrg_DD extends Base_Class{

	public void create_Org_DD() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage homepage= new HomePage(driver);
		homepage.getOrginizationlink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		FileInputStream fisexcel = new FileInputStream(IAutoConstants.excelpath);

		int randomnumber = jv.generateRandomNumber();

		String orgnameexcel=WorkbookFactory.create(fisexcel).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();

		String orgname= orgnameexcel+randomnumber;

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

		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PASS");
		}
		else {
			System.out.println("TC Fail");
		}
	}
}
