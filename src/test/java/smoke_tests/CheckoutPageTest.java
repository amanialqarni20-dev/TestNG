package smoke_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class CheckoutPageTest {

    @Test
    public void checkoutPageTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.saucedemo.com");

        // تسجيل دخول
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // إضافة منتج إلى السلة
        driver.findElement(By.className("btn_inventory")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        // الذهاب لصفحة Checkout
        driver.findElement(By.id("checkout")).click();

        // تحقق من ظهور صفحة Checkout
        Assert.assertTrue(driver.findElement(By.className("checkout_info")).isDisplayed(),
                "Checkout page should load correctly");

        Driver.closeDriver();
    }
}
