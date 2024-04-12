package engine;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " FAILED");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " PASSED");
    }
}
