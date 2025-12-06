// Task 5: BankAccount class with synchronized methods and wait/notify
public class Task5 {
    public static void main(String[] args) {
        System.out.println("\n========== Task 5: Bank Account with Wait/Notify ==========");
        System.out.println("This demonstrates thread synchronization with wait() and notify()\n");

        // Create a bank account with initial balance of $100
        BankAccount account = new BankAccount(100);
        System.out.println("Initial Balance: $" + account.getBalance() + "\n");

        // Create Depositor thread: deposits $150, 8 times
        Thread depositorThread = new Thread(
                new Depositor(account, 150, 8),
                "Depositor-Thread");

        // Create Withdrawer thread: withdraws $200, 4 times
        Thread withdrawerThread = new Thread(
                new Withdrawer(account, 200, 4),
                "Withdrawer-Thread");

        // Start both threads
        depositorThread.start();
        withdrawerThread.start();

        try {
            // Wait for both threads to complete
            depositorThread.join();
            withdrawerThread.join();

            System.out.println("\n" + "=".repeat(60));
            System.out.println("All transactions completed!");
            System.out.println("Final Balance: $" + account.getBalance());
            System.out.println("=".repeat(60) + "\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
