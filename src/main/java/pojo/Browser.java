package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	static WebDriver driver;
	public static WebDriver launchBrowser(String name)  {
		if(name.equals("Chrome"))
		{	WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(opt);
		 
		 
		}
		else if(name.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
		  driver =new EdgeDriver();
		  
		}
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		return driver;
		
	}
}
