
package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import utils.ConfigReader;

public class ApiSetup {

    @Before(order = 0)
    public void setupAPI() {
        String baseUri = ConfigReader.get("base.uri");
        RestAssured.baseURI = baseUri;

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.defaultParser = Parser.JSON;

        System.out.println(">>> Base URI Set: " + baseUri);
    }
}
