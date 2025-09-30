package tests;

import org.testng.annotations.Test;
import pages.SLLoginPage;
import pages.SLProductsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C08_MethodChain {

    @Test
    void methodChainTest() {
        SLLoginPage loginPage = new SLLoginPage();
        SLProductsPage productsPage = new SLProductsPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        loginPage
                .enterUsername(ConfigReader.getProperty("sd_username"))
                .enterPassword(ConfigReader.getProperty("sd_password"))
                .clickLoginButton();

        productsPage.sortProducts(2);

        Driver.closeDriver();
    }

}