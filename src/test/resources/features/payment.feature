@regression
Feature: Bill Payment and Recharge
  As a bank customer
  I want to pay bills and recharge mobile
  So that I can manage payments from one place

  Background:
    Given the user is on the banking login page
    When the user enters valid username "testuser@bank.com" and password "TestPass@123"
    Then the user should be redirected to the dashboard

  @smoke
  Scenario: Pay electricity bill successfully
    When the user navigates to payments module
    And the user selects bill type "Electricity"
    And the user enters consumer number "123456789"
    And the user fetches the bill
    Then the bill amount should be displayed
    When the user pays the bill
    Then the payment should be successful
    And a transaction reference should be generated

  @regression
  Scenario: Mobile recharge successfully
    When the user navigates to payments module
    And the user selects bill type "Mobile Recharge"
    And the user enters mobile number "9999999999"
    And the user enters recharge amount "199"
    And the user submits the recharge
    Then the payment should be successful

  @regression
  Scenario Outline: Multiple bill type payments
    When the user navigates to payments module
    And the user selects bill type "<billType>"
    And the user enters consumer number "<consumerNumber>"
    And the user fetches the bill
    When the user pays the bill
    Then the payment should be successful

    Examples:
      | billType    | consumerNumber |
      | Electricity | 111222333      |
      | Water       | 444555666      |
      | Gas         | 777888999      |
