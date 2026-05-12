@regression
Feature: Account Management
  As a bank customer
  I want to manage my account details
  So that my information stays current and accurate

  Background:
    Given the user is on the banking login page
    When the user enters valid username "testuser@bank.com" and password "TestPass@123"
    Then the user should be redirected to the dashboard

  @smoke
  Scenario: View account balance successfully
    When the user navigates to account summary
    Then the account balance should be displayed
    And the account number should be visible

  @regression
  Scenario: View transaction history
    When the user navigates to transaction history
    Then the transaction list should be displayed
    And each transaction should show date amount and status

  @regression
  Scenario Outline: Filter transactions by type
    When the user navigates to transaction history
    And the user filters by transaction type "<type>"
    Then only "<type>" transactions should be displayed

    Examples:
      | type    |
      | NEFT    |
      | RTGS    |
      | IMPS    |
      | UPI     |

  @regression
  Scenario: Download account statement
    When the user navigates to account summary
    And the user requests statement for last 3 months
    Then the statement should download successfully
    And the file format should be PDF
