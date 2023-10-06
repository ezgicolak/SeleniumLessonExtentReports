package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTitleTest {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeTest
    public void setup() {
        // ExtentHtmlReporter sınıfı, raporunuzu bir HTML dosyasına yazmanızı sağlar.
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/GoogleTitleTestReport.html");

        // ExtentReports nesnesini oluşturun ve HTML raporunuzu ekleyin.
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Testin başlangıcında test adını tanımlayın.
        test = extent.createTest("Google Başlık Testi", "Google ana sayfasının başlığını alın.");
    }

    @Test
    public void testGoogleTitle() {
        test.log(Status.INFO, "Google Ana Sayfasını açma");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Sayfanın başlığını alın
        String pageTitle = driver.getTitle();
        test.log(Status.INFO, "Google Ana Sayfasının Başlığı: " + pageTitle);

        // Başarılı bir adım
        if (pageTitle.contains("Google")) {
            test.log(Status.PASS, "Google Ana Sayfa Başlığı doğru.");
        } else {
            test.log(Status.FAIL, "Google Ana Sayfa Başlığı hatalı.");
        }
    }

    @AfterTest
    public void tearDown() {
        // Tarayıcıyı kapat
        if (driver != null) {
            driver.quit();
        }

        // Raporu kaydet ve kapat
        extent.flush();
    }
}


