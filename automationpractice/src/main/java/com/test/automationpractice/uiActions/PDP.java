package com.test.automationpractice.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automationpractice.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class PDP {
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	WebDriver driver;
	
	public PDP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	WebElement xpathOfProducts;
	
	
	@FindBy(xpath="//button[@name='Submit']/span[contains(text(),'Add to cart')]")
	WebElement xpathAddToCart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement xpathProceedToCheckout;
	
	public void clickAddToButton() {
		xpathAddToCart.click();
	}
	
	public void clickProceedToCheckout() {
		xpathProceedToCheckout.click();
	}
}
