package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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
import pom.SwagLabsLogoutPage;


@Listeners(test.Listeners.class)
public class VerifySwagLabsLogoutFunctionality extends BaseTest {
	 ExtentReports reports;
	 ExtentTest test;
	 @BeforeTest
	 public void configureReports() {
		 reports=Reports.createReport();
	 }
	//WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void LonchBrowser() {
		driver=Browser.launchBrowser("Chrome");
	}
	@Test
	public void verifyIfACustomerAbletoPlace() throws EncryptedDocumentException, IOException, InterruptedException {
       test=reports.createTest("verifyIfACustomerAbletoPlace");
		SwagLabsLoginPage swagLoginPage=new SwagLabsLoginPage(driver);
		swagLoginPage.enterUserName("standard_user");
		swagLoginPage.enterPassword("secret_sauce");
		swagLoginPage.clickOnLoginButton();
		Thread.sleep(2000);
		SwagLabsAddToCartPage swagLabsAddToCartPage=new SwagLabsAddToCartPage(driver);
		switchToChildWindow(driver,swagLabsAddToCartPage.gettitle(0));
		Thread.sleep(2000);
		SwagLabsLogoutPage swagLabsLogoutPage= new SwagLabsLogoutPage(driver);
		swagLabsLogoutPage.clickOnopenMenu();
		Thread.sleep(2000);
		swagLabsLogoutPage.clickOnlogoutButton();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
		

}
}