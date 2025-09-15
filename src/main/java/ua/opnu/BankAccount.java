package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    // Конструктор
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0; // початкове значення комісії
    }

    // Встановлення комісії
    public void setTransactionFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Комісія не може бути від'ємною");
        }
        this.transactionFee = fee;
    }

    // Поповнення рахунку
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума депозиту повинна бути більше нуля");
        }
        balance += amount;
    }

    // Повертає баланс
    double getBalance() {
        return this.balance;
    }

    // Зняття грошей з урахуванням комісії
    boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума зняття повинна бути більше нуля");
        }

        double totalAmount = amount + transactionFee;
        if (balance < totalAmount) {
            return false; // недостатньо коштів
        }

        balance -= totalAmount;
        return true;
    }

    // Перевід грошей на інший рахунок з урахуванням комісії
    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума переводу повинна бути більше нуля");
        }

        double totalAmount = amount + transactionFee;
        if (balance < totalAmount) {
            return false; // недостатньо коштів
        }

        // Знімаємо гроші з поточного рахунку
        balance -= totalAmount;

        // Додаємо гроші на рахунок отримувача
        receiver.deposit(amount);

        return true;
    }
}
