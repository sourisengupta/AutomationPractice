package screenShot;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import junit.framework.Assert;


@Listeners(CustomListener.class)
public class ScreenshotTest extends BaseTest{
	
	@BeforeClass
	public void setUp() {
		init("https://www.google.com");
		
	}
	
	@AfterClass
	public void endTests() {
		tearDown();
	}
	
	@Test
	public void takeScreenshotTest() {
		Assert.assertEquals(true, false);
	}
}
