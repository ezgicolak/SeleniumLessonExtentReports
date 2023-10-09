package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ListenerTest extends E20_1_CreateBaseTest implements ITestListener {


    ExtentTest test;
    ExtentReports extent = E22_1_ExportReporterNG.getReportObject();

  @Override
    public void onTestStart(ITestResult result) {

     test = extent.createTest(result.getMethod().getMethodName());
  }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        test.log(Status.PASS, "test passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

       test.fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
  }

  @Override
    public void onFinish(ITestContext context){
      extent.flush();
  }
}









