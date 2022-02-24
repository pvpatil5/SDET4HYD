package practice_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Future_date 
{

	@Test
	public void selectcity() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/flights/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.id("fromCity")).sendKeys("HYD");
		driver.findElement(By.xpath("//div[text()='HYD']")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys("PNQ");
		driver.findElement(By.xpath("//div[text()='PNQ']")).click();

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

		Thread.sleep(1000);

		for (int i = 0; i < 12; i++) {
			String month=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();

			System.out.println(month);
			if(month.contains("Feb")) {
				driver.findElement(By.xpath("//div[@aria-label='Mon Feb 28 2022']")).click();
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	
			}
		}
	}

}
