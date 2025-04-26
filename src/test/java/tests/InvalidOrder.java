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
import pages.CartPage;
import pages.PlaceOrderPage;
import pages.SuccessPage;

public class InvalidOrder extends TestBase{
	
		CartPage carter;
		PlaceOrderPage order;
		SuccessPage suc;
		
		@Description("Invalid Order Data")
		@Severity(SeverityLevel.CRITICAL)
		@Test (priority = 1)
		public void invalidData() 
		{
			carter =new CartPage(driver);
			carter.makeorder();
			order =new PlaceOrderPage(driver);
			order.confirmorder("", "", "","", "", "");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			Assert.assertTrue(alertText.contains("Please fill out Name and Creditcard."));
			alert.accept();
			order.removeText();
		}
		@Test(priority = 2)
		public void invalidName() 
		{
			order =new PlaceOrderPage(driver);
			order.confirmorder("","nasr", "giza","254555554455145", "4", "2025");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			Assert.assertTrue(alertText.contains("Please fill out Name and Creditcard."));
			alert.accept();
			order.removeText();
		}
		@Test(priority = 3)
		public void invalidCreditCard() 
		{
			order =new PlaceOrderPage(driver);
			order.confirmorder("mohamed","nasr", "giza","", "4", "2025");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			Assert.assertTrue(alertText.contains("Please fill out Name and Creditcard."));
			alert.accept();
			order.removeText();
		}
		@Test(priority = 4)
		public void dismissOtherData() 
		{
			order =new PlaceOrderPage(driver);
			order.confirmorder("mohamed","", "","254555554455145", "", "");
			suc = new SuccessPage(driver);
			Assert.assertTrue(suc.success.contains("Thank you for your purchase!"));
			suc.orderOk();
			suc.outOfOrder();
		}
	}
