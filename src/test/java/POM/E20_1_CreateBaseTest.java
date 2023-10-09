package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

public class E20_1_CreateBaseTest {

    public WebDriver driver;


    public E19_1_POM_LoginPage loginPage;

    public WebDriver initializerDriver() throws IOException {

        //properties class

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\POM\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");


        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();


        } else if (browserName.equalsIgnoreCase("firefox")) {
            //Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {

            System.setProperty("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;


    }

    @BeforeMethod(alwaysRun = true)
    public E19_1_POM_LoginPage launchApplication() throws IOException {

        driver = initializerDriver();
        loginPage = new E19_1_POM_LoginPage(driver);
        loginPage.goTo();
        return loginPage;


    }


    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }



    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName +".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName +".png";

    }

    }






