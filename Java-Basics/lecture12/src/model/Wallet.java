package model;

import java.util.*;

public class Wallet {
    private Map<String, Account> accounts;

    public Wallet() {
        accounts = new HashMap<>();
        initializeAdminAccount();
    }

    private void initializeAdminAccount() {
        Account admin = new Account("IAM", "IAM123", 25, "01000000000", true);
        accounts.put("IAM", admin);
    }

    public boolean usernameExists(String username) {
        return accounts.containsKey(username);
    }

    public boolean phoneExists(String phone) {
        return accounts.values()
                .stream()
                .anyMatch(account -> phone.equals(account.getPhoneNumber()));
    }

    public void addAccount(Account account) {
        accounts.put(account.getUsername(), account);
    }

    public Account getAccount(String username) {
        return accounts.get(username);
    }

    public Map<String, Account> getAllAccounts() {
        return accounts;
    }

    public void deleteAccount(String username) {
        Account account = accounts.get(username);
        if (account != null) {
            accounts.remove(username);
        }
    }
}