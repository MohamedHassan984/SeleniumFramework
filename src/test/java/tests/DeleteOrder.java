package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CartPage;
import pages.PlaceOrderPage;
import pages.SuccessPage;

public class DeleteOrder extends TestBase{
	CartPage carter;
	PlaceOrderPage order;
	SuccessPage suc;
	
	@Description("User Can Delete Order")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void DeleteProduct() 
	{
		carter =new CartPage(driver);
		carter.deleteorder();
		Assert.assertEquals(carter.checkTotal,"Total");
	}

}
