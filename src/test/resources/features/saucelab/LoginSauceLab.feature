Feature: Testing Login Functionality

  Background: navigation
    Given User navigates to the 'https://www.saucedemo.com/'

  Scenario Outline:Happy Path Login
    When User provides '<username>' and '<password>' for SauceLab
    Then User validates '<title>' from SauceLab
    Examples:
      | username                | password     | title     |
      | standard_user           | secret_sauce | Swag Labs |
      | problem_user            | secret_sauce | Swag Labs |
      | performance_glitch_user | secret_sauce | Swag Labs |
      | error_user              | secret_sauce | Swag Labs |
      | visual_user             | secret_sauce | Swag Labs |

    Scenario Outline: Negative Login

      Examples:
