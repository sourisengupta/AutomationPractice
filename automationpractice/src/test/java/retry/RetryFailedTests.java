package retry;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Analyzer.RetryAnalyzer;
import base.BaseTest;
import junit.framework.Assert;

public class RetryFailedTests extends BaseTest{
	public static int count=0;
	@BeforeClass
	public void setUp() {
		init("https://www.google.com");		
	}
	
	@AfterClass
	public void endTests() {
		tearDown();
	}
	
	@Test(retryAnalyzer = MyRetry.class)
	public void takeScreenshotTest() {
		System.out.println("count:"+count++);
		Assert.assertEquals(true, false);
	}
}
