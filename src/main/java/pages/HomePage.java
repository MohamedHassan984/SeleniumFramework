package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id ="signin2")
	WebElement signUp;

	@FindBy(id="login2")
	public WebElement login;


	@FindBy(id = "logout2")
	public WebElement logoutBtn;
	
	@FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
	public WebElement productNokia ;
	
	@FindBy(xpath = "//html/body/div[5]/div/div[1]/div/a[2]")
	public WebElement phoneFilter ;
	
	@FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
	public WebElement samsungMonitor ;
	
	@FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
	public WebElement ContactNav ;
	
	@FindBy(xpath = "//*[@id=\"cartur\"]")
	public WebElement CartNav ;
	
	@FindBy(xpath = "//*[@id=\"next2\"]")
	public WebElement nextPage ;
	
	@FindBy(xpath = "//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")
	public WebElement dellProduct ;
	
	public void openSignUp()
	{
		clickButton(signUp);
	}

	public void openLogin() 
	{
		clickButton(login);
	}
	
	public void userCanLogout() 
	{
		clickButton(logoutBtn);
	}
	
	public void userCanPurchaseNokia() 
	{
		clickButton(productNokia);
	}
	
	public void userCanFilter() 
	{
		clickButton(phoneFilter);
	}
	
	public void userCanClick() 
	{
		clickButton(samsungMonitor);
	}
	
	public void clickContactNav() 
	{
		clickButton(ContactNav);
	}
	
	public void clickCartNav() 
	{
		clickButton(CartNav);
	}
	
	public void moveToNext() 
	{
		clickButton(nextPage);
	}
	
	public void choseProdct() 
	{
		clickButton(dellProduct);
	}
}
