package alertHandling;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class AlertHandling extends TestBase{
	String url="http://the-internet.herokuapp.com/javascript_alerts";
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	
	@Test
	public void simpleAlert() throws InterruptedException {
		// Simple Alert example		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();	
		assertEquals(true,driver.findElement(By.xpath("//p[contains(text(),'You successfuly clicked an alert')]")).isDisplayed(),"Simple Alert is not working");
	}
	@Test
	public void ConfirmPopUp() throws InterruptedException {
		// Confirm pop up example
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Alert popupAlert = driver.switchTo().alert();
		popupAlert.accept();
		assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'You clicked: Ok')]")).isDisplayed(),"Confirm pop up is not working");
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		popupAlert = driver.switchTo().alert();
		popupAlert.dismiss();
		assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'You clicked: Cancel')]")).isDisplayed(),"Confirm pop up is not working");
	}
	
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
