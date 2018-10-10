package dropdownHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class DropdownHandling extends TestBase{
	String url="";
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	
	@Test(priority=1)	
	
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
