package calendarHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
	public void calendarHandlingJS() throws InterruptedException {
		driver.navigate().to("https://www.spicejet.com/");
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		String date1 = "30-07-2019";
		String date2 = "25-12-2019";
		WebElement datePicker1 = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1"));
		WebElement datePicker2 = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',"+ date1 +")", datePicker1);		
		js.executeScript("arguments[0].setAttribute('value',"+ date2 +")", datePicker2);
		Thread.sleep(3000);
	}
	
	@Test(priority=2)  //,enabled=false	
	public void calendarHandling() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys("01/01/2010");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys(Keys.TAB);
		
	}
	
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
