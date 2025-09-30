package smoke_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class ProductPageTest {

    @Test
    public void productPageTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.saucedemo.com");

        // تسجيل دخول فعلي
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // تحقق من ظهور المنتجات
        Assert.assertTrue(driver.findElement(By.className("inventory_item_name")).isDisplayed(),
                "Product should be visible on the Product Page");

        Driver.closeDriver();
    }
}
