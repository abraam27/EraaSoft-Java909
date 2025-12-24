package services;
import java.util.Scanner;

import model.Account;
import model.Wallet;

import java.util.Map;

public class AdminService {
    private Wallet wallet;
    private Scanner scanner;

    public AdminService(Wallet wallet, Scanner scanner) {
        this.wallet = wallet;
        this.scanner = scanner;
    }

    public void showAdminPanel() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         ADMIN PANEL                ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. View All Accounts");
        System.out.println("2. Delete Account");
        System.out.println("3. Activate/Deactivate Account");
        System.out.println("4. Back");
        System.out.print("Choose an option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    viewAllAccounts();
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    toggleAccountStatus();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void viewAllAccounts() {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("ALL ACCOUNTS");
        System.out.println("═══════════════════════════════════");

        Map<String, Account> accounts = wallet.getAllAccounts();
        for (Account acc : accounts.values()) {
            System.out.printf("User: %s | Phone: %s | Balance: $%.2f | Status: %s | Admin: %s\n",
                    acc.getUsername(), acc.getPhoneNumber(), acc.getBalance(),
                    (acc.isActive() ? "Active" : "Inactive"),
                    (acc.isAdmin() ? "Yes" : "No"));
        }
    }

    private void toggleAccountStatus() {
        System.out.print("Enter username to activate/deactivate: ");
        String username = scanner.nextLine().trim();

        Account account = wallet.getAccount(username);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (account.isAdmin()) {
            System.out.println("Cannot deactivate admin accounts.");
            return;
        }

        account.setActive(!account.isActive());
        System.out.println("Account " + username + " is now " + 
                          (account.isActive() ? "active" : "inactive"));
    }

    public boolean deleteAccount() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        DELETE ACCOUNT              ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            System.out.print("Enter username to delete: ");
            String username = scanner.nextLine().trim();
            Account account = wallet.getAccount(username);
            if (account == null) {
                System.out.println("Account not found.");
                return false;
            }

            System.out.print("Are you sure you want to delete this account? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("yes")) {
                wallet.deleteAccount(username);
                System.out.println("Account deleted successfully. Goodbye!");
                return true;
            } else {
                System.out.println("Account deletion cancelled.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
        return false;
    }
}