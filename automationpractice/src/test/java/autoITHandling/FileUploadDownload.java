package autoITHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class FileUploadDownload extends TestBase{
	String url="http://the-internet.herokuapp.com";
	WebDriverWait wait;
	@Test
	public void fileUpload() throws InterruptedException {
		boolean fileUploaded=false;
		driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
		driver.findElement(By.cssSelector("#file-upload")).click();
		
		ProcessBuilder ps = new ProcessBuilder("D:\\Workspace\\automationpractice\\src\\test\\java\\FileUpload.exe");
		try {
			Thread.sleep(2000);
			ps.start();
			
			//System.out.println(driver.findElement(By.xpath("//input[@id='file-upload']//following-sibling::br")).getText());
			//wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.cssSelector("#file-upload")), ""));
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("#file-submit")).click();
			Thread.sleep(2000);
			fileUploaded = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).isDisplayed();
			assertEquals(fileUploaded, true,"File is not uploaded");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeTest
	public void setUp() {
		init(url);
		
	}
	@AfterClass
	public void endTest() {
		closeApp();
	}

}
