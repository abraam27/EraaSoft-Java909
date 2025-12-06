// Depositor Thread - adds money to the account
class Depositor implements Runnable {
    private BankAccount account;
    private int depositAmount;
    private int numberOfDeposits;
    
    public Depositor(BankAccount account, int depositAmount, int numberOfDeposits) {
        this.account = account;
        this.depositAmount = depositAmount;
        this.numberOfDeposits = numberOfDeposits;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < numberOfDeposits; i++) {
            try {
                Thread.sleep(1500); // Wait 1.5 seconds between deposits
                account.deposit(depositAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Depositor finished all deposits!");
    }
}