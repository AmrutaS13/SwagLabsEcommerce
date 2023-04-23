package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsCheckOutPage {

	@FindBy(xpath="")private WebElement CheckoutButton;
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement postalCode;
	@FindBy(xpath="//input[@id='continue']")private WebElement continueButton;
	@FindBy(xpath="//button[@id='cancel']")private WebElement cancel;
	@FindBy(xpath="//button[@id='finish']")private WebElement finish;
	@FindBy(xpath="//button[@id='back-to-products']")private WebElement backHome;
	@FindBy(xpath="//h2[@class='complete-header']")private WebElement Thanku;
	public SwagLabsCheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	public void enterPostalCode(String code)
	{
		postalCode.sendKeys(code);
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public void clickOnCancelbutton()
	{
		cancel.click();
	}
	public void clickOnFinishButton() {
		finish.click();
	}
	public void ClickOnBackToHome() {
		backHome.click();
	}
	
	
}
	

