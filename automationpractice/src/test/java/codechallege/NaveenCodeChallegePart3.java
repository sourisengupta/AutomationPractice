package codechallege;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NaveenCodeChallegePart3 {
	WebDriver driver;
	WebDriverWait wait;
	String URL="https://www.saucedemo.com/";
	String user="standard_user";
	String pass="secret_sauce";
	@BeforeClass
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearUp() {
		driver.quit();
	}
	
	@Test
	public void getTheMaxPricedToCart() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']"));
		List<WebElement> addToCarts = driver.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']/following-sibling::button"));
		
		Map<Float, WebElement> prodDetails = new HashMap<Float, WebElement>();
		float price;
		WebElement buttonXpath;
		for(int i=0;i<prices.size();i++) {
//			System.out.println(prices.get(i).getText().replace("$", ""));
			price = Float.parseFloat(prices.get(i).getText().replace("$", ""));
			buttonXpath = addToCarts.get(i);
//			System.out.println(buttonXpath.toString());
			prodDetails.put(price, buttonXpath);
		}
		float maxKey = Collections.max(prodDetails.keySet());
		
		WebElement xpathDesired=null;
		for(Map.Entry<Float, WebElement> entry: prodDetails.entrySet()) {
			if(maxKey == entry.getKey()) {
				xpathDesired = entry.getValue();
				break;
			}
		}
		xpathDesired.click();
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='shopping_cart_badge']")));
		
		int cartNumber = Integer.parseInt(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText()) ;
		
		
		System.out.println(cartNumber);
		if(cartNumber > 0) {
			driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		}
		else {
			System.out.println("Cart is empty");
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='title']")));
		
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//span[contains(text(),'Your Cart')]"));
		assertTrue(cartItems.size()>0);
		
		
		
		
		Thread.sleep(5000);
				
	}
}
