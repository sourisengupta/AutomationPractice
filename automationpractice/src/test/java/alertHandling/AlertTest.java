package alertHandling;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class AlertTest {
	
	String url="http://the-internet.herokuapp.com/javascript_alerts";
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.get(url);
		
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//div[@class='example']//button[contains(.,'Click for JS Alert')]")).click();
//		
//		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
	}
	
	@Test
	public void testAlert() {
		driver.findElement(By.xpath("//div[@class='example']//button[contains(.,'Click for JS Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.xpath("//div[@class='example']//button[contains(.,'Click for JS Alert')]")).click();
		alert.dismiss();
		
	}
}
