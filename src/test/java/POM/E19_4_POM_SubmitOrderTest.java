package POM;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class E19_4_POM_SubmitOrderTest extends E20_1_CreateBaseTest {

    @Test
    public void submitOrder() throws IOException,InterruptedException {


        launchApplication().login("anshika@gmail.com","Iamking@000");
        E19_2_POM_ProductCatalog productCatalog = new E19_2_POM_ProductCatalog(driver);
        productCatalog.addProductToCart();
        productCatalog.goToCartPage();
       E19_5_POM_CartPage cartPage = new E19_5_POM_CartPage(driver);
       cartPage.goToCheckOut();
       E19_6_POM_CheckOutPage checkOutPage=new E19_6_POM_CheckOutPage(driver);
       checkOutPage.selectCounrty("India");
       checkOutPage.placeOrder();
       E19_7_POM_ConfirmPage confirmPage = new E19_7_POM_ConfirmPage(driver);
       String confirmMassage =   confirmPage.getConfirmMassage();
       Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       driver.close();

    }


    @Test()
    public void OrderHistoryTest() throws IOException,InterruptedException  {
        //"ZARA COAT 3"

     launchApplication().login("anshika@gmail.com","Iamking@000");
     E19_2_POM_ProductCatalog productCatalog = new E19_2_POM_ProductCatalog(driver);
     productCatalog.addProductToCart();
     E19_8_OrdersPage ordersPage = new E19_8_OrdersPage(driver);
     ordersPage.gotoOrderPage();
     Assert.assertTrue(ordersPage.VerifyOrderDisplay("zara coat 3"));
     










    }



}
