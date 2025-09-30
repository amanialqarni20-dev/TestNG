package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class PositiveLoginTest {

    @Test(timeOut = 30000)
    public void validLoginTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("logged-in-successfully"),
                " Positive login should navigate to success page");

        System.out.println("Positive Login ran on Thread: " + Thread.currentThread().getId());
        Driver.closeDriver();
    }
}
