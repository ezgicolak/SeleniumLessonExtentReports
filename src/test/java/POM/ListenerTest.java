package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerTest extends E20_1_CreateBaseTest implements ITestListener {


    ExtentTest test;
    ExtentReports extent = E22_1_ExportReporterNG.getReportObject();
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());


    }


    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        test.log(Status.PASS,"test passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        test.fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();

        }



        try {

            String screenshotPath = getScreenshot(result.getMethod().getMethodName(),driver);
            test.addScreenCaptureFromPath(screenshotPath, "Ekran Görüntüsü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        //Screenshot ,attach to report



    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        // TestNG test süreci tamamlandığında çalışacak kodlar burada olacak
    }
}









