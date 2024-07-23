package com.yourcompany.banking;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField balanceField;

    @FXML
    private TextField depositField;

    @FXML
    private TextField withdrawField;

    @FXML
    private Label errorLabel;

    private BankAccount account;

    public void initialize() {
        // Initialize your bank account
        account = new BankAccount("123456", 100.0); // Example initial balance
        updateBalanceField();
    }

    @FXML
    public void depositButtonClicked() {
        try {
            double amount = Double.parseDouble(depositField.getText());
            account.deposit(amount);
            updateBalanceField();
            errorLabel.setText(""); // Clear previous errors
        } catch (NumberFormatException e) {
            errorLabel.setText("Invalid input. Please enter a number.");
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void withdrawButtonClicked() {
        String amountText = withdrawField.getText();
        try {
            double amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            } else {
                account.withdraw(amount);
                updateBalanceField();
                errorLabel.setText("");
            }

        } catch (NumberFormatException e) {
            errorLabel.setText("Invalid amount.");
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
        System.out.println("Error label updated to: " + errorLabel.getText()); // Debugging output
    }

    private void updateBalanceField() {
        balanceField.setText(String.valueOf(account.getBalance()));
    }

    private double validateInput(String input) {
        try {
            double amount = Double.parseDouble(input);
            if (amount < 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a number.");
        }
    }


    // Getter methods
    public TextField getDepositField() {
        return depositField;
    }

    public TextField getWithdrawField() {
        return withdrawField;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }
    public TextField getBalanceField() {
        return balanceField;
    }

    // Setter method for account
    public void setAccount(BankAccount account) {
        this.account = account;
        updateBalanceField();
    }
}
