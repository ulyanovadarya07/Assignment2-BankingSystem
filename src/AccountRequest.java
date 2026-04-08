public class AccountRequest {
    private String accountNumber;
    private String username;
    private double initialBalance;

    public AccountRequest(String accountNumber, String username, double initialBalance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.initialBalance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    @Override
    public String toString() {
        return "Request -> Account Number: " + accountNumber +
                ", Username: " + username +
                ", Initial Balance: " + initialBalance;
    }
}