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
            Account newAccount = new Account(username, password, age, phone, false);
            wallet.addAccount(newAccount);

            System.out.println("\nAccount created successfully!");
            System.out.println("Welcome, " + username + "!");
            
            return newAccount;

        } catch (Exception e) {
            System.out.println("Error during sign up: " + e.getMessage());
            return null;
        }
    }

    public Account login() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           LOGIN                    ║");
        System.out.println("╚════════════════════════════════════╝");

        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            try {
                System.out.print("Enter username: ");
                String username = scanner.nextLine().trim();
                if (username.isEmpty()) {
                    System.out.println("Username cannot be empty.");
                    attempts++;
                    continue;
                }

                System.out.print("Enter password: ");
                String password = scanner.nextLine().trim();
                if (password.isEmpty()) {
                    System.out.println("Password cannot be empty.");
                    attempts++;
                    continue;
                }

                Account account = wallet.getAccount(username);
                if (account == null) {
                    System.out.println("User does not exist.");
                    attempts++;
                } else if (!account.isActive()) {
                    System.out.println("Account is inactive. Please contact support.");
                    return null;
                } else if (!account.getPassword().equals(password)) {
                    System.out.println("Incorrect password.");
                    attempts++;
                } else {
                    account.addTransaction("Logged in");
                    System.out.println("\nLogin successful! Welcome back, " + username + "!");
                    return account;
                }

                if (attempts < maxAttempts) {
                    System.out.println("Remaining attempts: " + (maxAttempts - attempts));
                }
            } catch (Exception e) {
                System.out.println("Error during login: " + e.getMessage());
                attempts++;
            }
        }

        System.out.println("Maximum login attempts exceeded. Returning to main menu.");
        return null;
    }
}