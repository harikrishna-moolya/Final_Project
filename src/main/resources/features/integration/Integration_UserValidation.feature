@integration
Feature: API and UI User Validation Sync

  Scenario Outline: Non-existing user lookup should match UI login error
    When I get user details using email "<email>"
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
