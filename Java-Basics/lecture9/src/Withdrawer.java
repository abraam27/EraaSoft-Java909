// Withdrawer Thread - takes money from the account
class Withdrawer implements Runnable {
    private BankAccount account;
    private int withdrawAmount;
    private int numberOfWithdrawals;
    
    public Withdrawer(BankAccount account, int withdrawAmount, int numberOfWithdrawals) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
        this.numberOfWithdrawals = numberOfWithdrawals;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < numberOfWithdrawals; i++) {
            try {
                Thread.sleep(2000); // Wait 2 seconds between withdrawals
                account.withdraw(withdrawAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Withdrawer finished all withdrawals!");
    }
}