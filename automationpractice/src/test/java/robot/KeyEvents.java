package robot;

import java.awt.AWTException;
import java.awt.Robot;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class KeyEvents extends TestBase{
	
	public static String url="http://spreadsheetpage.com/index.php/file/C35/P10/";

	@BeforeTest
	public void setUp() {
		init(url);
	}
	@AfterTest
	public void close() {
		driver.quit(); // close current browser and all associated with it
	}

	@Test
	public void handlingKeyEvents() throws AWTException {
		Robot robot = new Robot();
		
		//robot.keyPress(KeyEvents);
	}
}
