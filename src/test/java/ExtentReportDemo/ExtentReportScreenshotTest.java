package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Base64;

public class ExtentReportScreenshotTest {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void testTakingScreenshot() {
        test = extent.createTest("Ekran Görüntüsü Testi", "Ekran görüntüsü yakalama ve rapora ekleme.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.example.com");

        // Sayfa başlığını kontrol et
        String pageTitle = driver.getTitle();
        if (!pageTitle.contains("Example Domainnn")) {
            // Başarısız olduğunda ekran görüntüsü al
            takeScreenshotAndAttachToReport();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    public void takeScreenshotAndAttachToReport() {
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
}
