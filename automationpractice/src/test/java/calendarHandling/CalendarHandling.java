package calendarHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class CalendarHandling extends TestBase{
	String url="https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	
	@Test(priority=1)	
	public void calendarHandling() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys("01/01/2010");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
