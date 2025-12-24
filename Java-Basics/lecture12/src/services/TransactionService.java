package services;
import java.util.Scanner;

import model.Account;
import util.Validator;
import model.Wallet;

public class TransactionService {
    private Wallet wallet;
    private Validator validator;
    private Scanner scanner;

    public TransactionService(Wallet wallet, Scanner scanner) {
        this.wallet = wallet;
        this.scanner = scanner;
        this.validator = new Validator(wallet);
    }

    public void deposit(Account account) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           DEPOSIT                  ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            System.out.print("Enter amount to deposit: EGP ");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            if (!validator.validateAmount(amount)) {
                return;
            }

            account.deposit(amount);
            System.out.println("Deposit successful!");
            System.out.printf("New balance: EGP %.2f\n", account.getBalance());

        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    public void withdraw(Account account) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           WITHDRAW                 ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            System.out.print("Enter amount to withdraw: EGP ");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            if (!validator.validateAmount(amount)) {
                return;
            }

            if (!validator.validateSufficientBalance(account, amount)) {
                return;
            }

            account.withdraw(amount);
            System.out.println("Withdrawal successful!");
            System.out.printf("New balance: EGP %.2f\n", account.getBalance());

        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
        } catch (Exception e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }
    }
}