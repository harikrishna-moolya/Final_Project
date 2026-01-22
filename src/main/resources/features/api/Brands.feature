@api
Feature: Brands API Testing

  Scenario Outline: Get all brands list (method not supported)
    When I send GET request to "<endpoint>"
    Then the status code should be <statusCode>
    And the response should contain "<responseKey>"

    Examples:
      | endpoint         | statusCode | responseKey |
      | /api/brandsList  | 200        | brands      |
