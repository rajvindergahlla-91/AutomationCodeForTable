package tableautomation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestTablePage;
@Test
public class TableTest extends BaseTest {
	
	public void testCase1Test()
	{
		TestTablePage tp = new TestTablePage();
		tp.selectLanguageJava();
		List<WebElement> javaCourse  =tp.getVisibleJavaCourses();
		for (WebElement course : javaCourse) {
	        Assert.assertTrue(course.getText().contains("Java"));
	}
		System.out.println("All the java courses are visible");
}
	@Test
	public void testCase2Test()
	{
		TestTablePage tp = new TestTablePage();
		tp.uncheckIndermediate();
		tp.uncheckAdvanced();
		List<WebElement> BeginnersCourse=tp.getVisibleBeginnersCourses();
		for(WebElement course:BeginnersCourse)
		{
			Assert.assertTrue(course.getText().contains("Beginner"));
		}
		System.out.println("Only Beginners courses are displayed");
	}
	@Test
	public void testCase3Test()
	{
		TestTablePage tp = new TestTablePage();
		tp.clickMinEnrollDropDown();
		tp.clickOnEnrollRange();
		List<WebElement> enrollList=tp.getEnrollRangeList();
		for(WebElement ele : enrollList)
		{
			String entry =ele.getText();
			Integer value=Integer.valueOf(entry);
			Assert.assertTrue(value>=10000);
		}
		System.out.println("enrollments greater than 10000 exists");
	}
	@Test
	public void testCase4()
	{
		TestTablePage tp = new TestTablePage();
		tp.selectPythonLanguage();
		tp.uncheckIndermediate();
		tp.uncheckAdvanced();
		tp.clickMinEnrollDropDown();
		tp.clickOnEnrollRange();
		String pythonEle=tp.getPythonElementText();
		Assert.assertEquals(pythonEle, "Python");
		String beginnerEle=tp.getBeginnerElememtText();
		Assert.assertEquals(beginnerEle,"Beginner");
		String enrollEle=tp.getEnrollElementText();
		Integer enrollValue= Integer.valueOf(enrollEle);
		Assert.assertTrue(enrollValue>=10000);
		System.out.println("only Python Beginner courses with ≥ 10,000 enrollments are visible");
		
	}
	@Test
	public void testCase5()
	{
		TestTablePage tp = new TestTablePage();
		tp.selectPythonLanguage();
		tp.clickBeginnerOption();
		String message=tp.getNoMatchText();
		Assert.assertTrue(message.contains("No matching courses."));
		System.out.println("No matching courses is displayed");
	}
	@Test
	public void testCase6()
	{
		TestTablePage tp = new TestTablePage();
		tp.selectLanguageJava();
		String resetHeading =tp.getResetText();
		Assert.assertEquals(resetHeading, "Reset");
		System.out.println("Reset button is visible");
		tp.clickReset();
		WebElement checkBox =tp.checkLanguageOptionAny();
		boolean selected = checkBox.isSelected();
		Assert.assertTrue(selected);
		System.out.println("'Any' checkbox under Language is selected");
		WebElement allCheckBox =tp.checkAllLevelOptions();
		boolean Tr = allCheckBox.isSelected();
        Assert.assertTrue(Tr);
		System.out.println("All the checkbox under level are selected");
		String anyText=tp.checkAnyFieldUnderEnrollments();
		Assert.assertEquals(anyText, "Any");
		System.out.println("'Any' field is visible under enrollment");
		boolean truee=tp.checkInvisibilityOfReset();
		Assert.assertTrue(truee);
		System.out.println("reset button is hidden");
		List<WebElement> rowsEle =tp.checkVisibilityOfRows();
		boolean yes = rowsEle.stream().allMatch(WebElement::isDisplayed);
        Assert.assertTrue(yes);
		System.out.println("all rows are visible in table");
	}
}