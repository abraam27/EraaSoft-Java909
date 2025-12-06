class BankAccount {
    private int balance;
    
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }
    
    // Deposit money into the account
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + " | New Balance: $" + balance + " [" + Thread.currentThread().getName() + "]");
            
        // Notify waiting threads that money has been deposited
        notify();
    }
    
    // Withdraw money from the account
    public synchronized void withdraw(int amount) {
        // Wait while balance is insufficient
        while (balance < amount) {
            System.out.println("Insufficient balance ($" + balance + ") for withdrawal of $" + amount + ". Waiting... [" + Thread.currentThread().getName() + "]");
            try {
                wait(); // wait for deposit
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted while waiting: " + e.getMessage());
                return;
            }
        }
            
        // Sufficient balance - perform withdrawal
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + " | Remaining Balance: $" + balance + " [" + Thread.currentThread().getName() + "]");
    }
    
    public synchronized int getBalance() {
        return balance;
    }
}