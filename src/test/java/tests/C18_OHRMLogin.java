package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.OHRMLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C18_OHRMLogin {

    //User Story: User can log in with valid credentials
    /*
    Test Steps:
        User enters valid username
        User enters valid password
        User clicks login button
        User should see the profile dropdown in dashboard page
     */
    @Test(priority = -1)
    void positiveTest() {//Happy Path
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .enterUsername(ConfigReader.getProperty("ohrm_username"))
                .enterPassword(ConfigReader.getProperty("ohrm_password"))
                .clickLogin()
                .assertLogin();
    }

    //User Story: User should not be able to log in without entering username or password
    /*
        User leaves the username empty
        User enters valid password
        User clicks login button
        User should see username error message on login page
     */
    @Test
    void emptyUsernameTest() {//Negative Test
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .enterPassword(ConfigReader.getProperty("ohrm_password"))
                .clickLogin()
                .assertEmptyUsername();
    }

    //User Story: User should not be able to log in without entering username or password
    /*
        User enters valid username
        User leaves the password empty
        User clicks login button
        User should see password error message on login page
     */
    @Test
    void emptyPasswordTest() {//Negative Test
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .enterUsername(ConfigReader.getProperty("ohrm_username"))
                .clickLogin()
                .assertEmptyPassword();
    }

    //User Story: User should not be able to log in without entering username or password
    /*
        User leaves the username empty
        User leaves the password empty
        User clicks login button
        User should see username and password error message on login page
     */
    @Test
    void emptyPasswordAndUsernameTest() {//Negative Test
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .clickLogin()
                .assertEmptyPassword()
                .assertEmptyUsername();
    }

    //User Story: User should not be able to log in with invalid username or password
    /*
        User enters invalid username
        User enters valid password
        User clicks login button
        User should see Invalid Credentials error message on login page
     */
    @Test
    void invalidUsernameTest() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .enterUsername("xyz")
                .enterPassword(ConfigReader.getProperty("ohrm_password"))
                .clickLogin()
                .assertInvalidCredentials();
    }

    //User Story: User should not be able to log in with invalid username or password
    /*
        User enters valid username
        User enters invalid password
        User clicks login button
        User should see Invalid Credentials error message on login page
     */
    @Test
    void invalidPasswordTest() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .enterUsername(ConfigReader.getProperty("ohrm_username"))
                .enterPassword("xyz")
                .clickLogin()
                .assertInvalidCredentials();
    }

    //User Story: User should not be able to log in with invalid username or password
    /*
        User enters invalid username
        User enters invalid password
        User clicks login button
        User should see Invalid Credentials error message on login page
     */
    @Test
    void invalidCredentialsTest() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("ohrm_url"));
        loginPage
                .enterUsername("xyz")
                .enterPassword("xyz")
                .clickLogin()
                .assertInvalidCredentials();
    }

    @AfterMethod
    void tearDown() {
        Driver.closeDriver();
    }


}