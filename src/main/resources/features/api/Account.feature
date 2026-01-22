@api
Feature: Account Management

  Scenario Outline: Delete a user account
    When I delete user with email "<email>" and password "<password>"
    Then the status code should be <statusCode>
    And the response should contain "<message>"

    Examples:
      | email          | password   | statusCode | message            |
      | hk18@gmail.com | Hari@0577  | 404        | Account not found  |
