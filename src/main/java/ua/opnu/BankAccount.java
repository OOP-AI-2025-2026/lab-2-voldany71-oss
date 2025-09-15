package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    // Дефолтный конструктор
    public BankAccount() {
        this.name = "";
        this.balance = 0;
        this.transactionFee = 0;
    }

    // Пополнение счёта
    void deposit(double amount) {
        if (amount <= 0) {
            // по условию: для неверных аргументов не изменяем баланс
            return;
        }
        balance += amount;
    }

    // Снятие средств с учётом комиссии — возвращаем boolean
    boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance < total) {
            return false; // недостаточно средств — не меняем баланс
        }
        balance -= total;
        return true;
    }

    // Перевод на другой счёт: списываем amount + комиссия с текущего и добавляем amount на receiver
    boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance < total) {
            return false; // недостаточно средств — не переводим
        }
        balance -= total;
        // receiver.deposit доступен (package-private) и корректно добавит деньги
        receiver.deposit(amount);
        return true;
    }
}
