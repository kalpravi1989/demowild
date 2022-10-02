package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import base.BaseClass;


public class Seleniumutils extends BaseClass{
	public static void entertext(WebElement ele, String value) {
		try {
			waitvisibleele(ele);
			ele.clear();
			ele.sendKeys(value);
			logpass("The Value Entered as: " + value);
		} catch (Exception e) {
			logfail(e.getMessage());
		}
	}

	public static void seleiumclick(WebElement ele) {
		try {
			waitclickable(ele);
			ele.click();
			logpass("Element was clicked");
		} catch (Exception e) {
			logfail(e.getMessage());
		}
	}
	
	public static void textvalidation(WebElement ele, String exptxt) {
		try {
			Assert.assertTrue(waitvisibletxt(ele,exptxt));
			logpass("Expected value is " +exptxt+" actual was matched "+ele.getText());
		} catch (Exception e) {
			logfail(e.getMessage());
		}
	}
	
	public static void logpass(String desc) {
		
		//test.log(Status.PASS, desc+test.addScreenCaptureFromPath(getscreenshot()));
		test.pass(desc,MediaEntityBuilder.createScreenCaptureFromBase64String(getscreenBase64()).build());
	}
	
	public static void logfail(String desc) {
		//test.log(Status.FAIL, desc+test.addScreenCaptureFromPath(getscreenshot()));
		test.fail(desc,MediaEntityBuilder.createScreenCaptureFromBase64String(getscreenBase64()).build());
	}
	
	
	public static String getscreenBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	public static String getscreenshot() {
		String filepath=null;
		try {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File source = screen.getScreenshotAs(OutputType.FILE);
			
			filepath = screenshotspath +"/Screen_"+Javautils.randonnumber()+".png";
			File desination = new File(filepath);
			FileUtils.copyFile(source, desination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filepath;
	}

	public static void waitvisibleele(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static boolean waitvisibletxt(WebElement ele,String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

	public static void waitclickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}


}
