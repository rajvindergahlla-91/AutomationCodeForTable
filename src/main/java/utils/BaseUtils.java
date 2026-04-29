package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseUtils {
	public static String getConfigValue (String key) throws IOException
	{
    Properties property = new Properties();
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/testdata/config.properties");
	property.load(file);
	
	return property.getProperty(key);
	
}
	public static String getScreenShotPath(WebDriver driver, String pageName) throws IOException
	{
		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/failedPageImages/image_" + pageName + ".png";
		FileUtils.copyFile(Source, new File(path));
		return path;
		
	}	

}
