// Task 3: Thread Sleep - Print numbers 1 to 5 with 1-second delay
class NumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        System.out.println("\n========== Task 3: Thread Sleep (Numbers 1-5) ==========");
        
        Thread numberThread = new Thread(new NumberPrinter(), "NumberPrinter");
        numberThread.start();
        
        try {
            numberThread.join(); // Wait for the thread to complete
            System.out.println("\nNumber printing completed!\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
