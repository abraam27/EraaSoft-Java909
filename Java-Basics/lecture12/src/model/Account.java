package model;

public class Account {
    private String username;
    private String password;
    private int age;
    private String phoneNumber;
    private double balance;
    private boolean isActive;

    public Account(String username, String password, int age, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
        this.isActive = true;
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
    
    public boolean isActive() { 
        return isActive; 
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
}