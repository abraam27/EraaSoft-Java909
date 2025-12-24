package model;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String username;
    private String password;
    private int age;
    private String phoneNumber;
    private double balance;
    private boolean isAdmin;
    private boolean isActive;
    private List<String> transactionHistory;

    public Account(String username, String password, int age, String phoneNumber, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
        this.isAdmin = isAdmin;
        this.isActive = true;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created");
    }

    // Getters
    public String getUsername() { 
        return username; 
    }
    
    public String getPassword() { 
        return password; 
    }
    
    public int getAge() { 
        return age; 
    }
    
    public String getPhoneNumber() { 
        return phoneNumber; 
    }
    
    public double getBalance() { 
        return balance; 
    }
    
    public boolean isAdmin() { 
        return isAdmin; 
    }
    
    public boolean isActive() { 
        return isActive; 
    }
    
    public List<String> getTransactionHistory() { 
        return transactionHistory; 
    }

    // Setters
    public void setPassword(String password) { 
        this.password = password; 
    }
    
    public void setActive(boolean active) { 
        isActive = active; 
    }

    // Balance operations
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void addTransaction(String transaction) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transactionHistory.add("[" + timestamp + "] " + transaction);
    }
}