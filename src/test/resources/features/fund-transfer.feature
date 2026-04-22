@regression
Feature: Fund Transfer
  As a bank customer
  I want to transfer funds to another account
  So that I can make payments securely

  Background:
    Given the user is on the banking login page
    When the user enters valid username "testuser@bank.com" and password "TestPass@123"
    Then the user should be redirected to the dashboard

  @smoke
  Scenario: Successful IMPS fund transfer
    When the user navigates to fund transfer module
    And the user selects transfer type "IMPS"
    And the user enters beneficiary account "1234567890"
    And the user enters transfer amount "1000"
    And the user enters remarks "Test IMPS Transfer"
    And the user submits the transfer
    Then the transfer should be successful

  @regression
  Scenario: Successful NEFT fund transfer
    When the user navigates to fund transfer module
    And the user selects transfer type "NEFT"
    And the user enters beneficiary account "9876543210"
    And the user enters transfer amount "5000"
    And the user enters remarks "Test NEFT Transfer"
    And the user submits the transfer
    Then the transfer should be successful

  @regression
  Scenario Outline: Multiple transfer types validation
    When the user navigates to fund transfer module
    And the user selects transfer type "<transferType>"
    And the user enters beneficiary account "<account>"
    And the user enters transfer amount "<amount>"
    And the user enters remarks "<remarks>"
    And the user submits the transfer
    Then the transfer should be successful

    Examples:
      | transferType | account    | amount | remarks        |
      | NEFT         | 1111111111 | 2000   | NEFT Payment   |
      | RTGS         | 2222222222 | 50000  | RTGS Payment   |
      | IMPS         | 3333333333 | 500    | IMPS Payment   |
