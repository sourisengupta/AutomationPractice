import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class BrowserButtons extends TestBase{
	
	public static String url="https://www.selenium.dev/";
	
	@BeforeTest
	public void setUp() {
		init(url);
	}
	@AfterTest
	public void close() {
		driver.close();
	}
	
	@Test
	public void goForwardAndBackward() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='main_navbar']/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();;
		
	}
}
