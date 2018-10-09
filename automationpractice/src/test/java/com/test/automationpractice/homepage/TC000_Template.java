package com.test.automationpractice.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;
import com.test.automationpractice.uiActions.HomePage;
import com.test.automationpractice.uiActions.LoginPage;

public class TC000_Template extends TestBase{

	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	@BeforeTest
	public void setUp() {
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		
	}
	
	@AfterClass
	public void endTest() {
		driver.close();
	}
}
