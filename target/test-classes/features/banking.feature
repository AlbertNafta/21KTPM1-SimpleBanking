Feature: Banking Operations

  Scenario: Deposit money into the account
    Given I have an account with a balance of 100
    When I deposit 50
    Then the balance should be 150

  Scenario: Withdraw money from the account
    Given I have an account with a balance of 100
    When I withdraw 30
    Then the balance should be 70

  Scenario: Withdraw more money than the balance
    Given I have an account with a balance of 50
    When I withdraw 70
    Then I should see an "Insufficient funds" error

  Scenario: Withdraw a negative amount
    Given I have an account with a balance of 100
    When I withdraw -50
    Then I should see an "Withdrawal amount must be positive." error

  Scenario: Withdraw a non-numeric input
    Given I have an account with a balance of 100
    When I withdraw "a"
    Then  Then I should see an "Invalid input. Please enter a number." error


  Scenario: Deposit a very large number
    Given I have an account with a balance of 100
    When I deposit 1000000000000
    Then the balance should be 1000000000100