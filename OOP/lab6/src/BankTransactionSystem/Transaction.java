package BankTransactionSystem;

public class Transaction implements Runnable{
    private BankAccount account;
    private String clientName;
    private String operation; // "deposit" or "withdraw"
    private double amount;
    private Currency currency;
    private Currency fromCurrency;
    private Currency toCurrency;


    // Constructor for deposit / withdraw
    public Transaction(BankAccount account, String clientName, String operation, double amount) {
        this.account = account;
        this.clientName = clientName;
        this.operation = operation.toLowerCase();
        this.amount = amount;
    }

    // Constructor for currency exchange
    public Transaction(BankAccount account, String clientName, Currency from, Currency to) {
        this.account = account;
        this.clientName = clientName;
        this.operation = "exchange";
        this.fromCurrency = from;
        this.toCurrency = to;
    }

    // Constructor for open save account
    public Transaction(BankAccount account, String clientName, String operation) {
        this.account = account;
        this.clientName = clientName;
        this.operation = operation.toLowerCase();
    }

    // Default Constructor
    public Transaction(){
        this.amount = 0;
        this.currency = Currency.KZT;
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

                case "exchange":
                    account.currencyExchange(fromCurrency, toCurrency);
                    System.out.printf("[Client: %s] Exchanged %s → %s. New balance: %.2f %s%n",
                            clientName, fromCurrency, toCurrency, account.getBalance(), toCurrency);
                    break;

                case "open_save_account":
                    boolean ok = account.canOpenSaveAccount();
                    if (ok) {
                        System.out.printf("[Client: %s] Save account successfully opened!%n", clientName);
                    } else {
                        System.out.printf("[Client: %s] Cannot open save account — balance or currency insufficient.%n",
                                clientName);
                    }
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
