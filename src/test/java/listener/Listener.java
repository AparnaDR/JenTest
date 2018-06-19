package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	public void onFinish(ITestContext result) {
		System.out.println("the name of the FINISHED TC is " + result.getName());
		
	}

	public void onStart(ITestContext result) {
		System.out.println("STARTING the TC :::::" + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	//	System.out.println("Test Failed But WithinSuccessPercentage" + result.SUCCESS_PERCENTAGE_FAILURE);
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("the name of the FAILED TC is " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("the name of the SKIPPED TC is " + result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("ON TEST START " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TEST SUCCESS " + result.getStatus());
		
	}

}
