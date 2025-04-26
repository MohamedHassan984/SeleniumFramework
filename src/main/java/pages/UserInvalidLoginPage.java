package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInvalidLoginPage extends PageBase{

	public UserInvalidLoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id = "loginusername")
	WebElement userNameLogin;

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

	public void removeText() 
	{
	userNameLogin.clear();
	passwordLogin.clear();
	}
	public void userCloseLogin() 
	{
		clickButton(logincloseBtn);
	}
	
	
	
}
