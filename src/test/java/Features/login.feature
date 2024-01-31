Feature: Login Functionality

  Scenario Outline: User can log in with valid credentials
    Given User is on the login page
    When User enters valid username "<username>" and password "<password>"
    Then User should be logged in successfully
    Examples:
      | username | password |
      | username | password |


  Scenario Outline: User cannot log in with invalid credentials
    Given User is on the login page
    When User enters invalid username "<invalid_username>" and password "<invalid_password>"
    Then User should see an error message
    Examples:
      | invalid_username | invalid_password |
      | username         | password         |
