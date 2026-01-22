package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
        // utility class
    }

    public static WebDriver getDriver() {

        if (driver.get() == null) {

            String browser = ConfigReader.get("browser");

            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }

            switch (browser.toLowerCase()) {

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    options.addArguments("--start-maximized");
                    driver.set(new ChromeDriver(options));
                    break;
            }
        }
        return driver.get();
    }

    // ⭐ UNIVERSAL AD REMOVER (UNCHANGED)
    public static void removeAds(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "document.querySelectorAll('iframe, .adsbygoogle, #ad_position_box, .modal-backdrop, #aswift_0, #aswift_1, .popup')" +
                            ".forEach(e => e.remove());"
            );

            js.executeScript(
                    "document.querySelectorAll('.modal.show, .modal').forEach(e => e.style.display='none');"
            );

        } catch (Exception ignored) {}
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
