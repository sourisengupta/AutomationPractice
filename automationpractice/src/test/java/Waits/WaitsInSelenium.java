package Waits;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WaitsInSelenium {
	
	WebDriver driver;
	String url="http://the-internet.herokuapp.com/dropdown";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void fluentWait() {
		Wait wait = new FluentWait<WebDriver>(driver)
		.withTimeout(50, TimeUnit.SECONDS)
		.pollingEvery(3, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	
	@Test
	public void explicitWait() {
		driver.get(url);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	}
	
	@Test
	public void implicitWait() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearUp() {
		driver.close();
	}
}
