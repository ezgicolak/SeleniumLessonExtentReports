package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class E22_1_ExportReporterNG {
    private WebDriver driver;

    public static ExtentReports getReportObject(){

        String path = System.getProperty("C:\\Users\\ezgic\\OneDrive\\Belgeler\\SeleniumLessonExtentReports\\reports\\index.html");
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);

        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rahul Shetty");
        extent.createTest(path);
        return extent;


    }


    }

