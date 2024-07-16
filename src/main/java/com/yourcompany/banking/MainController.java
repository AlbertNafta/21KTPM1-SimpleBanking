package com.yourcompany.banking;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private void depositButtonClicked() {
        String input = depositField.getText();
        double amount = validateInput(input);
        if (amount >= 0) {
            account.deposit(amount);
            updateBalanceField();
            errorLabel.setText(""); // Clear error message
        }
    }

    @FXML
    private void withdrawButtonClicked() {
        String input = withdrawField.getText();
        double amount = validateInput(input);
        if (amount >= 0) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                updateBalanceField();
                errorLabel.setText(""); // Clear error message
            } else {
                errorLabel.setText("Insufficient funds.");
            }
        }
    }

    private void updateBalanceField() {
        balanceField.setText(String.valueOf(account.getBalance()));
    }

    private double validateInput(String input) {
        try {
            double amount = Double.parseDouble(input);
            if (amount < 0) {
                errorLabel.setText("Amount cannot be negative.");
                return -1;
            }
            return amount;
        } catch (NumberFormatException e) {
            errorLabel.setText("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
