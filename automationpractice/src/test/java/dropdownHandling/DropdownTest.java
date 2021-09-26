package dropdownHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest {
	WebDriver driver;
	String url="http://the-internet.herokuapp.com/dropdown";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test
	public void testDropdown() {
		Select dropdown = new Select(driver.findElement(By.xpath("//div/child::select")));
		dropdown.selectByIndex(0);
		dropdown.selectByValue("1");
		dropdown.selectByVisibleText("Option 1");;
	}
	@AfterClass
	public void tearUp() {
		driver.close();
	}
}
