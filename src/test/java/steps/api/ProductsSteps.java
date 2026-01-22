
package steps.api;

import api_actions.ProductAPI;
import io.cucumber.java.en.When;
import utils.LoggerClass;
import org.apache.logging.log4j.Logger;

import static steps.api.CommonSteps.response;

public class ProductsSteps {

    ProductAPI api = new ProductAPI();
    Logger log = LoggerClass.getLogger(ProductsSteps.class);

    @When("I send GET request to {string}")
    public void getRequest(String endpoint) {

        // GET requests are NOT supported for API.automationexercise.com
        // this step is mainly for NEGATIVE testing (405 expected)

        response = api.sendGet(endpoint);  // handles dynamic GET calls

        log.info("Response: " + response.asString());
    }

    @When("I send POST request to {string}")
    public void postRequest(String endpoint) {

        // productsList must use POST + empty JSON body
        if (endpoint.equals("/api/productsList")) {
            response = api.getProducts();
        }
        // brandsList must also use POST for negative test
        else {
            response = api.sendPost(endpoint);
        }

        log.info("Response: " + response.asString());
    }

    @When("I search products with keyword {string}")
    public void searchProduct(String keyword) {
        response = api.searchProduct(keyword);
        log.info("Search Response: " + response.asString());
    }
}
