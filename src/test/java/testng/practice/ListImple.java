package testng.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImple implements ITestListener
{

	//WebDriver driver;
	public void onTestStart(ITestResult result) 
	{
		System.out.println("this msg is printing from On test Start");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TC PAsses");
	}

	public void onTestFailure(ITestResult result) {
		File srcfile =((TakesScreenshot) TestNG_1.sdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+"amazon1"+".png";
		File finaldest = new File(destfile) ;
		try {
			FileUtils.copyFile(srcfile,finaldest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
	
	}

}
