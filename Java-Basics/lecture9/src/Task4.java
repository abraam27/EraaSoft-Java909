// Task 4: Thread Join - Worker threads for demonstrating join
class Worker implements Runnable {
    private String name;
    
    public Worker(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        System.out.println(name + " started working...");
        try {
            Thread.sleep(2000); // Simulate work for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished working!");
    }
}

public class Task4 {
    public static void main(String[] args) {
        System.out.println("\n========== Task 4: Thread Join ==========");
        
        Thread worker1 = new Thread(new Worker("Worker-1"), "Worker-Thread-1");
        Thread worker2 = new Thread(new Worker("Worker-2"), "Worker-Thread-2");
        
        System.out.println("Main thread: Starting workers...");
        
        worker1.start();
        worker2.start();
        
        try {
            System.out.println("Main thread: Waiting for workers to finish using join()...");
            
            worker1.join(); // Main thread waits for worker1 to finish
            worker2.join(); // Main thread waits for worker2 to finish
            
            System.out.println("\nMain thread: All workers have finished!");
            System.out.println("Main thread: Now I can continue my work.\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
