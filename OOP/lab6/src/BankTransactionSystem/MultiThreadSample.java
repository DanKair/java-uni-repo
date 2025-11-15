package BankTransactionSystem;

public class MultiThreadSample extends Thread{
    // Multi-Threading Implementation by extending Thread class and overriding run() method
    private int threadNumber; // Tracks threadNumbers

    // Default constructor as threadNumber zero
    public MultiThreadSample(){
        this.threadNumber = 0;
    }

    // Constructor with threadNumber as parameter
    public MultiThreadSample(int threadNumber){
        this.threadNumber = threadNumber;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " printing: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }



    public static void main(String[] args) {
        // Multi-Threading Implementation by extending Thread class and overriding run() method to call start() method from objects
        MultiThreadSample thread1 = new MultiThreadSample(1);
        MultiThreadSample thread2 = new MultiThreadSample(2);

        // Works Synchronizely (Each after one)
        // thread1.run();
        // thread2.run();

        // Actual Multi-threading
        thread1.start();
        thread2.start();

//        for (int i = 1; i <= 3; i++){
//            MultiThreadSample newThread = new MultiThreadSample(i);
//            newThread.start();
//        }
        //threadsRunLoop(5);




    }

    public static void threadsRunLoop(int n){
        // Runs Loop till the N number
        for (int i = 0; i <= n; i++){
            MultiThreadSample iterationThread = new MultiThreadSample(i);
            iterationThread.start();
        }
    }
}
