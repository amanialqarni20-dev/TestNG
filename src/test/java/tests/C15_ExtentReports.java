package tests;

import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.io.IOException;
import java.time.LocalTime;

public class C15_ExtentReports {

    @BeforeMethod
    void beforeMethod(){
        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO, "Test started at: "+ LocalTime.now());
    }

    @AfterMethod
    void tearDown(ITestResult result) throws IOException {
        ExtentReportManager.log(Status.INFO, "Test finished at: "+ LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }

    @Test
    void test01() {
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

    @Test
    void test02() {
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
        assert false;//AssertionError
        Driver.closeDriver();
    }

    @Test
    void test03() {
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
        int x = 1 / 0;//ArithmeticException: / by zero
        Driver.closeDriver();
    }

    @Test
    void test04() {
        throw new SkipException("This test is skipped intentionally!");
    }

}