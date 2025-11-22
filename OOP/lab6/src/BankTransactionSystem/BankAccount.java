package BankTransactionSystem;

public class BankAccount {
    private double balance;
    private Currency currency;

    // Constructor with validation
    public BankAccount(double initialBalance, Currency currency) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
        this.currency = currency;
    }

    // Default Constructor
    public BankAccount(){
        this.balance = 0;
        this.currency = Currency.USD;
    }

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
        this.currency = Currency.USD;
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

    // Synchronized Getter methods
    public double getBalance() {
        // Synchronizing only code inside "synchronized" block
        synchronized (this) {
            return this.balance;
        }
    }

    public Currency getCurrency() {
        synchronized (this) {
            return this.currency;
        }
    }

    public synchronized boolean canOpenSaveAccount() {
        // Condition for Opening Save Account in Currency.KZT
        if (this.currency.equals(Currency.KZT) && getBalance() >= 50_000) {
            return true;
        }
        // Condition for Opening Save Account in Currency.RUB
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
    // 2. If currencyFromExchange == Currency.KZT and currencyToExchange == Currency.RUB and (this.balance / 6) > 0: this.balance /= 6

    public synchronized void currencyExchange(Currency from, Currency to) {

        if (!currency.equals(from)) {
            throw new IllegalArgumentException("Account currency does not match 'from' currency");
        }

        if (from == to) {
            throw new IllegalArgumentException("Cannot convert to the same currency");
        }

        // Example exchange rates
        double rate = 0;

        // Currency.KZT →
        if (from == Currency.KZT && to == Currency.RUB)  rate = 1.0 / 6;
        if (from == Currency.KZT && to == Currency.USD)  rate = 1.0 / 520;
        if (from == Currency.KZT && to == Currency.EURO) rate = 1.0 / 600;

        // Currency.USD →
        if (from == Currency.USD && to == Currency.KZT)  rate = 520;
        if (from == Currency.USD && to == Currency.RUB)  rate = 80;
        if (from == Currency.USD && to == Currency.EURO) rate = 0.87;

        // Currency.RUB →
        if (from == Currency.RUB && to == Currency.KZT)  rate = 6;
        if (from == Currency.RUB && to == Currency.USD)  rate = 1.0 / 80;
        if (from == Currency.RUB && to == Currency.EURO) rate = 1.0 / 90;

        // Currency.EURO →
        if (from == Currency.EURO && to == Currency.KZT) rate = 600;
        if (from == Currency.EURO && to == Currency.USD) rate = 1.15;
        if (from == Currency.EURO && to == Currency.RUB) rate = 90;

        // Any unsupported currency would case this exception
        if (rate == 0) {
            throw new IllegalArgumentException("Unsupported exchange pair");
        }

        // Perform conversion
        this.balance = this.balance * rate;
        this.currency = to;
    }

}