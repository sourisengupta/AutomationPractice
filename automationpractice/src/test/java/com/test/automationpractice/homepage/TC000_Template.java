package com.test.automationpractice.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class TC000_Template extends TestBase{

	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	String url="http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		// Simple Alert example		
		driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		
		// Confirm pop up example
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Pop up')]")).click();
		Alert popupAlert = driver.switchTo().alert();
		popupAlert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Pop up')]")).click();
		popupAlert = driver.switchTo().alert();
		popupAlert.dismiss();
	}
	
	@AfterClass
	public void endTest() {
		//closeApp();
	}
}
