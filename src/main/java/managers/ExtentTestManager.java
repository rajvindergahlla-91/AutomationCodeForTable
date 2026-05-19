package managers;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	public static ExtentTest parentTest;
    public static ExtentTest childTest;

    public static void createParentTest(String methodName) {

        parentTest = ExtentManager.extent.createTest(methodName);
    }

    public static void createNode(String nodeName) {

        childTest = parentTest.createNode(nodeName);
    }
}

//	public static ExtentTest log;
//	public static void createTest(String methodName)
//	{
//		log= ExtentManager.extent.createTest(methodName);
//	}
//}
