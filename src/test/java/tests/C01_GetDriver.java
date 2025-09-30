package tests;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_GetDriver {

    @Test
    void getDriverTest(){

        Driver.getDriver().get("https://google.com");
        Driver.closeDriver();

        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/");
        Driver.closeDriver();

    }

}