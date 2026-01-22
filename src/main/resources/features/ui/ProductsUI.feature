@UI
Feature: Add products

  Scenario Outline: Add product to cart
    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should stay on login page with error message

    Examples:
      | email          | password   |
      | hk18@gmail.com | Hari@0577  |


  @UI
  Scenario Outline: Verify products are displayed
    When I open products page
    Then I should see all product listings visible

    Examples:
      | dummy |
      | data  |


  @UI
  Scenario Outline: Stay on products page after loading
    When I open products page
    Then I should remain on products page

    Examples:
      | dummy |
      | data  |
