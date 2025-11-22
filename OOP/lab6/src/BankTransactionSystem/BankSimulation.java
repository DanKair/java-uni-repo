package BankTransactionSystem;

import java.util.*;
import java.util.concurrent.*;

public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double initialBalance = 0;
        try {
            System.out.println("Enter initial account balance:");
            initialBalance = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        BankAccount account = new BankAccount(initialBalance);

        // Manages Dynamic thread creation, but here it just create 3 Threads (3 Workers)
        ExecutorService service = Executors.newFixedThreadPool(3);

        // Deposit / Withdraw operation DEMO
        List<Transaction> list = Arrays.asList(
                new Transaction(account, "Rick", "deposit", 200),
                new Transaction(account, "Daryl", "withdraw", 150),
                new Transaction(account, "Carol", "withdraw", 500),
                new Transaction(account, "Maggie", "deposit", 300),
                new Transaction(account, "Jessie", "withdraw", 50),
                new Transaction(account, "Michonne", "deposit", 100)
        );

        for (Transaction t : list) {
            service.submit(t);
        }

        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll transactions completed.");
        System.out.println("Final balance: " + account.getBalance());
        //=========================================================================================================
        // Currency Exchange DEMO
        System.out.println("\n=== Currency Exchange Demo ===");

        // Let's say initial account currency = KZT
        // Convert KZT → USD
        Transaction exch1 = new Transaction(account, "John", Currency.KZT, Currency.USD);
        service = Executors.newFixedThreadPool(2); // new pool for next operations
        service.submit(exch1);

        // Convert USD → EURO
        Transaction exch2 = new Transaction(account, "Martin", Currency.USD, Currency.EURO);
        service.submit(exch2);

        // Convert EURO → RUB
        Transaction exch3 = new Transaction(account, "Shane", Currency.EURO, Currency.RUB);
        service.submit(exch3);

        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After currency exchanges, balance: " +
                account.getBalance() + " " + account.getCurrency());


//=========================================================================================================
        // Save Account Demo

        System.out.println("\n=== Save Account Demo ===");

        // Attempt to open saving account
        Transaction openSave = new Transaction(account, "Pete", "open_save_account");
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        service2.submit(openSave);

        service2.shutdown();
        try {
            service2.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance after all operations: " +
                account.getBalance() + " " + account.getCurrency());




    }
}
