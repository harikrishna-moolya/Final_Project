package utils;

import org.openqa.selenium.*;
import ui.driver.DriverFactory;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void capture(String scenarioName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + scenarioName + ".png");
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
