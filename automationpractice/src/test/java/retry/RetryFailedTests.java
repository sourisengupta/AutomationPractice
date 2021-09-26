package retry;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Analyzer.RetryAnalyzer;
import base.BaseTest;
import junit.framework.Assert;

public class RetryFailedTests extends BaseTest{
	
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
