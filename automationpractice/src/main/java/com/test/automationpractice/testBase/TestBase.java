package com.test.automationpractice.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	
	String currentBrowser="Chrome";
	String url="http://automationpractice.com";
	
	public WebDriver driver;
	
	public void init(String url) {
		selectBrowser(currentBrowser);
		getURL(url);
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	public void closeApp() {
		driver.close();
	}
	
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			log.info("Creating object of "+browser);
			driver= new ChromeDriver();			
		}
	}
	
	public void getURL(String url) {
		log.info("Navigating to "+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void scrollToElement(WebElement xpath) {
		WebElement element = driver.findElement(By.xpath(""));
		((JavascriptExecutor)driver).executeScript("aguements[0].scrollIntoView(true);", element);
	}
	
}
