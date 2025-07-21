package data_driven_testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import fileutility.PropertyFileUtility;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws InterruptedException, IOException {
    
		PropertyFileUtility pLib=new PropertyFileUtility();
		 
		String browser=pLib.readDataFromPropertiesFile("Browser");
		
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("CHROME"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
		else if(browser.equalsIgnoreCase("Firefox"))
			driver=new FirefoxDriver();
		else if(browser.equalsIgnoreCase("Safari"))
			driver=new SafariDriver();
		
		
		// Login to NINZA CRM
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(pLib.readDataFromPropertiesFile("Url"));
		
		driver.findElement(By.id("username")).sendKeys(pLib.readDataFromPropertiesFile("Username"));
		driver.findElement(By.id("inputPassword")).sendKeys(pLib.readDataFromPropertiesFile("Password"));
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
}
