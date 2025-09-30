package smoke_tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CLContactListPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class T02_NegativeLogin {

    @Test
    void positiveLoginTest() {
        CLHomePage homePage = new CLHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(homePage.error));
        assert homePage.error.isDisplayed();
        Driver.closeDriver();
    }
}