
package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Accept any number button, not only "1"
    private By qtyButtons = By.xpath("//button[normalize-space()!='']");
    private By checkoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    // NEW — modal close button inside cart popup
    private By continueShoppingModalBtn = By.xpath("//div[@id='cartModal']//button[contains(text(),'Continue Shopping')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) driver;
    }

    private void hideAds() {
        try {
            js().executeScript(
                    "document.querySelectorAll('iframe, .adsbygoogle, #ad_position_box')" +
                            ".forEach(e => e.style.display='none');"
            );
        } catch (Exception ignored) {}
    }

    private void waitReady() {
        try {
            wait.until(d -> js().executeScript("return document.readyState").equals("complete"));
        } catch (Exception ignored) {}
        hideAds();
    }

    // --------------------------------------------
    // ⭐ NEW: SAFELY CLOSE CART MODAL IF PRESENT
    // --------------------------------------------
    private void closeCartModalIfPresent() {
        try {
            WebElement modalBtn = driver.findElement(continueShoppingModalBtn);
            if (modalBtn.isDisplayed()) {
                modalBtn.click();
                wait.until(ExpectedConditions.invisibilityOf(modalBtn));
            }
        } catch (Exception ignored) {}
    }

    // -----------------------------
    // CHECKOUT
    // -----------------------------
    public void clickCheckout() {

        waitReady();
        hideAds();

        // ⭐ IMPORTANT FIX: close popup before clicking checkout
        closeCartModalIfPresent();

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        js().executeScript("arguments[0].click();", btn);
    }

    // -----------------------------
    // CART EMPTY VALIDATION
    // -----------------------------
    public boolean isCartNotEmpty() {
        waitReady();
        hideAds();

        List<WebElement> qtyList = driver.findElements(qtyButtons);
        return qtyList.size() > 0;
    }

    // -----------------------------
    // GET QUANTITY
    // -----------------------------
    public int getCartQuantity() {
        waitReady();
        hideAds();

        List<WebElement> qtyList = driver.findElements(qtyButtons);

        if (qtyList.isEmpty()) return 0;

        try {
            return Integer.parseInt(qtyList.get(0).getText().trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
