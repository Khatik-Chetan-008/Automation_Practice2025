package utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import main.BaseClass;

public class ScreenshotListener extends BaseClass implements ITestListener{
	
    ExtentReports extent = ExtentManager.getInstance();

    
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
        ExtentTestManager.setTest(extent.createTest(result.getMethod().getMethodName()));
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
        extent.flush(); // Write everything to report
	}

}
