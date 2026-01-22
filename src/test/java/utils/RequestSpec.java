
package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static RequestSpecification requestSpec;

    public static RequestSpecification getRequestSpec() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(ConfigReader.get("base.uri"))
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
        }
        return requestSpec;
    }
}
