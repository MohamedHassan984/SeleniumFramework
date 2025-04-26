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
import pages.UserLoginPage;
import pages.UserSignUpPage;

public class UserLoginTest extends TestBase{

	HomePage homeObject;
	UserLoginPage loginObject;
	UserSignUpPage signObject;

	@Description("User Login")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void userSubmitLogin() 
	{
		homeObject = new HomePage(driver);
		homeObject.openLogin();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		loginObject = new UserLoginPage(driver);
        wait.until(ExpectedConditions.visibilityOf(loginObject.userNameLogin));
		signObject = new UserSignUpPage(driver);
		loginObject.userSubmitLogin(signObject.userName, signObject.password);
        wait.until(ExpectedConditions.visibilityOf(loginObject.successLogin));
		Assert.assertTrue(loginObject.successLogin.getText().contains("Welcome "));
	}

}
