import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E19_6_POM_CheckOutPage extends E19_3_POM_AbstractComponents {
 WebDriver driver ;


    public E19_6_POM_CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")
    WebElement country;

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
    WebElement placeOrder;

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[1]/span")
    WebElement selectCounrty;

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[1]/span")
    WebElement results;



    public void selectCounrty(String countryName){

        Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear((WebElement) results);
        selectCounrty.click();
    }

    public void placeOrder(){
        placeOrder.click();


    }








}
