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
      
     test = extent.createTest(result.getMethod().getMethodName());}

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        test.log(Status.PASS, "test passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

        test = extent.createTest("Ekran Görüntüsü Testi", "Ekran görüntüsü yakalama ve rapora ekleme.");

        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                // Ekran görüntüsü al
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

                // Ekran görüntüsünü rapora ekleyin
                test.log(Status.FAIL, "Test başarısız. Ekran görüntüsü:",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                Base64.getEncoder().encodeToString(screenshotBytes)).build());

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        //Screenshot ,attach to report



    }
}









