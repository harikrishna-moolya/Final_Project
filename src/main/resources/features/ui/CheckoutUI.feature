@UI
Feature: Checkout navigation

  Scenario Outline: Logged-in user proceeds to checkout successfully
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
      | email          | password   |
      | hk18@gmail.com | Hari@0577  |


  @UI
  Scenario Outline: Guest user is asked to login at checkout
    When I go to products page
    And I add first product to cart
    And I continue shopping
    And I open cart page
    And I click checkout on cart page
    And I choose to login from checkout page
    Then I am on login page

    Examples:
      | dummy |
      | data  |
