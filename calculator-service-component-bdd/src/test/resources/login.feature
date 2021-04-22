@Login
Feature: Login to the application

  Narrative: This feature shall validate all the scenarios of login API

  Scenario Outline: Verify whether use can able to login with valid credentials
    Given user has an account
    When user login with "<username>" and "<password>"
    Then user should get the status code "<responseCode>"
    And response should contain username "<username>"

    Examples:
      | username | password | responseCode |
      | admin1   | admin    | 401          |
