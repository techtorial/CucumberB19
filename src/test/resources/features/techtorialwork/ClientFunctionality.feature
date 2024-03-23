@regression
Feature: Testing Client Functions

  Background: navigation
    Given User provides username and password to the loginPage

  Scenario:Happy Path creating new client
    When User clicks Clients button
    And User clicks add client and provides account information 'John Doe','United States','1342343243'
    And User provides company information 'Doe Construction Inc.','http://www.doeconstruction.com','5434534645'
    And User provides address information '456 Oak Avenue,Springfield,IL,62701','789 Birch Lane,Springfield,IL,62702'
    Then User clicks save button and validates 'John Doe','Doe Construction Inc.'