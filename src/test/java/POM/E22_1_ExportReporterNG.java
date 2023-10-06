package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class E22_1_ExportReporterNG {

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
