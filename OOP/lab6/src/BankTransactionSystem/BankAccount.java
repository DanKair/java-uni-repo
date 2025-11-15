package BankTransactionSystem;

public class BankAccount {
    private double balance;

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

    public  double getBalance() {
        // Synchronizing only code inside "synchronized" block
        synchronized (this){
            return this.balance;
        }
    }
}
