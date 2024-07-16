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
