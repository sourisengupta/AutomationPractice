package com.test.automationpractice.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automationpractice.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class HomePage {
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	//WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement lnkTabWomen;
	
	@FindBy(xpath="//a[@title='Dresses']")
	WebElement lnkTabDresses;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
	WebElement lnkTabTshirts;
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public void clickTabWomen() {
		lnkTabWomen.click();
	}
	
	public void clickTabDresses() {
		lnkTabDresses.click();
	}
	
	public void clickTabTshirts() {
		lnkTabTshirts.click();
	}
}
