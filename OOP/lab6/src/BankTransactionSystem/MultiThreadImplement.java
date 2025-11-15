package BankTransactionSystem;

public class MultiThreadImplement implements Runnable{
    // Multi-Threading Implementation
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " printing: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MultiThreadImplement());
        Thread thread2 = new Thread(new MultiThreadImplement());
        thread1.start();
        thread2.start();
    }

}

