package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import managers.ExtentTestManager;

public class UiActions {
	public static String getText(By locator, String nameOfTheElement) {
		String uiText= WaitUtils.visibilityOfElementLocated(locator).getText();
		ExtentTestManager.log.info("UI text " + nameOfTheElement + "Text :"+ uiText);
		return uiText;
	}

	public static void click(By locator, String text) {
		WaitUtils.elementToBeClickable(locator).click();
		ExtentTestManager.log.info("click on " + text);
	}
	
	  public static List<WebElement> getElements(By locator, String nameOfTheElement)
	  {
		  List<WebElement> list1 = WaitUtils.visibilityOfElements(locator); 
		  for(WebElement list : list1) {
			  String listText = list.getText();
	  
	  ExtentTestManager.log.info("UI text " + nameOfTheElement + "Text :" +
	  listText); } return list1;
	  
	  }
	 
}

