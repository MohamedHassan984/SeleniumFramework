package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;

public class TestBase 
{
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName)
	{
		System.out.println("🚀 Running tests on: " + browserName); 
		if (browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}

	@AfterSuite
	public void stopDriver() 
	{
		if (driver != null)
		{
			driver.quit(); 
		}
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failed ! ");
			System.out.println("Taking Screenshot ! ");
			Helper.CaptureScreenShots(driver,result.getName());
		}
	} 
}
