package services;
import java.util.Scanner;

import model.Account;
import util.Validator;
import model.Wallet;

public class AuthService {
    private Wallet wallet;
    private Validator validator;
    private Scanner scanner;

    public AuthService(Wallet wallet, Scanner scanner) {
        this.wallet = wallet;
        this.scanner = scanner;
        this.validator = new Validator(wallet);
    }

    public Account signUp() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           SIGN UP                  ║");
        System.out.println("╚════════════════════════════════════╝");

        try {
            // Username validation
            System.out.print("Enter username (first letter uppercase, 3-20 chars): ");
            String username = scanner.nextLine().trim();
            if (!validator.validateUsername(username)) {
                return null;
            }

            // Password validation
            System.out.print("Enter password (min 6 chars, at least 1 uppercase, 1 lowercase, 1 digit): ");
            String password = scanner.nextLine().trim();
            if (!validator.validatePassword(password)) {
                return null;
            }

            // Age validation
            System.out.print("Enter age (must be >= 18): ");
            int age;
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (!validator.validateAge(age)) {
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Please enter a valid number.");
                return null;
            }

            // Phone validation
            System.out.print("Enter phone number (Egypt format: 01XXXXXXXXX): ");
            String phone = scanner.nextLine().trim();
            if (!validator.validatePhone(phone)) {
                return null;
            }

            // Create account
            Account newAccount = new Account(username, password, age, phone);
            wallet.addAccount(newAccount);

            System.out.println("\nAccount created successfully!");
            System.out.println("Welcome, " + username + "!");
            
            return newAccount;

        } catch (Exception e) {
            System.out.println("Error during sign up: " + e.getMessage());
            return null;
        }
    }
}