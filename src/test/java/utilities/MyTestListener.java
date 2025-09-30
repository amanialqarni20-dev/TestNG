package utilities;

import com.aventstack.extentreports.Status;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalTime;

public class MyTestListener implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " started.");
        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO, "Test started at: "+ LocalTime.now());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " is SUCCESS!");
        ExtentReportManager.log(Status.INFO, "Test finished at: "+ LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " is FAILED!!!");
        ExtentReportManager.log(Status.INFO, "Test finished at: "+ LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " is SKIPPED!!!");
        ExtentReportManager.log(Status.INFO, "Test finished at: "+ LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started at: " + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished at: " + context.getEndDate());
        Driver.closeDriver();
    }

    // Automatically retries failed test scenarios one more time
    // IRetryAnalyzer method is implemented
    // This method will be automatically invoked to RETRY FAILED TEST SCENARIOS
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // NUMBER OF RETRIES

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // IAnnotationTransformer method is added
    // This automatically retries failed test scenarios using TestNG XML files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(MyTestListener.class);
    }
}