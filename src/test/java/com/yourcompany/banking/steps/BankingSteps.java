package com.yourcompany.banking.steps;

import com.yourcompany.banking.BankAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class BankingSteps {

    private BankAccount account;
    private String errorMessage;

    @Given("I have an account with a balance of {double}")
    public void iHaveAnAccountWithABalanceOf(Double balance) {
        account = new BankAccount("123456", balance);
    }

    @When("I deposit {double}")
    public void iDeposit(Double amount) {
        account.deposit(amount);
    }

    @When("I withdraw {double}")
    public void iWithdraw(Double amount) {
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the balance should be {double}")
    public void theBalanceShouldBe(Double expectedBalance) {
        assertEquals(expectedBalance, account.getBalance());
    }

    @Then("I should see an {string} error")
    public void iShouldSeeAnError(String expectedError) {
        assertEquals(expectedError, errorMessage);
    }
}
