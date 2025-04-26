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

public class InvalidSignUpTest extends TestBase {
	
	HomePage homeObject;
	UserSignUpPage signUpObject;

	@Description("Invalid SignUp Data")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1)
	public void invalidSignup()
	{
		homeObject = new HomePage(driver);
		homeObject.openSignUp();
		signUpObject = new UserSignUpPage(driver);
		signUpObject.userSubmitSignUp("", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Please fill out Username and Password."));
		alert.accept();
		signUpObject.removeText();
	}
	
	@Test(priority = 2)
	public void invalidPasswordSignup()
	{
		signUpObject = new UserSignUpPage(driver);
		signUpObject.userSubmitSignUp("mohamed hassan mostafa55", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Please fill out Username and Password."));
		alert.accept();
		signUpObject.removeText();
	}
	
	@Test(priority = 3)
	public void invalidUserNameSignup()
	{
		signUpObject = new UserSignUpPage(driver);
		signUpObject.userSubmitSignUp("mohamed hassan mostafa", "123456");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("This user already exist."));
		alert.accept();
		signUpObject.removeText();
		signUpObject.userCloseSignUp();
	}
}