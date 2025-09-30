package tests;

import org.testng.annotations.Test;
import pages.SLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C11_ParallelTestWithAttributes {

    @Test(threadPoolSize = 3, invocationCount = 5, invocationTimeOut = 300000)
    void parallelTestWithAttributesTest() {
        SLLoginPage loginPage = new SLLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));
        loginPage
                .enterUsername(ConfigReader.getProperty("sd_username"))
                .enterPassword(ConfigReader.getProperty("sd_password"))
                .clickLoginButton()
                .assertLogin()
                .sortProducts(1)
                .addProductByIndex(5)
                .clickOnCart()
                .assertCartHeader();
        Driver.closeDriver();
    }


}