public class BankAccount {
    private String accountNumber;
    private String username;
    private double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Username: " + username +
                ", Balance: " + balance;
    }
}