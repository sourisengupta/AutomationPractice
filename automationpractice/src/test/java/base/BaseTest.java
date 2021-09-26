package base;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public static WebDriver driver;
	
	public void init(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void tearDown() {
		driver.quit();
	}
	public void failedTestScreenshot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File("C:\\Users\\souri\\git\\AutomationPractice\\automationpractice\\test-output\\Screenshot\\failed.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
