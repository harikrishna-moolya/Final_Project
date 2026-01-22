
package steps.api;

import api_actions.UserAPI;
import io.cucumber.java.en.When;
import utils.LoggerClass;
import org.apache.logging.log4j.Logger;

public class UserSteps {

    UserAPI api = new UserAPI();
    Logger log = LoggerClass.getLogger(UserSteps.class);

    @When("api I login using email {string} and password {string}")
    public void login(String email, String password) {
        CommonSteps.response = api.login(email, password);
        log.info("Login Response: " + CommonSteps.response.asString());
    }

    @When("I get user details using email {string}")
    public void getUserDetails(String email) {
        CommonSteps.response = api.getUserByEmail(email);
        log.info("User Details Response: " + CommonSteps.response.asString());
    }
}
