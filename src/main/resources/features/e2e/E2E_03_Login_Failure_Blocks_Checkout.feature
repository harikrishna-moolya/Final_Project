@e2e
Feature: Login failure prevents checkout

  Scenario Outline: Checkout cannot continue with wrong credentials
    When I get user details using email "<email>"
    Then the status code should be <statusCode>
    And the response should contain "<apiMessage>"

    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should stay on login page with error message

    Examples:
      | email          | password           | statusCode | apiMessage        |
      | hk18@gmail.com | WrongPassword123   | 404        | Account not found |
