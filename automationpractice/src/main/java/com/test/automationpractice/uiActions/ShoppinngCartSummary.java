package com.test.automationpractice.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automationpractice.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class ShoppinngCartSummary {
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	WebDriver driver;
	
	public ShoppinngCartSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']/span[contains(text(),'Proceed to checkout')]")
	WebElement xpathProceedToCheckout;
	
	
	
	public void clickProceedToCheckout() {
		xpathProceedToCheckout.click();
	}
}
