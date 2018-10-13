package com.test.automationpractice.homepage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automationpractice.testBase.TestBase;
import com.test.automationpractice.uiActions.HomePage;
import com.test.automationpractice.uiActions.LoginPage;

public class TC003_NewUserSignUp extends TestBase{
	
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	String url="http://automationpractice.com";
	HomePage homepage;
	LoginPage loginpage;
	
	@BeforeTest
	public void setUp() {
		init(url);
	}
	
	@Test
	public void newUserSignUp() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickSignIn();
		
		String email;
		
		loginpage = new LoginPage(driver);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();			
		email = "automationpractice_" + formatter.format(date) +"@gmail.com";
		System.out.print("Souri sDate: "+email);
		loginpage.typeEmailCreate(email);
	}
	
	@AfterClass
	public void endTest() {
		driver.close();
	} 

}
