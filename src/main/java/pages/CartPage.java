package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase
{

	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"tbodyid\"]/tr/td[2]")
	 WebElement nokiacheck;
	
	public String check =nokiacheck.getText();

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
	 WebElement placeOrder;
	
	@FindBy(xpath = "//*[@id=\"tbodyid\"]/tr/td[4]/a")
	 WebElement delete;
	
	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/h2")
	 WebElement Total;
	
	public String checkTotal=Total.getText();
	
	public void makeorder() 
	{
		clickButton(placeOrder);
	}
	
	public void deleteorder() 
	{
		clickButton(delete);
	}
	
}
