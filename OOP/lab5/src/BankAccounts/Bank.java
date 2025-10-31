package BankAccounts;

import java.util.ArrayList;
import java.util.List;

public class Bank <T extends Account>{
    // Account Storage List
    List<T> accounts;

    public Bank(){
        this.accounts = new ArrayList<>();
    }

    public void addAccount(T account){
        this.accounts.add(account);
    }

    // Show Each Account info and Display the sum of all stored accounts balance
    public void showAccountsInfo(){
        double sumOfBalance = 0;
        for (Account account: accounts){
            sumOfBalance += account.getBalance();
            System.out.println(account.toString());
        }
        System.out.println("Total Balance in All Accounts: " + sumOfBalance);
    }


}
