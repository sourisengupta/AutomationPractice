package codechallege;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class BrokenLinks{

	 
	public static void main(String[] args) {
		final String url="https://bstackdemo.com/";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		List<WebElement> listElements = driver.findElements(By.tagName("a"));
		
		for(WebElement element : listElements) {
			String link = element.getAttribute("href");
			System.out.println(link);
			try {
				verifyURL(link);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public static void verifyURL(String link) throws IOException {
		RestAssured.given()
		.when()
		.then();
	}
	public static void verifyURLL(String link) throws IOException {
		try {
			URL url_link = new URL(link);
		
			HttpURLConnection httpURLConnection = (HttpURLConnection) url_link.openConnection();
			httpURLConnection.connect();
			int respCode = httpURLConnection.getResponseCode();
			
			if(respCode == 200) {
				System.out.println(link + " - " + httpURLConnection.getResponseMessage());
			}
			else {
				System.out.println(link + " - " + httpURLConnection.getResponseMessage()+ " - "+"is a broken link");
			}	
		}
		catch(Exception e) {
			System.out.println(link + " - "+"is a broken link...");
		}
	}
}