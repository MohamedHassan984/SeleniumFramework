package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserSignUpPage extends PageBase {

	public UserSignUpPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id = "sign-username")
	WebElement signUserName;
	
	@FindBy(id = "sign-password")
	WebElement signPass;
	
	@FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
	WebElement signAcceptBtn;
	
	@FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
	WebElement signCloseBtn;
	
	private static final String generatedUser = "mohamedhassan" + System.currentTimeMillis() + "@gmail.com";

    
	public  String userName=generatedUser;
	
	public  String password="mm@123456";

	
	public void userSubmitSignUp(String UserName,String Password) 
	{
		setTextElementText(signUserName, UserName);
		setTextElementText(signPass, Password);
		clickButton(signAcceptBtn);
	}
	
	public void removeText() 
	{
	signUserName.clear();
	signPass.clear();
	}
	
	public void userCloseSignUp() 
	{
		clickButton(signCloseBtn);
	}
}
