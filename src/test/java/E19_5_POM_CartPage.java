import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E19_5_POM_CartPage extends E19_3_POM_AbstractComponents {
    WebDriver driver;

    @FindBy ( xpath = "/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
    WebElement checkoutEle;

    @FindBy ( xpath = "/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
    WebElement checkout;



    public E19_5_POM_CartPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToCheckOut(){

        waitForElementToAppear(checkout);
        checkoutEle.click();



    }


}
