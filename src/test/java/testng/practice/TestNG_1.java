package testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListImple.class)
public class TestNG_1 
{
	public WebDriver driver;
	
	public static WebDriver sdriver;

	@Test
	public void sample() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sdriver=driver;
		driver.get("https://amazon.in");

		Thread.sleep(2000);

		Assert.assertEquals(true, true);



	}


}
