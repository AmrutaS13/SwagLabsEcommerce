package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabsLoginPage;

public class SwagLabsLoginFunctionality extends BaseTest  {
	
	@BeforeMethod
	public void launchBrowser() {
	driver =Browser.launchBrowser("Chrome");
	}
	
	@Test
	public void verifyIfUserIsAbleToLoginSwagLabs() throws InterruptedException  {
		
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLoginButton();
		Thread.sleep(50000);
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

}
