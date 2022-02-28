package com.crm.Vtiger.GenericPac;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * This class is going to have all web driver methods.
 * @author AMAR-G
 *
 */

public class WebDriverUtility 
{


	/**
	 * @author AMAR-G
	 * This Method wait until page is loaded or not.
	 * @param driver
	 */
	public void pageloadtimeout(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 * @author AMAR-G
	 * 
	 * This Method is selecting value from DD by Visible Text
	 * @param element
	 * @param value
	 */

	public void selectfromdd(WebElement element,String text) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);		
	}

	/**
	 * This method is gonna move to target element
	 * @param driver
	 * @param target
	 */

	public void movetoelement(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();
	}

	public void selectfromdd(String value,WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectfromdd(int index,WebElement element) 
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}


	/**
	 * This method is going to swtich the window on basis of title
	 * @param title
	 * @param driver
	 */

	public void swtichtowindow(String title,WebDriver driver)
	{
		Set<String> winids = driver.getWindowHandles();
		String currenttitle;
		for (String string : winids) 
		{
			currenttitle=	driver.switchTo().window(string).getTitle();

			if(currenttitle.contains(title)) 
			{
				break;
			}
		}
	}

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void entertextinAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	/**
	 * @author AMAR-G
	 * This method is gonna give text from Alert popup
	 * @param driver
	 * @param text
	 * @return
	 */
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void switchframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchframe(WebDriver driver, String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	public void switchframe(WebElement element,WebDriver driver)
	{
		driver.switchTo().frame(element);
	}

}
