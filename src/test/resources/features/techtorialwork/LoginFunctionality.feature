Feature: Testing the Login Functionality of TechtorialWork Website

  Background: Repeated steps for scenarios(It will run before every scenario)
    Given User validates the title is 'techtorial'
    And User validates log_in is visible

  Scenario: Happy Path Login Functionality(Positive)
#    Given User validates the title is 'techtorial'
#    And User validates log_in is visible
    When User provides 'dev_techtorial@example.com' and '123456789' to the loginPage
    Then User validates the title 'Dashboard' from MainPage

  Scenario: Negative Login Functionality(Incorrect email and password
#    Given User validates the title is 'techtorial'
#    And User validates log_in is visible
    When User provides 'asdasd@example.com' and '423432' to the loginPage
    Then User validates the 'These credentials do not match our records.' message and 'rgba(211, 0, 0, 1)' color


#navigate to url: https://techtorialwork.com/worksuit/public/login
#Verify the title is "techtorial"
#Verify "Log In" is visiable on the page
#Enter correct email and password
#Click login button
#Verify title is "Dashboard"

  #Task2
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Verify the title is "techtorial"
#  Verify "Log In" is visiable on the page
#  Enter incorrect email and password
#  Click login button
#  "Verify error message is displayed ""These credentials do not match our records.
#  "" in red color."