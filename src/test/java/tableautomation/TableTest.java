package tableautomation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestTablePage;
@Test
public class TableTest extends BaseTest {
	
	public void TestCase1Test()
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
	public void TestCase2Test()
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
	public void TestCase3Test()
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
}