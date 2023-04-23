package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage {

	@FindBy(xpath="//input[@id=\"user-name\"]")private WebElement userName;
	@FindBy(xpath="//input[@type=\"password\"]")private WebElement password;
	@FindBy(xpath="//input[@id=\"login-button\"]")private WebElement login;
	
	public SwagLabsLoginPage(WebDriver driver)  {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username)   {
		userName.sendKeys(username);
	}
	public void enterPassword(String pass) {
	password.sendKeys(pass);
	
	}
	public void clickOnLoginButton()  {
		login.click();
	}
	
}
