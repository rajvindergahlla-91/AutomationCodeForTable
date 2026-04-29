package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.UiActions;

public class TestTablePage {

	private By javaOp = By.xpath("//legend[text()='Language']//following::label[text()=' Java']");
	private By javaListOptions = By.xpath("//table//tr[not(contains(@style, 'display: none'))]/td[3]");

	private By intermediateOption = By.xpath("//legend[text()='Level']/following::label[text()=' Intermediate']");
	private By advancedOption = By.xpath("//legend[text()='Level']/following::label[text()=' Advanced']");
	private By beginnerListOptions = By.xpath("//table//tr[not(contains(@style, 'display: none'))]/td[4]");

	public void selectLanguageJava() {
		UiActions.click(javaOp, "Java option selected");
	}

	public List<WebElement> getVisibleJavaCourses() {
		return UiActions.getElements(javaListOptions, "The Desired list opened");

	}

	public void uncheckIndermediate() {
		UiActions.click(intermediateOption, "Intermediate option is unchecked");

	}

	public void uncheckAdvanced() {
		UiActions.click(advancedOption, "Advanced option is unchecked");
	}
	public List<WebElement> getVisibleBeginnersCourses()
	{
		 return UiActions.getElements(beginnerListOptions, "Beginners list");
	}
}