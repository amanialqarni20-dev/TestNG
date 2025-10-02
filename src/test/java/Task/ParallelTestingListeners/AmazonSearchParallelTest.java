package Task.ParallelTestingListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class AmazonSearchParallelTest {

    @DataProvider(name = "searchData", parallel = true)
    public Object[][] getSearchData() {
        return new Object[][]{
                {"Kafka"},
                {"Elif Shafak"},
                {"Dostoevsky"},
                {"George Orwell"},
                {"Milan Kundera"}
        };
    }

    @Test(dataProvider = "searchData")
    public void amazonSearchTest(String keyword) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com");


        List<WebElement> continueBtn = driver.findElements(
                By.xpath("//button[contains(text(),'Continue shopping')]")
        );
        if (!continueBtn.isEmpty()) {
            continueBtn.get(0).click();
            System.out.println(" Closed popup: Continue Shopping");
        }


        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchBox.submit();

        System.out.println(" Wrote in search: " + keyword +
                " | Thread: " + Thread.currentThread().getId());

        Driver.closeDriver();
    }
}
