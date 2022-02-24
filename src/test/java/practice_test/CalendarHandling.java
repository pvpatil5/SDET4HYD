package practice_test;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

	@Test(dataProvider = "city")
	public void selectcity(String src, String dest) throws InterruptedException {

		Date date = new Date();
		String currentdate=date.toString();

		String[] arr = currentdate.split(" ");

		String day=arr[0];
		String month=arr[1];
		String todaydate=arr[2];
		String year=arr[5];

		String xpath=day+" "+month+" "+todaydate+" "+year;

		System.out.println(xpath);

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
		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@aria-label='"+xpath+"']")).click();


	}
	
	@DataProvider
	public Object[][] city() {
		
		Object arr[][]= new Object[4][2];

		arr[0][0]="PNQ";
		arr[0][1]="BLR";
		
		
		arr[1][0]="MAA";
		arr[1][1]="BOM";


		arr[2][0]="HYD";
		arr[2][1]="CCU";


		arr[3][0]="DEL";
		arr[3][1]="NYC";

		return arr;

	}

	
	
	
}
