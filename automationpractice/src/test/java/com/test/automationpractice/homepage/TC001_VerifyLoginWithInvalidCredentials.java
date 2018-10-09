package com.test.automationpractice.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;
import com.test.automationpractice.uiActions.HomePage;
import com.test.automationpractice.uiActions.LoginPage;


public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{	
	
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	HomePage 	homepage;
	LoginPage 	loginpage;
	
	@BeforeTest
	public void setUp() {
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		log.info("==============Starting verifyLoginWithInvalidCredentials===========");
		homepage = new HomePage(driver);
		homepage.clickSignIn();
		//Thread.sleep(3000);
		
		loginpage = new LoginPage(driver);
		loginpage.loginToApplication("abc@abc.com", "Pass123");
		Assert.assertEquals(loginpage.getInvalidLoginText(), "Authentication failed.");
		log.info("==============Finished verifyLoginWithInvalidCredentials===========");
	}
	
	@AfterClass
	public void endTest() {
		driver.close();
	}
}
