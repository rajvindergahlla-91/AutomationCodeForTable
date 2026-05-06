package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.UiActions;
import utils.WaitUtils;

public class TestTablePage {

	private By javaOp = By.xpath("//legend[text()='Language']//following::label[text()=' Java']");
	private By javaListOptions = By.xpath("//table//tr[not(contains(@style, 'display: none'))]/td[3]");

	private By intermediateOption = By.xpath("//legend[text()='Level']/following::label[text()=' Intermediate']");
	private By advancedOption = By.xpath("//legend[text()='Level']/following::label[text()=' Advanced']");
	private By beginnerListOptions = By.xpath("//table//tr[not(contains(@style, 'display: none'))]/td[4]");
	
	private By dropDown = By.xpath("//legend[text()='Min enrollments']/following::div[@id='enrollDropdown']");
	private By enrollOps = By.xpath("//table//tr[not(contains(@style, 'display: none'))]/td[5]");
	private By anyOptions = By.xpath("//ul[@class='dropdown-menu']//li[text()='10,000+']");
	
	private By pythonOp = By.xpath("//legend[text()='Language']//following-sibling::label[3]");
	//private By anyOption = By.xpath("//div[@class='dropdown-button']//following-sibling::ul//li[3]");
	private By pythonTableEle = By.xpath("//table//tr[not(contains(@style, 'display:none'))]/td[3]");
	private By beginnerTableEle = By.xpath("//table//tr[not(contains(@style, 'display:none'))]/td[4]");
	private By enrollTableEle = By.xpath("//table//tr[not(contains(@style, 'display:none'))]/td[5]");
	
	private By beginner = By.xpath("//legend[text()='Level']/following-sibling::label[1]");
	private By noData = By.xpath("//div[@id='noData']");
	
	private By resetButton = By.xpath("//button[text()='Reset']");
	private By anyCheckbox = By.xpath("//legend[text()='Language']/following-sibling::label[' Any']/input[@checked]");
	private By allLevelCheckBox = By.xpath("//legend[text()='Level']/following-sibling::label/input[@checked]");
	private By enrollAny = By.xpath("//div[@class='dropdown-button']/span");
	private By rows = By.xpath("//table/tbody/tr");


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
	
	public void clickMinEnrollDropDown()
	{
		UiActions.click(dropDown, "Select dropdown");
	}
	
	public void clickOnEnrollRange()
	{
		UiActions.click(anyOptions, "10000+ selected");
	}
	
	public List<WebElement> getEnrollRangeList()
	{
		return UiActions.getElements(enrollOps,"enrollments range");
	}
	
	public void selectPythonLanguage()
	{
		UiActions.click(pythonOp, "Python language selected");
	}
	public String getPythonElementText()
	{
		return UiActions.getText(pythonTableEle, "Python Element");
	}
	public String getBeginnerElememtText()
	{
		return UiActions.getText(beginnerTableEle, "Beginner Element");
	}
	public String getEnrollElementText()
	{
		return UiActions.getText(enrollTableEle, "Enrollment Text");
	}
	public void clickBeginnerOption()
	{
		UiActions.click(beginner, " Beginner option clicked");
	}
	public String getNoMatchText()
	{
		return UiActions.getText(noData, "no matching text");
	}
	public String getResetText()
	{
		return UiActions.getText(resetButton,"Reset button becomes visible");
	}
	public void clickReset()
	{
		UiActions.click(resetButton,"Reset button is clicked");
	}
	public WebElement checkLanguageOptionAny()
	{
		return WaitUtils.visibilityOfElementLocated(anyCheckbox);
	}
	public WebElement checkAllLevelOptions()
	{
		return WaitUtils.visibilityOfElementLocated(allLevelCheckBox);
	}
	public String checkAnyFieldUnderEnrollments()
	{
		return UiActions.getText(enrollAny,"Any Text in enrollment");
	}
	public boolean checkInvisibilityOfReset()
	{
		return WaitUtils.invisibilityOfElement(resetButton);
	}
	public List<WebElement> checkVisibilityOfRows()
	{
		return WaitUtils.visibilityOfElements(rows);
	}
	
	
	
	
	
	
	
	
}