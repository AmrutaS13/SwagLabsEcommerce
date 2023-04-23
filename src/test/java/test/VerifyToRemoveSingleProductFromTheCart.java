package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import pom.SwagLabsCheckOutPage;
import pom.SwagLabsLoginPage;





@Listeners(test.Listeners.class)
public class VerifyToRemoveSingleProductFromTheCart extends BaseTest{
	 ExtentReports reports;
	 ExtentTest test;
	 @BeforeTest
	 public void configureReports() {
		 reports=Reports.createReport();
	 }
	//WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void launchBrowser()	{
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
	public void removesingleProductFromCart() throws InterruptedException {
		test=reports.createTest("removeSingleProductFromCart");
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
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabsAddToCartPage.ClickOnRemoveButton();
		Thread.sleep(2000);
	//	Assert.assertEquals(swagLabCartPage.totalNumberOfProductInCart(), 0);
//		int product=swagLabCartPage.totalNumberOfProductInCart();
//		System.out.println(product);
//		Assert.assertTrue(product==0);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
	}
	
	@Test
	public void toVarifyProductChekoutFunctionality() throws InterruptedException, EncryptedDocumentException, IOException
	{
		test=reports.createTest("toVarifyProductChekoutFunctionality");
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
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabsAddToCartPage.clickOnChekOutButton();
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		
		SwagLabsCheckOutPage swagLabsCheckOutPage=new SwagLabsCheckOutPage(driver);
		swagLabsCheckOutPage.enterFirstName("Amruta");//(Parameterization.getExcelData("Credentials", 0, 2));
		swagLabsCheckOutPage.enterLastName("Patil");//(Parameterization.getExcelData("Credentials", 0, 3));
		swagLabsCheckOutPage.enterPostalCode("410201");//(Parameterization.getExcelData("Credentials", 1, 2));
		swagLabsCheckOutPage.clickOnContinueButton();
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		
	}
	@Test
	public void toVarifyProductChekoutCanselButtonFunctionality() throws EncryptedDocumentException, IOException, InterruptedException {
		test=reports.createTest("toVarifyProductChekoutCanselButtonFunctionality");
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
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
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
	
	
