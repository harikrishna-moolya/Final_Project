@integration
Feature: UI and API Product Search Sync

  Scenario Outline: Searching for product keyword should match API search results
    When I open products page
    Then I should see all product listings visible
    When I search products with keyword "<keyword>"
    Then the status code should be <statusCode>
    And the response should contain "<responseKey>"

    Examples:
      | keyword | statusCode | responseKey |
      | top     | 200        | products    |
