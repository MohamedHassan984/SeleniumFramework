package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactAsPage extends PageBase{

	public ContactAsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id = "exampleModalLabel")
	public WebElement addressContact ;
	
	@FindBy(xpath = "//*[@id=\"recipient-email\"]")
	public WebElement emailContact ;
	
	@FindBy(xpath = "//*[@id=\"recipient-name\"]")
	public WebElement nameContact ;
	
	@FindBy(xpath = "//*[@id=\"message-text\"]")
	public WebElement massageContact ;
	
	@FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")
	public WebElement submitContact ;
	
	@FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")
	public WebElement closeContact ;
	

	public void UserCanSubmitContent(String email,String name,String massage)
	{
		setTextElementText(emailContact, email);
		setTextElementText(nameContact, name);
		setTextElementText(massageContact, massage);
		clickButton(submitContact);
	}
	
	public void UserCanCloseContent()
	{
		clickButton(closeContact);
	}
	

}
