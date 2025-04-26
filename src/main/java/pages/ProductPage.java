package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
	WebElement addToCartBtn;
	
	@FindBy(xpath  = "//*[@id=\"navbarExample\"]/ul/li[4]/a")
	WebElement cartur;
	
	
	public void addToCart() 
	{
		clickButton(addToCartBtn);
	}
	
	public void checkCart() 
	{
		clickButton(cartur);
	}
	

}
