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
import com.test.automationpractice.uiActions.PDP;
import com.test.automationpractice.uiActions.PLPTShirt;
import com.test.automationpractice.uiActions.ShoppinngCartSummary;

public class TC004_OrderAnItem extends TestBase{
	
	public static final Logger log=Logger.getLogger(TC004_OrderAnItem.class.getName());
	
	HomePage homepage;
	PLPTShirt tshirtpage;
	ShoppinngCartSummary scspage;
	PDP pdp;
	
	@BeforeTest
	public void setUp() {
		init();
	}
	
	@Test
	public void OrderAnItem() throws InterruptedException {
		int prodCount;
		homepage = new HomePage(driver);
		
		homepage.clickTabTshirts();
		
		tshirtpage= new PLPTShirt(driver);
		
		prodCount = tshirtpage.getProductCount();
		System.out.println("Product Count: "+ prodCount);
		
//		tshirtpage.scrollTo1stProduct();
		
		tshirtpage.hoverAndClick1stProduct();
		
		
		pdp = new PDP(driver);
		pdp.clickAddToButton();
		pdp.clickProceedToCheckout();
		
		scspage = new ShoppinngCartSummary(driver);
		scspage.clickProceedToCheckout();
		
		
		
	}
	
	@AfterClass
	public void endTest() {
		driver.close();
	} 

}
