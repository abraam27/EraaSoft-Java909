import java.util.Scanner;

import services.AuthService;

import model.Wallet;
import model.Account;

public class EWalletSystem {
    private static Wallet wallet;
    private static Scanner scanner;
    private static Account currentUser;
    
    private static AuthService authService;

    public static void main(String[] args) {
        // Initialize
        wallet = new Wallet();
        scanner = new Scanner(System.in);
        
        authService = new AuthService(wallet, scanner);

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   Welcome to E-Wallet System       ║");
        System.out.println("╚════════════════════════════════════╝");

        while (true) {
            try {
                if (currentUser == null) {
                    showMainMenu();
                } else {
                    showUserMenu();
                    break;
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
        System.out.println("\n welcome to the user menu");
    }
}