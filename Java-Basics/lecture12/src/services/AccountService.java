package services;
import java.util.Scanner;

import model.Wallet;
import model.Account;
import util.Validator;
import java.util.List;

public class AccountService {
    private Wallet wallet;
    private Validator validator;
    private Scanner scanner;

    public AccountService(Wallet wallet, Scanner scanner) {
        this.wallet = wallet;
        this.scanner = scanner;
        this.validator = new Validator(wallet);
    }

    public void showAccountDetails(Account account) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       ACCOUNT DETAILS              ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            Account acc = wallet.getAccount(account.getUsername());
            System.out.println("Username: " + acc.getUsername());
            System.out.println("Phone: " + acc.getPhoneNumber());
            System.out.println("Age: " + acc.getAge());
            System.out.printf("Balance: EGP %.2f\n", acc.getBalance());
            System.out.println("Status: " + (acc.isActive() ? "Active" : "Inactive"));
            System.out.println("Password: " + "*".repeat(acc.getPassword().length()));
        } catch (Exception e) {
            System.out.println("Error displaying account details: " + e.getMessage());
        }
    }

    public void changePassword(Account account) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        CHANGE PASSWORD             ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            System.out.print("Enter old password: ");
            String oldPassword = scanner.nextLine().trim();

            if (!account.getPassword().equals(oldPassword)) {
                System.out.println("Old password is incorrect.");
                return;
            }

            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine().trim();

            if (!validator.validatePassword(newPassword)) {
                return;
            }

            if (oldPassword.equals(newPassword)) {
                System.out.println("New password cannot be the same as old password.");
                return;
            }

            account.setPassword(newPassword);
            account.addTransaction("Password changed");
            System.out.println("Password changed successfully!");

        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
        }
    }

    public void showTransactionHistory(Account account) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║     TRANSACTION HISTORY            ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            List<String> history = account.getTransactionHistory();
            if (history.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                for (String transaction : history) {
                    System.out.println(transaction);
                }
            }
        } catch (Exception e) {
            System.out.println("Error displaying history: " + e.getMessage());
        }
    }

    
}