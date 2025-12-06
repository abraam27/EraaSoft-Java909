// Task 2: Class implementing Runnable
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName() +
                " - Hello from Runnable!");
    }
}

public class Task2 {
    public static void main(String[] args) {
        System.out.println("\n========== Task 2: Runnable Interface ==========");
        
        MyRunnable runnable = new MyRunnable();
        
        Thread thread1 = new Thread(runnable, "Runnable-Thread-1");
        Thread thread2 = new Thread(runnable, "Runnable-Thread-2");
        Thread thread3 = new Thread(runnable, "Runnable-Thread-3");
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        System.out.println("Main thread continues with Runnable demo...\n");
    }
}
