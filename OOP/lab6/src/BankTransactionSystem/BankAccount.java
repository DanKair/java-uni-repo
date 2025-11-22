package BankTransactionSystem;

public class BankAccount {
    private double balance;
    private Currency currency;

    // Constructor with validation
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    // Synchronized Methods to avoid Dead Lock by ensuring only one thread accessing a method at a time
    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Negative or 0 amount was passed!");
        }
        this.balance += amount;
    }

    // Exactly Same thing, but this variant allows more control and blocks code of inside synchronized() block
//    public void deposit(double amount) {
//        synchronized (this) {
//            balance += amount;
//        }
//    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Negative or 0 amount was passed!");
        }

        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds!");
        }

        this.balance -= amount;
    }

    public double getBalance() {
        // Synchronizing only code inside "synchronized" block
        synchronized (this) {
            return this.balance;
        }
    }

    public synchronized boolean canOpenSaveAccount() {
        // Condition for Opening Save Account in KZT
        if (this.currency.equals(Currency.KZT) && getBalance() >= 50_000) {
            return true;
        }
        // Condition for Opening Save Account in RUB
        else if (this.currency.equals(Currency.RUB) && getBalance() >= 10_000) {
            return true;
        }
        // Can open Save Account only if balance >= 100$
        else if (this.currency.equals(Currency.USD) && getBalance() >= 100) {
            return true;
        } else if (this.currency.equals(Currency.EURO) && getBalance() >= 100) {
            return true;
        }
        return false;
    }

    // Logic for Currency Exchange:
    // 1. Create currencyFromExchange and currencyToExchange variables
    // 2. If currencyFromExchange == KZT and currencyToExchange == RUB and (this.balance / 6) > 0: this.balance /= 6

    public synchronized void currencyExchange(Currency from, Currency to) {

        if (!currency.equals(from)) {
            throw new IllegalArgumentException("Account currency does not match 'from' currency");
        }

        if (from == to) {
            throw new IllegalArgumentException("Cannot convert to the same currency");
        }

        // Example exchange rates
        double rate = 0;

        if (from == Currency.KZT && to == Currency.RUB) rate = 1.0 / 6;
        else if (from == Currency.KZT && to == Currency.USD) rate = 1.0 / 520;
        else if (from == Currency.KZT && to == Currency.EURO) rate = 1.0 / 600;
        else
            throw new IllegalArgumentException("Unsupported exchange pair");

        // Perform conversion
        this.balance = this.balance * rate;
        this.currency = to;
    }

}