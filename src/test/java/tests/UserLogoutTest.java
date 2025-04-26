package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;

public class UserLogoutTest extends TestBase {
	
	HomePage logoutObject;
	
	@Description("User Logout")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void userLogout() 
	{
		logoutObject = new HomePage(driver);
		logoutObject.userCanLogout();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	    wait.until(ExpectedConditions.visibilityOf(logoutObject.login));
	    Assert.assertTrue(logoutObject.login.getText().contains("Log in"));
	}
}
