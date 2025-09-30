package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class SLLoginPage {

    public By username = By.xpath("//input[@placeholder='Username']");
    public By password = By.xpath("//input[@placeholder='Password']");
    public By loginButton = By.id("login-button");

    public SLLoginPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public SLLoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public SLLoginPage clickLoginButton() {
        Driver.getDriver().findElement(loginButton).click();
        return this;
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }


    public SLProductsPage assertLogin() {
        return null;
    }
    }