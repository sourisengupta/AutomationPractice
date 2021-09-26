package com.test.automationpractice.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automationpractice.homepage.TC001_VerifyLoginWithInvalidCredentials;
import com.test.automationpractice.testBase.TestBase;

public class PLPTShirt {
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	WebDriver driver;
	
	//ul[@class='product_list grid row']/li/div[@class='product-container']/div[@class='right-block']/div[@class='button-container']/a/span[contains(text(),'Add to cart')]
	
	List<WebElement> listOfProducts ;
	
	public PLPTShirt(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	WebElement xpathOfProducts;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li/div[@class='product-container']/div/div/a/img")
	WebElement xpathOf1stProducts;
	
	@FindBy(xpath="//h5[@itemprop='name']")
	WebElement xpath1stProdName;
	
	public void scrollTo1stProduct() throws InterruptedException {
		TestBase testbase = new TestBase();
		testbase.scrollToElement(xpath1stProdName);
	}
	
	public void hoverAndClick1stProduct() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(xpath1stProdName).perform();
		xpath1stProdName.click();
		
//		Thread.sleep(3000);
//		xpathOf1stProducts.isDisplayed();
		//action.click().build().perform();
		
//		Thread.sleep(3000);
	}
	public void click1stProduct() {
		xpathOf1stProducts.click();
	}
	
	public int getProductCount() {
		listOfProducts = driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));		
		return listOfProducts.size();
	}
}
