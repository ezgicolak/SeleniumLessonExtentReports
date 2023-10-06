package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    ExtentReports extent;

    @BeforeTest
    public void setupExtentReports() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\ezgic\\OneDrive\\Belgeler\\SeleniumLessonExtentReports\\reports\\index.html");
        
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rahul Shetty");
    }

    @Test
    public void initialDemo() {
        extent.createTest("Initial Demo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    @AfterTest
    public void tearDownExtentReports() {
        extent.flush();
    }
}

