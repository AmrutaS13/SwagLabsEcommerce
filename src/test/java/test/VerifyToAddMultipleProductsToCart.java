package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.Reports;
import pojo.Browser;

import pom.SwagLabsAddToCartPage;
import pom.SwagLabsCheckOutPage;
import pom.SwagLabsLoginPage;


public class VerifyToAddMultipleProductsToCart extends BaseTest{

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
	public void AddMultipleProductsToCart() throws InterruptedException  {
		test=reports.createTest("verifyIfCustomerIsAbleToAddMultipleProductToCart");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLoginButton();
		Thread.sleep(2000);
		SwagLabsAddToCartPage swagLabsAddToCartPage=new SwagLabsAddToCartPage(driver);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabsAddToCartPage.directClickOnAddCartProductButton(0);
		Thread.sleep(4000);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		swagLabsAddToCartPage.ClickOnCartItemIcon();
		int product=swagLabsAddToCartPage.totalNumberOfProductInCart();
		
		
		
		
		
		
		Thread.sleep(4000);
		swagLabsAddToCartPage.clickOnContinueShopingButton();
		Thread.sleep(3000);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabsAddToCartPage.directClickOnAddCartProductButton(1);
		Thread.sleep(4000);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		swagLabsAddToCartPage.ClickOnCartItemIcon();
		
		
		Thread.sleep(4000);
		swagLabsAddToCartPage.clickOnContinueShopingButton();
		Thread.sleep(3000);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabsAddToCartPage.directClickOnAddCartProductButton(2);
		Thread.sleep(4000);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		swagLabsAddToCartPage.ClickOnCartItemIcon();
		System.out.println(product);
		Assert.assertTrue(product>0);
		Thread.sleep(3000);
		swagLabsAddToCartPage.clickOnChekOutButton();
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		
		SwagLabsCheckOutPage cartCheckOutPage=new SwagLabsCheckOutPage(driver);
		Thread.sleep(2000);
		cartCheckOutPage.enterFirstName("Amruta");//(Parameterization.getExcelData("Credentials", 0, 2));
		cartCheckOutPage.enterLastName("Patil");//(Parameterization.getExcelData("Credentials", 0, 3));
		cartCheckOutPage.enterPostalCode("410201");//(Parameterization.getExcelData("Credentials", 1, 2));
		cartCheckOutPage.clickOnCancelbutton();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		
	}
	
	    
	
}
	
	

