package tests;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;

public class PurchaseFromSecondPage extends TestBase {
	
	HomePage home;
	
	@Description("User Purchase From Second Page")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void purchaseSecondPage() 
	{
		((JavascriptExecutor) driver).executeScript( "window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
		home = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));  
		home.moveToNext();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));  
		home.choseProdct();
	}

}
