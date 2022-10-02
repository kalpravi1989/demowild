package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Javautils;



public class ExtentFileReport {
	public static ExtentReports extentReportconfig(String filepath) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(filepath+"/ExtendReport"+Javautils.randonnumber()+".html");
		extent.attachReporter(spark);
		return extent;
	}

}
