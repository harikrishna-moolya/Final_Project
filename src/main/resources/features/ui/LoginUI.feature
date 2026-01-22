@UI
Feature: Login UI

  Scenario Outline: Successful login
    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should be redirected to homepage

    Examples:
      | email          | password   |
      | hk18@gmail.com | Hari@0577  |


  @UI
  Scenario Outline: Login with incorrect password
    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should stay on login page with error message

    Examples:
      | email          | password        |
      | hk18@gmail.com | WrongPass123    |


  @UI
  Scenario Outline: Login with empty email
    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should see email validation error

    Examples:
      | email | password   |
      |       | Hari@0577  |


  @UI
  Scenario Outline: Login with empty password
    Given I am on login page
    When I enter login email "<email>"
    And I enter login password "<password>"
    And I click login button
    Then I should see password validation error

    Examples:
      | email          | password |
      | hk18@gmail.com |          |
