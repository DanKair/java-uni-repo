package BankAccounts;

public class ClosedAccount extends Account{

    public ClosedAccount(String owner, double balance){
        super(owner, balance, "Closed");
    }
}
