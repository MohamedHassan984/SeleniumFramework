package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ContactAsPage;
import pages.HomePage;
import pages.UserSignUpPage;

public class ContactAs extends TestBase {
	
	HomePage home;
	ContactAsPage contact;
	UserSignUpPage sign;
	
	@Description("User Can Contact As")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void UserCanContact()
	{
		home = new HomePage(driver);
		home.clickContactNav();
		contact = new ContactAsPage(driver);
		sign = new UserSignUpPage(driver);
		contact.UserCanSubmitContent(sign.userName,"mohamed","I Appreciate Working With This Organization..");	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Thanks for the message!!"));
		alert.accept();
	}
}
