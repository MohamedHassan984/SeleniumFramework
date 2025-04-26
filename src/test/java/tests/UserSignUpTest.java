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
import pages.UserSignUpPage;

public class UserSignUpTest extends TestBase{

	HomePage homeObject;
	UserSignUpPage signUpObject;

	@Description("User SignUp")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void userSubmitSignup()
	{
		homeObject = new HomePage(driver);
		homeObject.openSignUp();
		signUpObject = new UserSignUpPage(driver);
		signUpObject.userSubmitSignUp(signUpObject.userName, signUpObject.password);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Sign up successful."));
		alert.accept();
	}
}