
package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import utils.ConfigReader;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailBox = By.xpath("//input[@data-qa='login-email']");
    private By passwordBox = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private By loginError = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // Hide ads / popups
    private void hideAds() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe, .adsbygoogle, #ad_position_box, .modal, .popup, .modal-backdrop')" +
                        ".forEach(e => e.remove());"
        );
    }

    public void openSite() {
        String baseUrl = ConfigReader.get("base.uri");
        driver.get(baseUrl + "/login");
        hideAds();
    }

    public void login(String email, String password) {
        hideAds();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBox)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public boolean isLoginErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginError)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHomePageLoaded() {
        hideAds();
        return wait.until(ExpectedConditions.urlContains("automationexercise.com"));
    }

    // Step-friendly wrappers
    public void enterEmail(String email) {
        hideAds();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBox)).sendKeys(email);
    }

    public void enterPassword(String pass) {
        hideAds();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox)).sendKeys(pass);
    }

    public void clickLogin() {
        hideAds();
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public boolean isEmailFieldInvalid() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement email = driver.findElement(emailBox);
        return !(Boolean) js.executeScript("return arguments[0].checkValidity();", email);
    }

    public boolean isPasswordFieldInvalid() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pass = driver.findElement(passwordBox);
        return !(Boolean) js.executeScript("return arguments[0].checkValidity();", pass);
    }

    public String getEmailValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement email = driver.findElement(emailBox);
        return (String) js.executeScript("return arguments[0].validationMessage;", email);
    }

    public String getPasswordValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pass = driver.findElement(passwordBox);
        return (String) js.executeScript("return arguments[0].validationMessage;", pass);
    }
}
