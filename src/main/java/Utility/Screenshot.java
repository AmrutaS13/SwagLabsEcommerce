package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void takeScreenShot(String name,WebDriver driver) throws IOException {
		   String dateAndTime  =DateAndTime.getDateAndTime();
			
			File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destination =new File("C:\\Users\\HMGAS-PINGLAS\\eclipse-workspace\\SwagLabs\\Screenshots\\"+name+dateAndTime+".png");
			
			FileHandler.copy(source, destination);

		}

	}

