import java.util.Scanner;

import services.AccountService;
import services.AuthService;
import services.TransactionService;

import model.Wallet;
import model.Account;

public class EWalletSystem {
    private static Wallet wallet;
    private static Scanner scanner;
    private static Account currentUser;
    
    private static AuthService authService;
    private static TransactionService transactionService;
    private static AccountService accountService;

    public static void main(String[] args) {
        // Initialize
        wallet = new Wallet();
        scanner = new Scanner(System.in);
        
        authService = new AuthService(wallet, scanner);
        transactionService = new TransactionService(wallet, scanner);
        accountService = new AccountService(wallet, scanner);

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   Welcome to E-Wallet System       ║");
        System.out.println("╚════════════════════════════════════╝");

        while (true) {
            try {
                if (currentUser == null) {
                    showMainMenu();
                } else {
                    showUserMenu();
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("═══════════════════════════════════");
        System.out.print("Choose an option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    authService.signUp();
                    break;
                case 2:
                    currentUser = authService.login();
                    break;
                case 3:
                    System.out.println("\nThank you for using E-Wallet System!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void showUserMenu() {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Show Account Details");
        System.out.println("5. Change Password");
        System.out.println("6. Logout");
        System.out.println("═══════════════════════════════════");
        System.out.print("Choose an option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    transactionService.deposit(currentUser);
                    break;
                case 2:
                    transactionService.withdraw(currentUser);
                    break;
                case 3:
                    transactionService.transfer(currentUser);
                    break;
                case 4:
                    System.out.println("Show Account Details");
                    break;
                case 5:
                    accountService.changePassword(currentUser);
                    break;
                case 6:
                    System.out.println("Logout");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}