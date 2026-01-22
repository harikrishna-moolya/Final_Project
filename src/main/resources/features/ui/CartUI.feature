@UI
Feature: Cart operations

  Scenario Outline: Add product and open cart
    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    And I go to products page
    And I add first product to cart
    And I continue shopping
    And I open cart page
    Then I should see at least one product in cart

    Examples:
      | email          | password   |
      | hk18@gmail.com | Hari@0577  |
