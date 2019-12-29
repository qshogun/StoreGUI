package com.qshogun.storegui.listeners;

import com.qshogun.storegui.util.AddResultForTestCase;
import com.qshogun.storegui.util.HelperMethods;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        String testCaseId = HelperMethods.getTestCaseId(result.getName());
        AddResultForTestCase.addPass(testCaseId);

    }

    public void onTestFailure(ITestResult result) {
        String testCaseId = HelperMethods.getTestCaseId(result.getName());
        AddResultForTestCase.addFail(testCaseId,
                result.getThrowable().toString());
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
