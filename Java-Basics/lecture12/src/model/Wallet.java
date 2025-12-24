package model;

import java.util.*;

public class Wallet {
    private Map<String, Account> accounts;

    public Wallet() {
        accounts = new HashMap<>();
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
}