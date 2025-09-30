package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SDLoginPage;
import pages.SLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_PublicBys {

    @Test
    void publicBysTest() {

        SLLoginPage loginPage = new SLLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));
        Driver.getDriver().findElement(loginPage.username).sendKeys(ConfigReader.getProperty("sd_username"));
        Driver.getDriver().findElement(loginPage.password).sendKeys(ConfigReader.getProperty("sd_password"));
        Driver.getDriver().findElement(loginPage.loginButton).click();



    }

}