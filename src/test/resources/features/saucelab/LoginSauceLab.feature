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
    When User provides '<username>' and '<password>' for SauceLab
    Then User validates the '<errorMessage>' from LoginPage
    Examples:
      | username        | password      | errorMessage                                                              |
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      | wrongUsername   | wrongpassword | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce  | Epic sadface: Username is required                                        |
      | locked_out_user |               | Epic sadface: Password is required                                        |
      |                 |               | Epic sadface: Username is required                                        |

    #DATATABLE LOGIC
  Scenario: Testing Happy Path with DataTable as Map
    When User provides username and password for SauceLab
      | username | standard_user |
      | password | secret_sauce  |
    Then User validates title from SauceLab
      | title | Swag Labs |

  Scenario: Testing Happy Path with DataTable with As List
    When User provides username and password for SauceLab as List
      | standard_user |
      | secret_sauce  |
    Then User validates title from SauceLab as List
      | Swag Labs |

