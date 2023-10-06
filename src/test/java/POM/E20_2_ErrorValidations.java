package POM;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

public class E20_2_ErrorValidations extends E20_1_CreateBaseTest {

    @Test
    public void test() throws IOException,InterruptedException {


        launchApplication().login("anshika@gmail.com", "Iamking@");
        Assert.assertEquals("Incorrect email  password.",loginPage.getErrorMassage());


    }


}
