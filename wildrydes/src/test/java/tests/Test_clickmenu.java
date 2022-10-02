package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;

public class Test_clickmenu extends HomePage {
	
	

	

	public Test_clickmenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void menu() {
		ExtentTest test = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		clickMenu();
	}

}
