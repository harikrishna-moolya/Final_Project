@e2e
Feature: Guest checkout redirection

  Scenario Outline: Guest user is forced to login when checking out
    When I get user details using email "<email>"
    Then the status code should be <statusCode>
    And the response should contain "<apiMessage>"

    When I go to products page
    And I add first product to cart
    And I continue shopping
    And I open cart page
    And I click checkout on cart page
    And I choose to login from checkout page
    Then I am on login page

    Examples:
      | email          | statusCode | apiMessage        |
      | hk18@gmail.com | 404        | Account not found |
