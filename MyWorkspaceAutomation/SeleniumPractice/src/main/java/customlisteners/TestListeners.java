package customlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed Test : " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("");
		System.out.println("Failed Test :" + result.getName());
		Reporter.log("<a href=\"G:\\MyWorkspaceAutomation\\SeleniumPractice\\ScreenShot\\Sun_Sep_08_14_45_01_IST_2019.jpg\">Screensshot linked.....</a>");
		System.out.println("Capturing screenshot of fialed test case....");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped Test :" + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getTestContext().getAllTestMethods().length);

	}

	@Override
	public void onStart(ITestContext context) {
System.out.println(context.getSuite().getAllInvokedMethods());

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
