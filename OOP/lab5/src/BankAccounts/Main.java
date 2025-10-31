package BankAccounts;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creating Bank<Account> object
        Bank bank = new Bank<>();
        DepositAccount depAcc1 = new DepositAccount("John", 1_000_000);
        TransitAccount transitAcc1 = new TransitAccount("Josh", 50_000);
        ClosedAccount closedAcc1 = new ClosedAccount("Jane", 1_000);
        bank.addAccount(depAcc1);
        bank.addAccount(transitAcc1);
        bank.addAccount(closedAcc1);
        System.out.println(bank.accounts);
        bank.showAccountsInfo();


    }
}