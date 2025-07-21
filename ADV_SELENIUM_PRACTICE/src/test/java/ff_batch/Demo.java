package ff_batch;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import fileutility.ExcelUtility;

public class Demo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.instagram.com/");
	Thread.sleep(2000);
	WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Log in']"));
    driver.navigate().refresh();
    loginBtn.click();
}
}
