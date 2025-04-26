package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends PageBase
{

	public PlaceOrderPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
	WebElement placeOrder;
	
	
	@FindBy(id = "name")
	WebElement namePurchaser;
	
	@FindBy(id = "country")
	WebElement CountryPurchaser;

	@FindBy(id = "city")
	WebElement CityPurchaser;

	@FindBy(id = "card")
	WebElement CreditCardPurchaser;

	@FindBy(id = "month")
	WebElement MonthPurchase;

	@FindBy(id = "year")
	WebElement yearPurchase;
	
	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	WebElement confirmPurchase;
	
	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
	WebElement closePurchase;
	
	
	
	public void confirmorder(String name,String country,String city,String CreditCard,String mouth,String year)
	{
		setTextElementText(namePurchaser, name);
		setTextElementText(CountryPurchaser, country);
		setTextElementText(CityPurchaser, city);
		setTextElementText(CreditCardPurchaser, CreditCard);
		setTextElementText(MonthPurchase, mouth);
		setTextElementText(yearPurchase, year);
		clickButton(confirmPurchase);
	}
	
	
	public void removeText() 
	{
		namePurchaser.clear();
		CountryPurchaser.clear();
		CityPurchaser.clear();
		CreditCardPurchaser.clear();
		MonthPurchase.clear();
		yearPurchase.clear();
	}
	
	public void userCloseOrder() 
	{
		clickButton(closePurchase);
	}
	
	public void makeOrder() 
	{
		clickButton(placeOrder);
	}
}
