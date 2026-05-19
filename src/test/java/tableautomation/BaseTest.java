package tableautomation;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;

import managers.DriverManager;
import managers.ExtentManager;
import managers.ExtentTestManager;
import utils.BaseUtils;
import utils.WaitUtils;

public class BaseTest {
	@BeforeSuite
	public void initialise() throws IOException {
		ExtentManager.initReport();
	}

	@BeforeMethod
	public void preReq(Method method, Object[] testData) throws IOException {

	    // Create parent only once per method execution cycle
	    if (ExtentTestManager.parentTest == null) {
	        ExtentTestManager.createParentTest(method.getName());
	    }

	    String nodeName = "Data Set : ";

	    for (Object data : testData) {
	        nodeName += data + " | ";
	    }

	    ExtentTestManager.createNode(nodeName);

	    DriverManager.initDriver();

	    WaitUtils.initWait();

	    DriverManager.goToUrl(BaseUtils.getConfigValue("url"));
	}
//	public void preReq(Method method) throws IOException {
//		ExtentTestManager.createTest(method.getName());
//		DriverManager.initDriver();
//        WaitUtils.initWait();
//		DriverManager.goToUrl(BaseUtils.getConfigValue("url"));
//	}

	@AfterMethod
	public void packUptest(ITestResult result) throws IOException {

	    if (result.getStatus() == ITestResult.SUCCESS) {

	        ExtentTestManager.childTest.pass("Test passed");

	    } else if (result.getStatus() == ITestResult.FAILURE) {

	        ExtentTestManager.childTest.fail(
	                result.getThrowable(),
	                MediaEntityBuilder.createScreenCaptureFromPath(
	                        BaseUtils.getScreenShotPath(
	                                DriverManager.getDriver(),
	                                result.getInstance().getClass().getSimpleName()
	                                        + "."
	                                        + result.getMethod().getMethodName()))
	                        .build());

	    } else if (result.getStatus() == ITestResult.SKIP) {

	        ExtentTestManager.childTest.skip("Test Skipped");
	    }

	    DriverManager.quitDriver();

	   
	}
//	public void packUptest(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			ExtentTestManager.childTest.pass("Test passed");
//			//ExtentTestManager.log.pass("Test passed");
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			ExtentTestManager.childTest.fail(result.getThrowable(), MediaEntityBuilder
//					.createScreenCaptureFromPath(BaseUtils.getScreenShotPath(DriverManager.getDriver(),
//							result.getInstance().getClass().getSimpleName() + "." + result.getMethod().getMethodName()))
//					.build());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			ExtentTestManager.childTest.skip("Test Skipped");
//		}
//		DriverManager.quitDriver();
//
//	}

	@AfterSuite
	public void tearDown() {
		ExtentManager.flushReport();
	}

}
