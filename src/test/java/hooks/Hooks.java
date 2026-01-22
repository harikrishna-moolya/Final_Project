package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.logging.log4j.Logger;
import utils.LoggerClass;
import ui.driver.DriverFactory;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class Hooks {

    private static final Logger log = LoggerClass.getLogger(Hooks.class);

    /* -------------------- API SETUP -------------------- */
    @Before(order = 0)
    public void setupAPI() {
        String baseUri = ConfigReader.get("base.uri");
        RestAssured.baseURI = baseUri;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.defaultParser = Parser.JSON;
        log.info("API Base URI set to: " + baseUri);
    }

    /* -------------------- LOGGING -------------------- */
    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        log.info("===== STARTING SCENARIO: " + scenario.getName() + " =====");
    }

    /* -------------------- UI SETUP -------------------- */
    @Before(value = "@UI", order = 2)
    public void setupUI() {
        DriverFactory.getDriver();
        log.info("UI Driver initialized");
    }

    /* -------------------- SCREENSHOT ON FAILURE -------------------- */
    @After(value = "@UI", order = 0)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.capture(scenario.getName());
            log.error("Screenshot captured for failed scenario: " + scenario.getName());
        }
    }

    /* -------------------- TEARDOWN -------------------- */
    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        log.info("===== ENDING SCENARIO: " + scenario.getName() + " =====");
    }

    @After(value = "@UI", order = 2)
    public void tearDownUI() {
        DriverFactory.quitDriver();
        log.info("UI Driver closed");
    }
}
