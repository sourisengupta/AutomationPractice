package dropdownHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class DropdownHandling extends TestBase{
	String url="http://the-internet.herokuapp.com/dropdown";
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	
	@Test(priority=1)	
	public void dropdownHandling() {
		Select select = new Select(driver.findElement(By.cssSelector("#dropdown")));
		select.selectByIndex(1);
		select.selectByValue("2");
		select.selectByVisibleText("Option 1");
	}
	
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
