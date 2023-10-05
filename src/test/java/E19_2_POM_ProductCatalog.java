import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E19_2_POM_ProductCatalog extends E19_3_POM_AbstractComponents{

    WebDriver driver ;

    public E19_2_POM_ProductCatalog(WebDriver driver){
       super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css =".ng-animating")
    WebElement spinner;
    By addToCart = By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/button[2]");

    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    WebElement toast;

    @FindBy(xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")
    WebElement cartHeader;

    public void addProductToCart(){

        driver.findElement(addToCart).click();
        waitForElementToAppear(toast);
        waitForElementToDissappear(spinner);



    }

    public void goToCartPage(){
        cartHeader.click();



    }




}
