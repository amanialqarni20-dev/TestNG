package smoke_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class HomePageTest {

    @Test
    public void homePageLoadTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.saucedemo.com"); // فتح الموقع فعليًا

        // تحقق من ظهور صفحة تسجيل الدخول
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"), "Home page should load correctly");

        Driver.closeDriver(); // يغلق المتصفح بعد الاختبار
    }
}
