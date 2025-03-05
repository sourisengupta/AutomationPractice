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

public class DragAndDrop {
	
	String url="https://the-internet.herokuapp.com/drag_and_drop";
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
	
	
	@Test(description="Drag and Drop fuinction",enabled=true)
	public void dragAndDrop() throws InterruptedException {
		WebElement fromElement;
		WebElement toElement;
		
		fromElement = driver.findElement(By.xpath("//div[@id='columns']/div[@id='column-a']"));
		toElement = driver.findElement(By.xpath("//div[@id='columns']/div[@id='column-a']/following-sibling::div"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(fromElement, toElement).build().perform();
		
		
		//Building a drag and drop action
		/*Action dragAndDrop = actions.clickAndHold(fromElement)
									.moveToElement(toElement)
									.release(toElement)
									.build();
		//Performing the drag and drop action
		dragAndDrop.perform();*/
		
		Thread.sleep(2000);
		
		String FistPositionText = fromElement.getText();
		assertEquals(FistPositionText, "B");
		System.out.println("FistPositionText:"+FistPositionText);
		
		//Thread.sleep(5000);
	}
	
}
