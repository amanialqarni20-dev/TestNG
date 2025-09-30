package smoke_tests;

import org.testng.annotations.Test;
import pages.CLContactListPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class T01_PositiveLogin {

    @Test
    void positiveLoginTest() {

        CLHomePage homePage = new CLHomePage();
        CLContactListPage contactListPage = new CLContactListPage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        assert contactListPage.logout.isDisplayed();
        Driver.closeDriver();

    }
}