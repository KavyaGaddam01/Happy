package configbaseclass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.mysql.jdbc.Driver;

import fileutility.ExcelUtility;
import fileutility.PropertyFileUtility;
import javautility.JavaUtility;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import webdriverutility.WebDriverUtility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	Connection conn;
	@BeforeSuite
	public String beforeSuite(String SQLQuery,int colIndex) throws SQLException {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Connect to the database
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ninza_crm","root","root");
		
		//Create SQL Statement
	   Statement stat = conn.createStatement();
	   
	   //Execute Query
	   ResultSet result = stat.executeQuery(SQLQuery);
	   
	   System.out.println("Establish the database connection");
	   
	   return result.getString(colIndex);

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("precondition");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		String browser = pLib.readDataFromPropertiesFile("Browser");
		if (browser.equalsIgnoreCase("CHROME"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		sdriver=driver;
		System.out.println("Launch the browser");
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		String url = pLib.readDataFromPropertiesFile("Url");
		String username = pLib.readDataFromPropertiesFile("Username");
		String password = pLib.readDataFromPropertiesFile("Password");
	     LoginPage lp = new LoginPage(driver);
		lp.Login(url, username, password);
		System.out.println("Login");
	}

	@AfterMethod
	public void afterMethod() {
        HomePage hp = new HomePage(driver);
		hp.logout();
		System.out.println("Logout");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("Close the browser");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Post condition");
	}

	@AfterSuite
	public void afterSuite() throws SQLException {
		conn.close();
		System.out.println("Close database connection");
	}

}
