package actionclass;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*Actions class is based on builder design pattern which builds a composite actions with the aggregation of Selenium WebDriver, where webdriver is only used to identify the presence of web elements on web application
Action interface is only used to represent the single user interaction i.e to perform the series of action items build by Actions class.*/ 

public class RightClick {
	
	String url="https://demo.guru99.com/test/simple_context_menu.html";
	WebDriver driver;
	@BeforeClass
	public void initialization() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearUp() {
		driver.close();
	}
	//Actions is a class where as action is an interface
	@Test(description="Right Click fuinction",enabled=true)
	public void rightClick() throws InterruptedException {
		WebElement rightClickElement=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		WebElement editLink=driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
		
		Actions actions = new Actions(driver);
		actions.contextClick(rightClickElement).perform();
		
		
		
		assertEquals(editLink.isDisplayed(), true);
		Thread.sleep(2000);
	}
	
	
}
