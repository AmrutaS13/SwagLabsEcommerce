package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsAddToCartPage {

WebDriver driver;
	
	@FindBy(xpath="//div[@class='inventory_item']")private List<WebElement> products; 
	@FindBy(xpath="//div[@class='app_logo']")private List<WebElement>title;
	@FindBy(xpath="//div[@class='inventory_item_img']")private List<WebElement> image;
	@FindBy(xpath="//button[text()='Add to cart']")private WebElement addCartButton;
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']") private List<WebElement> addCart;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement cartIcon;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private List<WebElement> cartItem;
	@FindBy(xpath="//button[@id='checkout']")private WebElement checkoutButton;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement remove;
	@FindBy(xpath="//button[@id='continue-shopping']")private WebElement continueShoping;
	public SwagLabsAddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTheProducts(int index)
	{
//		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5)) ;
//		 wait.until(ExpectedConditions.visibilityOfAllElements(products));
		 products.get(index).click();
	}
	public String gettitle(int index)
	{
		return title.get(index).getText();
	}
	public void directClickOnAddCartProductButton(int index)
	{
		
		 addCart.get(index).click();
		
	}
	public void ClickOnCartItemIcon()
	{
		cartIcon.click();
	}
	public void clickOnChekOutButton() {
		checkoutButton.click();
	}
	public int totalNumberOfProductInCart( )
	{
		return cartItem.size();
	
	}
	public void ClickOnRemoveButton() {

		remove.click();
	}
	public void clickOnContinueShopingButton() {
		continueShoping.click();
		
	}

     public void directClickOnImage(int index) {
    	 image.get(index).click();;
	    
     }

}
