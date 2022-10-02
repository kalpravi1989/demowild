package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Seleniumutils;

public class HomePage extends Seleniumutils {

	WebDriver mydriver;

	public HomePage(WebDriver driver) {
		this.mydriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@class='btn-menu']/child::span")
	public WebElement mainMenu;
	

public void clickMenu() {
	seleiumclick(mainMenu);
	
}
}