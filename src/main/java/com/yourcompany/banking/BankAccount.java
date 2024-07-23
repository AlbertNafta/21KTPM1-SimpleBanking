package com.yourcompany.banking;

public class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                throw new IllegalStateException("Insufficient funds");
            }
        } else {
            throw new IllegalStateException("Withdrawal amount must be positive.");
        }
    }


    public double getBalance() {
        return balance;
    }
}
