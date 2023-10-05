import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class E20_1_CreateBaseTest {

    public WebDriver driver;


    public E19_1_POM_LoginPage loginPage;

    public WebDriver initializerDriver() throws IOException {

        //properties class

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\GlobalData.properties");
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

    @BeforeMethod
    public E19_1_POM_LoginPage launchApplication() throws IOException {

        driver = initializerDriver();
        loginPage = new E19_1_POM_LoginPage(driver);
        loginPage.goTo();
        return loginPage;


    }

     @AfterMethod
     public void tearDown()  {
        driver.close();

     }

}


