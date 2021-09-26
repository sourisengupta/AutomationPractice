package paginationHandling;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class PaginationHandling extends TestBase{
	
	String url="https://www.google.com/search?q=hello&rlz=1C1SQJL_enUS795US795&oq=hello&aqs=chrome..69i57j46j0l2j46j0l3.837j0j4&sourceid=chrome&ie=UTF-8";
	WebDriverWait wait;
	@Test
	public void fileUpload() throws InterruptedException {
		
		
		List<WebElement> lstElement = driver.findElements(By.xpath("//a"));		
		
		for (WebElement ele : lstElement) {
			System.out.println(ele.getText());
		}
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		
//		
//		
//		WebElement element =driver.findElement(By.xpath("//span[@id='pagnNextString']")); 
//		
//		scrollToElement(element);
//		//scrollTo300();
//		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='pagn']/span"));
//		if(pagination.size()>0) {
//			System.out.println("Pagination exists. Size["+pagination.size()+"]");
//		}
//		int cntPage=0;
//		for (int i=0;i<pagination.size();i++) {
//			driver.findElement(By.xpath("//span[@id='pagnNextString']")).click();
//			scrollToElement(element);
//			//scrollTo300();
//			cntPage++;
//			if(cntPage==5) {
//				break;
//			}
//		}
		
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
