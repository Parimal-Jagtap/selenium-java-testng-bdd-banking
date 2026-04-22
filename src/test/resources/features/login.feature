@smoke
Feature: Banking Application Login
  As a bank customer
  I want to login to the banking portal
  So that I can access my account securely

  Background:
    Given the user is on the banking login page

  @smoke
  Scenario: Successful login with valid credentials
    When the user enters valid username "testuser@bank.com" and password "TestPass@123"
    Then the user should be redirected to the dashboard

  @regression
  Scenario: Login fails with invalid password
    When the user enters invalid username "testuser@bank.com" and password "WrongPass"
    Then the user should see error message "Invalid username or password"

  @regression
  Scenario: Login fails with invalid username
    When the user enters invalid username "invalid@bank.com" and password "TestPass@123"
    Then the user should see error message "Invalid username or password"

  @regression
  Scenario: Login fails with empty credentials
    When the user enters invalid username "" and password ""
    Then the user should see error message "Username and password are required"
