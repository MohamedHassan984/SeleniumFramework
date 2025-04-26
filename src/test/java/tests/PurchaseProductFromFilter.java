package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;

public class PurchaseProductFromFilter  extends TestBase{
	
	HomePage home;
	
	@Description("User Purchase From Categories")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Purchaseproduct() 
	{
		home = new HomePage(driver);
		home.userCanFilter();
		home.userCanClick();
	}
}
