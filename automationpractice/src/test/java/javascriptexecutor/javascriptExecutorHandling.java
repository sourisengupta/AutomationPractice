package javascriptexecutor;

import org.testng.annotations.Test;
import com.test.automationpractice.testBase.TestBase;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
/*	
 * 					Syntax
 * =====================================================
 * JavascriptExecutor js = (JavascriptExecutor) driver;
 * js.executeScript(Script,Arguments);
 * 
*/
public class javascriptExecutorHandling extends TestBase{
	public String url="http://the-internet.herokuapp.com/forgot_password";
	JavascriptExecutor js;
	

	@Test	//scroll Page
	public void scrollPage() throws InterruptedException {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.location = 'http://the-internet.herokuapp.com'");
		js.executeScript("window.scrollBy(0,500)");
		// for scrolling till the bottom of the page we can use the code like
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	@Test	//Refresh Page
	public void refreshPage() throws InterruptedException {
		js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	@Test	//Alert Generation
	public void alertGeneration() throws InterruptedException {
		js = (JavascriptExecutor)driver;
		js.executeScript("alert('Hello This is an alert by JS');");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	@Test	//Type and Clicking the WebElement
	public void TypeAndClickWebElement() throws InterruptedException {
		js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='abc@gmail.com';");
		js.executeScript("document.getElementById('form_submit').click();");
		
		String message = driver.findElement(By.xpath("//div[@id='content']")).getText();
		assertTrue(message.contains("Your e-mail's been sent!"));
				
		
	}
	@BeforeTest
	public void beforeTest() {
		init(url);
	}

	@AfterTest
	public void afterTest() {
		closeApp();
	}

}
