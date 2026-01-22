@integration
Feature: User Deletion Impact on UI and API

  Scenario Outline: Deleted user should not authenticate via UI or API
    When I delete user with email "<email>" and password "<password>"
    Then the status code should be <statusCode>
    And the response should contain "<apiMessage>"

    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should stay on login page with error message

    Examples:
      | email          | password   | statusCode | apiMessage        |
      | hk18@gmail.com | Hari@0577  | 404        | Account not found |
