package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import managers.ExtentTestManager;
import utils.BaseUtils;

public class DriverManager {

	private static WebDriver driver;

	public static void initDriver() throws IOException {
	
		String browser =BaseUtils.getConfigValue("browser");
		switch (browser.toLowerCase()) {
		
		case "chrome":
		driver=new ChromeDriver();
		ExtentTestManager.log.info("Browser launched successfully");
		break;
		
		case "firefox":
		driver=new FirefoxDriver();
		ExtentTestManager.log.info("firefox launched successfully");
		break;
		
		case "edge":
		driver=new EdgeDriver();
		ExtentTestManager.log.info("edge launched successfully");
		break;
			
		
		default:
		System.out.println("browser not supported");
		ExtentTestManager.log.info("Browser not found");
		break;
	}
	
		driver.manage().window().maximize();
		ExtentTestManager.log.info("Chrome Browser launched Successfully");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
		ExtentTestManager.log.info("Windows closed successfully");
	}

	public static void goToUrl(String url) {
		driver.get(url);
		ExtentTestManager.log.info("URL " + " " + url + " " + "opened");
	}

}
