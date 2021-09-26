package barcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarcodeAutomation {
	
//String url="https://barcode.tec-it.com/en";
	String url="https://www.101computing.net/barcode-generator-using-python/";
	
	WebDriver driver;
	String baseURL;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		String curURL = driver.getCurrentUrl();
		String[] parts;
		parts = curURL.split("/");
		baseURL = parts[0] + parts[1] + parts[2];
		System.out.println(baseURL);
		driver.manage().window().maximize();
	}
	
	@Test
	public void barcodeTest() throws NotFoundException, IOException {
//		String barcodeURL = driver.findElement(By.xpath("//div[@class='barcode']/img")).getAttribute("src");
		String barcodeURL = driver.findElement(By.xpath("//div[@class='post-entry']/p/img")).getAttribute("src");
		barcodeURL = baseURL + barcodeURL;
	System.out.println("barcodeURL: "+barcodeURL);
		
//		String barcodeURL = "https://www.101computing.net/wp/wp-content/uploads/barcode.png";
		URL url = new URL(barcodeURL);
		BufferedImage bufferredImage = ImageIO.read(url);
		
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferredImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		
		System.out.println(result.getText());
		
	}
}
