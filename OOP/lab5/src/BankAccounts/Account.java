package BankAccounts;

abstract class Account {
    private String ownerName;
    private double balance;
    private String accountType;

    // Parametrized Constructor
    public Account(String owner, double balance, String accountType){
        this.ownerName = owner;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Getters methods
    public double getBalance(){
        return this.balance;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public String getAccountType(){
        return this.accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
