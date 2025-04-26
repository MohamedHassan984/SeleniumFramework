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
import pages.ProductPage;

public class AddToCart extends TestBase {
	
	ProductPage proPage;

	@Description("User Can Add To Cart")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void AddProduct()
	{
		proPage = new ProductPage(driver);
		proPage.addToCart();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Product added"));
		alert.accept();
		proPage.checkCart();
	}
}
