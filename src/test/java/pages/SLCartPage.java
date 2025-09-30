package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

public class SLCartPage {

    private By yourCartHeader = By.cssSelector(".header_secondary_container");


    public SLCartPage assertCartHeader() {
        Assert.assertEquals(Driver.getDriver().findElement(yourCartHeader).getText(), "Your Cart");
        return this;
    }


}