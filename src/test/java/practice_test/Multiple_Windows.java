package practice_test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Windows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://business.linkedin.com/marketing-solutions/conversion-tracking");

		driver.findElement(By.xpath("//a[contains(text(),'Cookie Policy')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'User Agreement')]")).click();

		Thread.sleep(3000);

		Set<String> winids = driver.getWindowHandles();

		//Iterator<String> id = winids.iterator();

		String title;
		for (String string : winids)
		{
			title=	driver.switchTo().window(string).getTitle();
			if(title.equalsIgnoreCase("Cookie Policy | LinkedIn")) {
				System.out.println(title);
				//driver.close();
				break;
			}
		}
		
		System.out.println(driver.findElement(By.tagName("h1")).getText());
	}

}
