Feature: Testing Search Functionality of Etsy

  Background: navigation
    Given User navigates to the 'https://www.etsy.com/'

  Scenario Outline: Happy Path Search Function
    When User search '<itemName>' from searchBar
    Then User validates '<title>' as title
    Examples:
      | itemName | title      |
      | Hat      | Hat - Etsy |
      | Key      | Key - Etsy |
      | Pin      | Pin - Etsy |

#  Scenario: Happy Path Search Function
#    When User search 'Key' from searchBar
#    Then User validates 'Key - Etsy' as title
#
#  Scenario: Happy Path Search Function
#    When User search 'Pin' from searchBar
#    Then User validates 'Pin - Etsy' as title