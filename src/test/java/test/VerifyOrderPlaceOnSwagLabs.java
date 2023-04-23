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
public class VerifyOrderPlaceOnSwagLabs extends BaseTest{
   ExtentReports reports;
   ExtentTest test;
	
	@BeforeTest
	public void configurationReports()  {
		ExtentReports reports = Reports.createReport();
		
	}
	@BeforeMethod
	@Parameters("Browser")
	public void LonchBrowser() {
		driver=Browser.launchBrowser("Chrome");
}
	@Test
	public void verifyIfACustomerAbletoPlace() throws EncryptedDocumentException, IOException, InterruptedException {
        test=reports.createTest("verifyIfACustomerAbletoPlace");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLoginButton();
		Thread.sleep(2000);
		SwagLabsAddToCartPage swagLabCartPage=new SwagLabsAddToCartPage(driver);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.directClickOnAddCartProductButton(0);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		swagLabCartPage.ClickOnCartItemIcon();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.clickOnChekOutButton();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		
		SwagLabsCheckOutPage swagLabsCheckOutPage=new SwagLabsCheckOutPage(driver);
		Thread.sleep(2000);
		swagLabsCheckOutPage.enterFirstName("Amruta");//(Parameterization.getExcelData("Credentials", 0, 0));
		swagLabsCheckOutPage.enterLastName("Patil");//(Parameterization.getExcelData("Credentials", 0, 0));
		swagLabsCheckOutPage.enterPostalCode("410201");//(Parameterization.getExcelData("Credentials", 0, 0));
		swagLabsCheckOutPage.clickOnContinueButton();
		Thread.sleep(2000);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		swagLabsCheckOutPage.clickOnFinishButton();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		swagLabsCheckOutPage.ClickOnBackToHome();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		//Assert.assertTrue();
		
		
	}
}