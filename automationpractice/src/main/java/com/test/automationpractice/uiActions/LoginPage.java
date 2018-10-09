package com.test.automationpractice.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automationpractice.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class LoginPage {
	public static final Logger log=Logger.getLogger(LoginPage.class.getName());
	
	//WebDriver driver;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitBtn;	
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticatinonFailedMessage;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailCreate;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createAccountBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String user, String pass) {
		try {
			log.info("==============Starting loginToApplication===========");
			log.info("Typed in username and object is "+username.toString());
			username.sendKeys(user);
			log.info("Typed in username and object is "+username.toString());
			password.sendKeys(pass);
			submitBtn.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception0000000000000");
			e.printStackTrace();
		}		
	}
	public void typeEmailCreate(String email) {
		emailCreate.sendKeys(email);
	}
	public void clickCreateAccountBtn() {
		createAccountBtn.click();
	}
	public String getInvalidLoginText() {
		return authenticatinonFailedMessage.getText();
	}
}
