package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {
                "steps.ui",
                "steps.api",
                "steps.integration",
                "hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
        // tags will be controlled from testng.xml
)
public class FinalTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)// parallel execution fails in many cases because i'm using public website
    // please use "parallel=false"
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
