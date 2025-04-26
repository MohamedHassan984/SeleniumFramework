package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CartPage;
import pages.PlaceOrderPage;
import pages.SuccessPage;

public class ContinueOrder extends TestBase{
	
	CartPage carter;
	PlaceOrderPage order;
	SuccessPage suc;
	
	@Description("User Can Continue Order")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void confirmProduct() 
	{
		carter =new CartPage(driver);
		carter.makeorder();
		order =new PlaceOrderPage(driver);
		order.confirmorder("mohamed", "nasr", "giza","254555554455145", "4", "2025");
		suc = new SuccessPage(driver);
		Assert.assertTrue(suc.success.contains("Thank you for your purchase!"));
		suc.orderOk();
		suc.outOfOrder();
	}
}
