@integration
Feature: Login UI and API Error Consistency

  Scenario Outline: Failed login in UI should match API failure response
    Given I am on login page
    When I enter login email "<uiEmail>"
    And I enter login password "<uiPassword>"
    And I click login button
    Then I should stay on login page with error message

    When api I login using email "<apiEmail>" and password "<apiPassword>"
    Then the status code should be <statusCode>
    And the response should contain "<apiMessage>"

    Examples:
      | uiEmail        | uiPassword     | apiEmail        | apiPassword | statusCode | apiMessage     |
      | hk18@gmail.com | WrongPass123   | hk18@gmail.com | hk          | 404        | User not found |
