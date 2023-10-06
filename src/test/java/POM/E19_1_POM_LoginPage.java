package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E19_1_POM_LoginPage extends E19_3_POM_AbstractComponents {

    WebDriver driver ;

    public E19_1_POM_LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="userEmail")
    WebElement  userEmail;

    @FindBy(id="userPassword")
    WebElement  passwordEle;

    @FindBy(id="login")
    WebElement  submit;

    @FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
    WebElement errorMassage;

    public void login(String email,String password){

        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
    }

    public void goTo(){

        driver.get("https://rahulshettyacademy.com/client");


    }

    public String getErrorMassage(){

        waitForElementToAppear(errorMassage);
        return errorMassage.getText();
    }






}
