package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class E20_2_ErrorValidations extends E20_1_CreateBaseTest {

    private WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    @Test
    public void test() throws IOException,InterruptedException {



        launchApplication().login("anshika@gmail.com", "Iamking@");

       Assert.assertEquals("Incorrect email  password.",loginPage.getErrorMassage());




    }


}
