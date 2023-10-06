package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E19_7_POM_ConfirmPage extends E19_3_POM_AbstractComponents {


    WebDriver driver ;


    public E19_7_POM_ConfirmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".hero-primary")
    WebElement confirmMassage;

    public String getConfirmMassage(){

        return confirmMassage.getText();



    }



}
