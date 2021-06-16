package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start at :" + result.getStartMillis() + " Test Ended at" + result.getEndMillis()
				+ "Test Name : ==>" + result.getName()+"Status : "+result.getStatus());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Success Test Name==>" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Failed Test Name==>" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Skipped Test Name==>" + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Started==>" + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		ITestResult testResult = null;
		System.out.println("Test FINISHED==>" + context.getName()+" and Finished at "+testResult.getEndMillis());

	}

}
