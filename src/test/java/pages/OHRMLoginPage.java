package pages;

import org.openqa.selenium.By;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class OHRMLoginPage extends OHRMDashboardPage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorForUsername = By.xpath("//div[@class='oxd-form-row' and contains(., 'Username')]//span");
    private By errorForPassword = By.xpath("//div[@class='oxd-form-row' and contains(., 'Password')]//span");
    private By invalidCredentialsError = By.xpath("//p[.='Invalid credentials']");


    public OHRMLoginPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }


    public OHRMLoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }


    public OHRMLoginPage clickLogin() {
        Driver.getDriver().findElement(loginButton).click();
        return this; // يرجع نفس الكلاس اللي يحتوي على login + dashboard asserts
    }

    // التحقق من أن رسالة "اسم المستخدم فارغ" ظهرت
    public OHRMLoginPage assertEmptyUsername() {
        assertTrue(Driver.getDriver().findElement(errorForUsername).isDisplayed(),
                "Expected empty username error message not displayed!");
        return this;
    }

    // التحقق من أن رسالة "كلمة المرور فارغة" ظهرت
    public OHRMLoginPage assertEmptyPassword() {
        assertTrue(Driver.getDriver().findElement(errorForPassword).isDisplayed(),
                "Expected empty password error message not displayed!");
        return this;
    }

    // التحقق من أن رسالة "بيانات الدخول غير صحيحة" ظهرت
    public OHRMLoginPage assertInvalidCredentials() {
        assertTrue(Driver.getDriver().findElement(invalidCredentialsError).isDisplayed(),
                "Expected invalid credentials error message not displayed!");
        return this;
    }
}
