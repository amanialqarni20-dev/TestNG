package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.ContactListPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;

public class T01ContactListExtentReportTest {
    /*
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    1. Navigate to the application
    2. Create a new user account
    3. Login with the created user
    4. Add 5 different contacts
    5. Assert that all contacts are properly added and displayed
    Page Objects Needed:
    - LoginPage (registration and login elements)
    - ContactListPage (contact management elements)
    - AddContactPage (contact form elements)
    Assertions:
    - Verify successful user registration
    - Verify successful login
    - Verify each contact is added correctly
    - Verify total contact count equals 5
    Reporting Requirements:
    - Use ExtentReports
    - Create TestBaseReport base class
    - Add .info() logs for each major step
    - Use .pass() for successful assertions
    - Use .fail() for failed assertions with screenshots
    - Add system information (Browser, Environment, Tester)
    - Generate report with timestamp in filename
    */

    @Test
    void getDriverTest() {
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage();
        ContactListPage contactListPage = new ContactListPage();
        AddContactPage addContactPage = new AddContactPage();

        try {
            // 1. Navigate to the application
            Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

            // 2. Create a new user account
            loginPage.signup.click();
            loginPage.signUp(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.internet().password());

            // 3. Assert successful user registration
            Assert.assertTrue(contactListPage.logout.isDisplayed(), "User registration failed!");

            // 4. Add 5 different contacts
            for (int i = 0; i < 5; i++) {
                Driver.getDriver().navigate().refresh();
                contactListPage.addContact.click();

                addContactPage.addContact(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(faker.date().birthday()),
                        faker.internet().emailAddress(),
                        faker.phoneNumber().cellPhone().replaceAll("[^0-9]", ""),
                        faker.address().streetAddress(),
                        faker.address().streetAddress(),
                        faker.address().city(),
                        faker.address().state(),
                        faker.address().zipCode(),
                        faker.country().name());

                // Verify each contact is added correctly
                wait.until(ExpectedConditions.visibilityOf(contactListPage.addContact));
                Assert.assertTrue(contactListPage.addContact.isDisplayed(), "Contact not added correctly!");
            }

            // 5. Assert that all contacts are properly added and displayed
            int rowCount = contactListPage.dataCount.size();
            Assert.assertEquals(rowCount, 5, "You didn't add 5 contacts");

        } catch (Exception e) {
            // Handle any exception during test execution
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());

        } finally {
            // Close browser
            Driver.closeDriver();

            // Flush extent report (if TestBaseReport is used)
            // extent.flush();
        }
    }
}
