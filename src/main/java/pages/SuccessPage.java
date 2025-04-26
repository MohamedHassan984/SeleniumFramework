package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends PageBase {

	public SuccessPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "/html/body/div[10]/h2")
	WebElement successOrder;
	public String success =successOrder.getText();
	
	@FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
	WebElement okeyOdrer;
	
	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
	WebElement goOut;
	
	
	public void orderOk()
	{
		clickButton(okeyOdrer);
	}
	
	public void outOfOrder()
	{
		clickButton(goOut);
	}
}
