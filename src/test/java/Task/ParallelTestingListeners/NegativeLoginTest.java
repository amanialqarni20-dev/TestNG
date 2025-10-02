package Task.ParallelTestingListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class NegativeLoginTest {

    @Test(timeOut = 30000)
    public void invalidLoginTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("submit")).click();

        String error = driver.findElement(By.id("error")).getText();
        Assert.assertTrue(error.contains("Your username is invalid!"),
                " Negative login should show error message");

        System.out.println("Negative Login ran on Thread: " + Thread.currentThread().getId());
        Driver.closeDriver();
    }
}
