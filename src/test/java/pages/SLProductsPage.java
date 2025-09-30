package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Driver;

public class SLProductsPage {

    private By sortDD = By.xpath("//select[@class='product_sort_container']");
    private By menu = By.cssSelector("#react-burger-menu-btn");
    private By addCartButtons = By.cssSelector(".btn_inventory ");
    private By cartButton = By.cssSelector(".shopping_cart_link ");
    private By addCartButtonByName = By.xpath("//div[@class='inventory_item_description' and contains(., 'Onesie')]//button");


    public SLProductsPage sortProducts(String text) {
        new Select(Driver.getDriver().findElement(sortDD)).selectByVisibleText(text);
        return this;
    }

    public SLProductsPage sortProducts(int index) {
        new Select(Driver.getDriver().findElement(sortDD)).selectByIndex(index);
        return this;
    }

    public SLProductsPage assertLogin() {
        Assert.assertTrue(Driver.getDriver().findElement(menu).isDisplayed());
        return this;
    }

    public SLProductsPage addProductByIndex(int index) {
        Driver.getDriver().findElements(addCartButtons).get(index).click();
        return this;
    }

    public SLProductsPage addAllProducts() {
        Driver.getDriver().findElements(addCartButtons).forEach(WebElement::click);//Using lambda is recommended
        return this;
    }

    public SLCartPage clickOnCart() {
        Driver.getDriver().findElement(cartButton).click();
        return new SLCartPage();
    }

    public SLProductsPage assertPriceByName(String productName, double price) {
        String priceByName = null;
        String strPrice = Driver.getDriver().findElement(By.xpath(String.format(priceByName, price))).getText();
        Assert.assertEquals(Double.parseDouble(strPrice.replaceAll("$", "")), price);
        return this;
    }
    public SLProductsPage addProductByName(String productName) {
        Driver.getDriver().findElement(addCartButtonByName).click();
        return this;
    }


}
