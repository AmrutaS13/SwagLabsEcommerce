package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.Reports;
import pojo.Browser;
import pom.SwagLabsAddToCartPage;
import pom.SwagLabsLoginPage;


@Listeners(test.Listeners.class)
public class VerifyToAddSingleCartToProduct extends BaseTest{
	 ExtentReports reports;
	 ExtentTest test;
	 @BeforeTest
	 public void configureReports() {
		 reports=Reports.createReport();
	 }
	//WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void launchBrowser()
	{
		driver=Browser.launchBrowser("Chrome");
	}
	@Test
	public void addSingleProductToCart() throws InterruptedException 
	{
		test=reports.createTest("addSingleProductToCart");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLoginButton();
		Thread.sleep(2000);
		SwagLabsAddToCartPage swagLabsAddToCartPage=new SwagLabsAddToCartPage(driver);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabsAddToCartPage.directClickOnAddCartProductButton(0);
		
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		swagLabsAddToCartPage.ClickOnCartItemIcon();
		int product=swagLabsAddToCartPage.totalNumberOfProductInCart();
		System.out.println(product);
			Assert.assertTrue(product>0);
		
	}
	
	
}
	
	

