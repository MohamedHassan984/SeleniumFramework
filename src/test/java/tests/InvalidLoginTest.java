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
import pages.HomePage;
import pages.UserInvalidLoginPage;

public class InvalidLoginTest  extends TestBase{

	HomePage homeObject;
	UserInvalidLoginPage loginObject;

	@Description("Invalid Login Data")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1)
	public void InvalidData()
	{
		homeObject = new HomePage(driver);
		homeObject.openLogin();
		loginObject = new UserInvalidLoginPage(driver);
		loginObject.userSubmitLogin("", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Please fill out Username and Password."));
		alert.accept();
		loginObject.removeText();
	}
	
	@Test(priority = 2)
	public void InvalidUserName()
	{
		loginObject = new UserInvalidLoginPage(driver);
		loginObject.userSubmitLogin("1110460","123456");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert2.getText();
		Assert.assertTrue(alertText.contains("User does not exist."));
		alert2.accept();
		loginObject.removeText();
	}
	@Test(priority = 3)
	public void InvalidPassword()
	{
		loginObject = new UserInvalidLoginPage(driver);
		loginObject.userSubmitLogin("mohamedhassanmostafa","5551215");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert2.getText();
		Assert.assertTrue(alertText.contains("Wrong password."));
		alert2.accept();
		loginObject.removeText();
		loginObject.userCloseLogin();
	}
}
