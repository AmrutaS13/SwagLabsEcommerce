package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReport() {
		ExtentReports reports=new ExtentReports();
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("SwagLabsReports.html");
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Application", "Swag Lab");
		reports.setSystemInfo("TestType", "Regression");
		reports.setSystemInfo("CreatedBy", "Amruta");
		return reports;

	}
 
}

