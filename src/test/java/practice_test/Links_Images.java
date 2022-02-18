package practice_test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links_Images {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://amazon.in");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement srchbox = driver.findElement(By.id("twotabsearchtextbox"));

		srchbox.sendKeys("Samsung TV");

		Thread.sleep(2000);

		String str = srchbox.getAttribute("value");

		System.out.println(str);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) 
		{
			String link = links.get(i).getAttribute("href");
			System.out.println(link);

			verifyLinkActive(link);

		}
	}

	public static void verifyLinkActive(String linkUrl) throws IOException
	{
		try {


			URL url = new URL(linkUrl);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			urlconnection.setConnectTimeout(3000);

			urlconnection.connect();

			if(urlconnection.getResponseCode()==200)
			{
				System.out.println(urlconnection.getResponseMessage());
			}
			else if(urlconnection.getResponseCode()==urlconnection.HTTP_NOT_FOUND)
			{
				System.out.println(urlconnection.getResponseMessage());
			}	

		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	} 



}
