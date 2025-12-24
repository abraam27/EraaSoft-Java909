package services;
import java.util.Scanner;

import model.Wallet;
import model.Account;
import util.Validator;

public class AccountService {
    private Wallet wallet;
    private Validator validator;
    private Scanner scanner;

    public AccountService(Wallet wallet, Scanner scanner) {
        this.wallet = wallet;
        this.scanner = scanner;
        this.validator = new Validator(wallet);
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
            System.out.println("Password changed successfully!");

        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
        }
    }
}