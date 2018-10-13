package alertHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	
	@Test(priority=1)	// Simple Alert example		
	public void simpleAlert() throws InterruptedException {		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();	
		assertEquals(true,driver.findElement(By.xpath("//p[contains(text(),'You successfuly clicked an alert')]")).isDisplayed(),"Simple Alert is not working");
	}
	@Test(priority=2)	// Confirm pop up example
	public void ConfirmPopUp() throws InterruptedException {		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Alert popupAlert = driver.switchTo().alert();
		popupAlert.accept();
		assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'You clicked: Ok')]")).isDisplayed(),"Confirm pop up is not working");		
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		popupAlert = driver.switchTo().alert();
		popupAlert.dismiss();
		assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'You clicked: Cancel')]")).isDisplayed(),"Confirm pop up is not working");
	}
	@Test(priority=3)	// Prompt pop up example
	public void PromptPopUp() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Souri Sengupta");
		promptAlert.accept();
		String popupMessage = driver.findElement(By.xpath("//h4/following-sibling::p")).getText();
		assertTrue(popupMessage.contains("Souri Sengupta"));
	}
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
