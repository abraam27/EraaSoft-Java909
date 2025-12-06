// Task 1: Class extending Thread
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread");
    }
}

public class Task1 {
    public static void main(String[] args) {
        System.out.println("\n========== Task 1: Basic Thread Creation ==========");
        
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.setName("Thread-A");
        thread2.setName("Thread-B");
        
        thread1.start();
        thread2.start();
        
        System.out.println("Main thread continues execution...\n");
    }
}
