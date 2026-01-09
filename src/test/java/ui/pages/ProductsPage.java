package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addFirstProduct = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    private By productItems = By.cssSelector(".product-image-wrapper");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) driver;
    }

    // --------------------------
    // UNIVERSAL AD BLOCKER – VERY IMPORTANT
    // --------------------------
    private void hideAds() {
        try {
            js().executeScript(
                    "document.querySelectorAll('iframe, .adsbygoogle, #ad_position_box')" +
                            ".forEach(e => e.remove());"
            );
        } catch (Exception ignored) {}
    }

    private void safeWaitForPage() {
        try {
            wait.until(web -> ((JavascriptExecutor) web)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception ignored) {}
        hideAds();
    }

    // --------------------------
    // NAVIGATION
    // --------------------------
    public void openProductsPage() {
        driver.get("https://automationexercise.com/products");

        safeWaitForPage();

        // Ensure scroll top
        js().executeScript("window.scrollTo(0,0)");
        hideAds();
    }

    // --------------------------
    // PRODUCT OPERATIONS
    // --------------------------
    public void addFirstProductToCart() {
        hideAds();

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addFirstProduct));

        js().executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        js().executeScript("arguments[0].click();", btn);

        hideAds();
    }

    public void clickContinueShopping() {
        hideAds();
        WebElement cont = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        cont.click();
        hideAds();
    }

    public void goToCartPage() {
        hideAds();
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        cart.click();
        hideAds();
    }

    // --------------------------
    // VALIDATIONS
    // --------------------------
    public boolean isOnProductsPage() {
        safeWaitForPage();
        return driver.getCurrentUrl().contains("/products");
    }

    public boolean areProductsVisible() {
        safeWaitForPage();
        List<WebElement> products = driver.findElements(productItems);
        return products.size() > 0;
    }

    // --------------------------
    // WRAPPERS FOR STEP DEFINITIONS
    // --------------------------
    public void goToProducts() {
        openProductsPage();
    }

    public void goToCart() {
        goToCartPage();
    }

    public void openProducts() {
        openProductsPage();
    }
}*/
package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addFirstProduct = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    private By productItems = By.cssSelector(".product-image-wrapper");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) driver;
    }

    // --------------------------
    // UNIVERSAL AD BLOCKER – VERY IMPORTANT
    // --------------------------
    private void hideAds() {
        try {
            js().executeScript(
                    "document.querySelectorAll('iframe, .adsbygoogle, #ad_position_box')" +
                            ".forEach(e => e.remove());"
            );
        } catch (Exception ignored) {}
    }

    private void safeWaitForPage() {
        try {
            wait.until(web -> ((JavascriptExecutor) web)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception ignored) {}
        hideAds();
    }

    // -----------------------------------------------------------
    // ⭐ NEW — FIX cartModal blocking Cart click
    // -----------------------------------------------------------
    private void closeCartModalIfVisible() {
        try {
            js().executeScript(
                    "let modal = document.querySelector('#cartModal');" +
                            "if(modal) { modal.classList.remove('show'); modal.style.display='none'; }"
            );
        } catch (Exception ignored) {}
    }

    // --------------------------
    // NAVIGATION
    // --------------------------
    public void openProductsPage() {
        driver.get("https://automationexercise.com/products");

        safeWaitForPage();

        // Ensure scroll top
        js().executeScript("window.scrollTo(0,0)");
        hideAds();
    }

    // --------------------------
    // PRODUCT OPERATIONS
    // --------------------------
    public void addFirstProductToCart() {
        hideAds();

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addFirstProduct));

        js().executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        js().executeScript("arguments[0].click();", btn);

        hideAds();
    }


    public void clickContinueShopping() {
        hideAds();
        WebElement cont = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        cont.click();
        hideAds();
    }

    public void goToCartPage() {

        // ⭐ ADDED FIX — Close modal before clicking Cart
        closeCartModalIfVisible();

        hideAds();
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        cart.click();
        hideAds();
    }

    // --------------------------
    // VALIDATIONS
    // --------------------------
    public boolean isOnProductsPage() {
        safeWaitForPage();
        return driver.getCurrentUrl().contains("/products");
    }

    public boolean areProductsVisible() {
        safeWaitForPage();
        List<WebElement> products = driver.findElements(productItems);
        return products.size() > 0;
    }

    // --------------------------
    // WRAPPERS FOR STEP DEFINITIONS
    // --------------------------
    public void goToProducts() {
        openProductsPage();
    }

    public void goToCart() {
        goToCartPage();
    }

    public void openProducts() {
        openProductsPage();
    }
}

