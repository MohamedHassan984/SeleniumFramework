package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase{

	public UserLoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id = "loginusername")
	public WebElement userNameLogin;

	@FindBy(id = "loginpassword")
	WebElement passwordLogin;

	@FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement loginAcceptBtn;

	@FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")
	WebElement logincloseBtn;
	
	@FindBy(id = "nameofuser")
	public WebElement successLogin;
	
	
	public void userSubmitLogin(String UserName,String Password) 
	{
		setTextElementText(userNameLogin, UserName);
		setTextElementText(passwordLogin, Password);
		clickButton(loginAcceptBtn);
	}

	public void userCloseLogin() 
	{
		clickButton(logincloseBtn);
	}
	
	
}
