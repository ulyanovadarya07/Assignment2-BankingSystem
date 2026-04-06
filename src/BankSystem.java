import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BankSystem {
    LinkedList<BankAccount> accounts = new LinkedList<>();
    Stack<String> transactionHistory = new Stack<>();
    Queue<String> billQueue = new LinkedList<>();
    Queue<AccountRequest> accountRequests = new LinkedList<>();

    // Task 1 - Add account
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Task 1 - Display accounts
    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("Accounts List:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }
    }

    // Task 1 - Search by username
    public BankAccount searchAccountByUsername(String username) {
        for (BankAccount account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    // Task 2 - Deposit
    public void depositMoney(String username, double amount) {
        BankAccount account = searchAccountByUsername(username);
        if (account != null) {
            account.deposit(amount);
            transactionHistory.push("Deposit " + amount + " to " + username);
            System.out.println("New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Task 2 - Withdraw
    public void withdrawMoney(String username, double amount) {
        BankAccount account = searchAccountByUsername(username);
        if (account != null) {
            double oldBalance = account.getBalance();
            account.withdraw(amount);

            if (account.getBalance() != oldBalance) {
                transactionHistory.push("Withdraw " + amount + " from " + username);
                System.out.println("New balance: " + account.getBalance());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Task 3 - Show last transaction
    public void showLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            System.out.println("Last transaction: " + transactionHistory.peek());
        } else {
            System.out.println("No transactions found.");
        }
    }

    // Task 3 - Undo last transaction
    public void undoLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            System.out.println("Undo -> " + transactionHistory.pop() + " removed");
        } else {
            System.out.println("No transactions to undo.");
        }
    }

    // Task 4 - Add bill payment
    public void addBillPayment(String billName) {
        billQueue.add(billName);
        transactionHistory.push("Bill payment added: " + billName);
        System.out.println("Added: " + billName);
    }

    // Task 4 - Process next bill payment
    public void processNextBillPayment() {
        if (!billQueue.isEmpty()) {
            String bill = billQueue.poll();
            System.out.println("Processing: " + bill);
        } else {
            System.out.println("No bill payments in queue.");
        }
    }

    // Task 4 - Display bill queue
    public void displayBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
        } else {
            System.out.println("Bill Queue:");
            for (String bill : billQueue) {
                System.out.println(bill);
            }
        }
    }

    // Task 5 - Submit account request
    public void submitAccountRequest(AccountRequest request) {
        accountRequests.add(request);
        System.out.println("Account opening request submitted.");
    }

    // Task 5 - Process next account request
    public void processNextAccountRequest() {
        if (!accountRequests.isEmpty()) {
            AccountRequest request = accountRequests.poll();
            BankAccount newAccount = new BankAccount(
                    request.getAccountNumber(),
                    request.getUsername(),
                    request.getInitialBalance()
            );
            accounts.add(newAccount);
            System.out.println("Request processed. Account created for " + request.getUsername());
        } else {
            System.out.println("No account requests in queue.");
        }
    }

    // Task 5 - Display pending account requests
    public void displayPendingRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
        } else {
            System.out.println("Pending Account Requests:");
            for (AccountRequest request : accountRequests) {
                System.out.println(request);
            }
        }
    }

    // ATM - Balance enquiry
    public void checkBalance(String username) {
        BankAccount account = searchAccountByUsername(username);
        if (account != null) {
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Task 6 - Array of 3 predefined accounts
    public void showArrayAccounts() {
        BankAccount[] arrayAccounts = new BankAccount[3];

        arrayAccounts[0] = new BankAccount("A101", "Ali", 150000);
        arrayAccounts[1] = new BankAccount("A102", "Sara", 220000);
        arrayAccounts[2] = new BankAccount("A103", "Dana", 50000);

        System.out.println("Predefined Array Accounts:");
        for (BankAccount account : arrayAccounts) {
            System.out.println(account);
        }
    }
}
