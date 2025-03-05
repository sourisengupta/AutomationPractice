import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class Frames extends TestBase{
	
	
		
	public static String url="http://demo.guru99.com/test/guru99home/";

	@BeforeTest
	public void setUp() {
		init(url);
	}
	@AfterTest
	public void close() {
		driver.quit(); // close current browser and all associated with it
	}

	@Test
	public void handlingFrames() {
		// http://demo.guru99.com/test/guru99home/
		String title="";
		System.out.println(driver.getTitle());
		String childTitle="";
		driver.switchTo().frame("a077aa5e");		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("html/body/a")).click();
		
		for(String windowHandle : driver.getWindowHandles()) {
			if(!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				childTitle = driver.getTitle();
				System.out.println(childTitle);
			}
		}
		driver.switchTo().defaultContent(); 
		//driver.switchTo().window(arg0);		
	}
}
