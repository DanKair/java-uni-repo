package BankTransactionSystem;

public class Transaction implements Runnable{
    private BankAccount account;
    private String clientName;
    private String operation; // "deposit" or "withdraw"
    private double amount;
    // private Currency currency;

    // Default Constructor
    public Transaction(){
        this.amount = 0;
        // this.currency = Currency.KZT;
    }

    // Parametrized Constructor
    public Transaction(BankAccount account, String clientName, String operation, double amount, Currency currency) {
        this.account = account;
        this.clientName = clientName;
        this.operation = operation.toLowerCase();
        this.amount = amount;
        // this.currency = currency;
    }

    @Override
    public void run() {
        try {
            switch (operation) {
                // Handle Deposit Operation
                case "deposit":
                    account.deposit(amount);
                    System.out.printf("[Client: %s] Deposited %.2f. Current balance: %.2f%n",
                            clientName, amount, account.getBalance());
                    break;

                // Handle Withdraw operation
                case "withdraw":
                    account.withdraw(amount);
                    System.out.printf("[Client: %s] Withdrew %.2f. Current balance: %.2f%n",
                            clientName, amount, account.getBalance());
                    break;

                default:
                    System.out.println("Unknown operation for client " + clientName);
            }

        } catch (IllegalArgumentException e) {
            System.out.printf("[Client: %s] Transaction failed (%s %.2f). Reason: %s%n",
                    clientName, operation, amount, e.getMessage());
            e.printStackTrace();
        }
    }
}
