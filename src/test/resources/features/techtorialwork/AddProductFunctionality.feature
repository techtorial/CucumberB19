Feature: Testing Adding New Products Functionality

  Scenario: Happy Path Product Adding Function
    Given User provides username and password to the loginPage
    When User clicks Products Button and addProductButton from Products Page
    And User provides 'Truck-Mounted Crane' and '15000' to the product details
    And User selects 'Lifting and Material Handling Equipment','Mobile Cranes' and '1' from drop-downs
    And User clicks purchase check box,add 'It is a good product' into the description and save button
    Then User validates product details 'Truck-Mounted Crane','$16,500.00','Allowed' from table




