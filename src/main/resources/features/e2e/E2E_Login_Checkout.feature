@e2e
Feature: Checkout after login

  Scenario Outline: Successful checkout after logging in from home page
    When I get user details using email "<email>"
    Then the status code should be <statusCode>
    And the response should contain "<apiMessage>"

    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    And I go to products page
    And I add first product to cart
    And I continue shopping
    And I open cart page
    And I click checkout on cart page
    And I choose to login from checkout page
    Then I am on login page

    Examples:
      | email          | password   | statusCode | apiMessage        |
      | hk18@gmail.com | Hari@0577  | 404        | Account not found |
