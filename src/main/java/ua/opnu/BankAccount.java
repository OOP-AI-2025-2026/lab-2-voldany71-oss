package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    void deposit(double amount) {
        // TODO: modify method body
        balance = balance + amount;
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        // TODO: modify method body
        balance = balance - amount;
        return true;
    }

    boolean transfer(BankAccount receiver, double amount) {
        // TODO: modify method body
        return false;
    }
}