import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class E19_8_OrdersPage extends E19_3_POM_AbstractComponents {
    @FindBy (xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[3]/button")
    WebElement orders;

    @FindBy (css = "tr td:nth-child(3)")
    private List<WebElement> productNames;





    public E19_8_OrdersPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void gotoOrderPage() {
        waitForElementToAppear(orders);
        orders.click();

    }

    public Boolean VerifyOrderDisplay(String productName){
        Boolean match = productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    }
}
