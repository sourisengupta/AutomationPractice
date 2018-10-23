package paginationHandling;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class PaginationHandling extends TestBase{
	
	String url="https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=mobile";
	WebDriverWait wait;
	@Test
	public void fileUpload() throws InterruptedException {
		WebElement element =driver.findElement(By.xpath("//span[@id='pagnNextString']")); 
		
		scrollToElement(element);
		//scrollTo300();
		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='pagn']/span"));
		if(pagination.size()>0) {
			System.out.println("Pagination exists. Size["+pagination.size()+"]");
		}
		int cntPage=0;
		for (int i=0;i<pagination.size();i++) {
			driver.findElement(By.xpath("//span[@id='pagnNextString']")).click();
			scrollToElement(element);
			//scrollTo300();
			cntPage++;
			if(cntPage==5) {
				break;
			}
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
