package com.yourcompany.banking.steps;

import com.yourcompany.banking.BankAccount;
import com.yourcompany.banking.MainController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class BankingSteps extends ApplicationTest {

    private BankAccount account;
    private MainController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Given("I have an account with a balance of {double}")
    public void iHaveAnAccountWithABalanceOf(Double balance) {
        // Initialize the MainController with the given balance
        Platform.runLater(() -> {
            controller.setAccount(new BankAccount("123456", balance));
        });
    }

    @When("I deposit {double}")
    public void iDeposit(String amountString) {
        controller.getDepositField().setText(amountString);
        try {
            controller.depositButtonClicked();
        } catch (IllegalArgumentException e) {
            controller.getErrorLabel().setText(e.getMessage());
        }
    }




    @Then("the balance should be {double}")
    public void theBalanceShouldBe(Double expectedBalance) {
        // Ensure the balance check is on the JavaFX Application Thread
        Platform.runLater(() -> {
            assertEquals(expectedBalance, Double.parseDouble(controller.getBalanceField().getText()));
        });
    }

    @Then("I should see an {string} error")
    public void iShouldSeeAnError(String expectedError) {
        Platform.runLater(() -> {
            String actualErrorMessage = controller.getErrorLabel().getText();
            System.out.println("Actual error message: " + actualErrorMessage); // Debugging output
            assertEquals(expectedError, actualErrorMessage);
        });
    }

    @When("I withdraw {double}")
    public void iWithdraw(double amountString) {
        controller.getWithdrawField().setText(String.valueOf(amountString));

        try {
            controller.withdrawButtonClicked();
        } catch (IllegalArgumentException e) {
            controller.getErrorLabel().setText(e.getMessage());
        }
    }


    @When("I withdraw {string}")
    public void iWithdraw(String amountString) {
        controller.getWithdrawField().setText(amountString);

        try {
            controller.withdrawButtonClicked();
        } catch (IllegalArgumentException e) {
            controller.getErrorLabel().setText(e.getMessage());
        }
    }
}
