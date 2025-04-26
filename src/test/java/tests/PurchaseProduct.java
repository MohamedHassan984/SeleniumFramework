package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;

public class PurchaseProduct extends TestBase
{
	HomePage home;
	
	@Description("User Purchase")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Purchaseproduct() 
	{
		home = new HomePage(driver);
		home.userCanPurchaseNokia();
	}

}
