@api
Feature: User API Testing

  @api
  Scenario Outline: Login with invalid credentials
    When api I login using email "<email>" and password "<password>"
    Then the status code should be <statusCode>
    And the response should contain "<message>"

    Examples:
      | email          | password   | statusCode | message         |
      | hk18@gmail.com | Hari@0577  | 404        | User not found  |

  @api
  Scenario Outline: Get user details for non-existing email
    When I get user details using email "<email>"
    Then the status code should be <statusCode>
    And the response should contain "<message>"

    Examples:
      | email          | statusCode | message            |
      | hk18@gmail.com | 404        | Account not found  |
