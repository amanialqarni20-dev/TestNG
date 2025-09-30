package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SDLoginPage;
import pages.SDProductsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SauceDemo {
    /*
        Navigate to https://www.saucedemo.com/
        Enter username as standard_user
        Enter password as secret_sauce
        Click on login button
        Choose price low to high
        Verify item prices are sorted from low to high with hard Assert
     */

    @Test
    void C05_SauceDemoTest() {

        SDLoginPage loginPage = new SDLoginPage();
        SDProductsPage productsPage = new SDProductsPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        loginPage.login(ConfigReader.getProperty("sd_username"), ConfigReader.getProperty("sd_password"));

        //productsPage.sortProducts("Price (low to high)");
        productsPage.sortProducts(2);

        Assert.assertEquals(productsPage.getPriceList().getFirst(), 7.99);
        Assert.assertEquals(productsPage.getPriceList().getLast(), 49.99);

        Driver.closeDriver();
    }

}