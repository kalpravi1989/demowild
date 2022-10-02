package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import base.ExtentFileReport;


public class BaseClass {
	public static WebDriver driver;
	public static String configfile = "./src/test/resources/config.properties";
	public static String extendreportpath = "./Reports";
	public static String screenshotspath= System.getProperty("user.dir")+"/Screenshots";
	public static String testdatafile = "./src/main/resources/TestData.xlsx";
	public static Properties prop = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;

	@BeforeSuite
	public void setup() {
		prop = Propertiesfile.loadPropertyFile(configfile);
		extent = ExtentFileReport.extentReportconfig(extendreportpath);
		
	}

	@BeforeMethod
	public void launchDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	public void teardown() {
		driver.quit();
	}
}
