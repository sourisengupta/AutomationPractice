package com.test.automationpractice.homepage;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automationpractice.testBase.TestBase;

public class deleteDeals extends TestBase{
	String url="https://www.freecrm.com";
	@BeforeTest
	public void setUp() {
		init(url);		
	}
	
	@Test
	public void deleteDeals() throws InterruptedException {
				
		driver.findElement(By.name("username")).sendKeys("souris");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		
		
		//List lists = driver.findElements(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/table[2]/tbody/tr"));
		List lists = driver.findElements(By.xpath("//*[@id='vContactsForm']/table/tbody/tr"));
		System.out.println("deals: "+lists.size());
		while(lists.size()>3) {
		//for(int i=0;i<dealsLists.size();i++) {
			driver.findElement(By.xpath("//i[@title='Delete']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		System.out.println("All the deals are deleted");
	}
	
	@AfterClass
	public void endTest() {
		closeApp();
	}
	
}
