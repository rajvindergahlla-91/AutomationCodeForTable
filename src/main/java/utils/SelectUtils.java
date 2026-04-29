package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtils {
private static Select dd;

	
	public static void selectByIndex(WebElement ele, int index) {
		dd = new Select(ele);
		dd.selectByIndex(index);
	}

	public static void selectByValue(WebElement ele, String value) {
		dd = new Select(ele);
		dd.selectByValue(value);
	}

	public static void selectByContainsVisibleText(WebElement ele, String text) {
		dd = new Select(ele);
		dd.selectByContainsVisibleText(text);
	}

	public static void selectByVisibleText(WebElement ele, String text) {
		dd = new Select(ele);
		dd.selectByVisibleText(text);

	}

}
