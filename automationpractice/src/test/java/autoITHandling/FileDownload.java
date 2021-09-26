package autoITHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class FileDownload extends TestBase{
	String url="http://the-internet.herokuapp.com/javascript_alerts";
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	@AfterClass
	public void endTest() {
		closeApp();
	}

}
