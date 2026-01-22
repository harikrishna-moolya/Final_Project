@api
Feature: Products API Testing

  @api
  Scenario Outline: Get all products list using <method> request
    When I send <method> request to "<endpoint>"
    Then the status code should be <statusCode>
    And the response should contain "<responseMessage>"

    Examples:
      | method | endpoint           | statusCode | responseMessage                         |
      | GET    | /api/productsList  | 200        | products                                |
      | POST   | /api/productsList  | 405        | This request method is not supported    |

  @api
  Scenario Outline: Search product with keyword "<keyword>"
    When I search products with keyword "<keyword>"
    Then the status code should be <statusCode>
    And the response should contain "<responseKey>"

    Examples:
      | keyword     | statusCode | responseKey |
      | top         | 200        | products    |
      | xyz12345    | 200        | products    |
      |             | 200        | products    |
      | @@@@        | 200        | products    |
