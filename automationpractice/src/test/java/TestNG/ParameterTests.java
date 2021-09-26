package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseTest;
import junit.framework.Assert;

public class ParameterTests extends BaseTest{
		
		/*parameters will be passed from testng.xml file using <parameter tag>
		in the test we will receive it by @Parameters annotation*/
		
		@BeforeClass
		public void setUp() {
			init("https://www.gmail.com");
			
		}
		
		@AfterClass
		public void endTests() {
			tearDown();
		}
		
		@Test
		@Parameters({"user","password"})
		public void takeScreenshotTest(String user, String password) {
			
			
			System.out.println(user);
			System.out.println(password);
			Assert.assertEquals(true, false);
		}
}
