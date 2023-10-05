import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class E19_3_POM_AbstractComponents {

    WebDriver driver;
    public E19_3_POM_AbstractComponents(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }



    public void waitForElementToAppear(WebElement findBy){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(findBy));




    }

    public void waitForElementToDissappear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));


    }





}
