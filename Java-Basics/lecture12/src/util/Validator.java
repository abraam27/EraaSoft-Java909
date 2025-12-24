package util;

import model.Account;
import model.Wallet;

public class Validator {
    private Wallet wallet;

    public Validator(Wallet wallet) {
        this.wallet = wallet;
    }

    public boolean validateUsername(String username) {
        if (username.length() < 3 || username.length() > 20) {
            System.out.println("Username must be 3-20 characters long.");
            return false;
        }
        if (!Character.isUpperCase(username.charAt(0))) {
            System.out.println("Username must start with an uppercase letter.");
            return false;
        }
        if (wallet.usernameExists(username)) {
            System.out.println("Username already exists. Please choose another.");
            return false;
        }
        return true;
    }

    public boolean validatePassword(String password) {
        if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters long.");
            return false;
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        if (!hasUpper || !hasLower || !hasDigit) {
            System.out.println("Password must contain at least 1 uppercase, 1 lowercase, and 1 digit.");
            return false;
        }
        return true;
    }

    public boolean validateAge(int age) {
        if (age < 18) {
            System.out.println("You must be at least 18 years old to sign up.");
            return false;
        }
        return true;
    }

    public boolean validatePhone(String phone) {
        if (phone.length() != 11) {
            System.out.println("Phone number must be exactly 11 digits.");
            return false;
        }
        if (!phone.startsWith("01")) {
            System.out.println("Phone number must start with '01' (Egypt format).");
            return false;
        }
        if (!phone.matches("\\d+")) {
            System.out.println("Phone number must contain only digits.");
            return false;
        }
        if (wallet.phoneExists(phone)) {
            System.out.println("Phone number already registered.");
            return false;
        }
        return true;
    }

    public boolean validateAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }
        return true;
    }

    public boolean validateSufficientBalance(Account account, double amount) {
        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: $%.2f\n", account.getBalance());
            return false;
        }
        return true;
    }
}