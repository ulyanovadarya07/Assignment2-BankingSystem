public class BankSystem {
    AccountLinkedList accounts = new AccountLinkedList();

    TransactionStack transactionHistory = new TransactionStack();

    BillQueue billQueue = new BillQueue();

    AccountRequestQueue accountRequests = new AccountRequestQueue();


    // Task 1 - Add account
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Task 1 - Display accounts
    public void displayAccounts() {
        accounts.display();
    }

    // Task 1 - Search by username
    public BankAccount searchAccountByUsername(String username) {
        return accounts.searchByUsername(username);
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
        String last = transactionHistory.peek();

        if (last == null) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Last transaction: " + last);
        }
    }

    // Task 3 - Undo last transaction
    public void undoLastTransaction() {
        String removed = transactionHistory.pop();

        if (removed == null) {
            System.out.println("No transactions to undo.");
        } else {
            System.out.println("Undo -> " + removed + " removed");
        }
    }


    // Task 4 - Add bill payment
    public void addBillPayment(String billName) {
        billQueue.enqueue(billName);
        transactionHistory.push("Bill payment added: " + billName);
        System.out.println("Added: " + billName);
    }

    // Task 4 - Process next bill payment
    public void processNextBillPayment() {
        String bill = billQueue.dequeue();

        if (bill == null) {
            System.out.println("No bill payments in queue.");
        } else {
            System.out.println("Processing: " + bill);
        }
    }

    // Task 4 - Display bill queue
    public void displayBillQueue() {
        billQueue.display();
    }


    // Task 5 - Submit account request
    public void submitAccountRequest(AccountRequest request) {
        accountRequests.enqueue(request);
        System.out.println("Account opening request submitted.");
    }

    // Task 5 - Process next account request
    public void processNextAccountRequest() {
        AccountRequest request = accountRequests.dequeue();

        if (request == null) {
            System.out.println("No account requests in queue.");
        } else {
            BankAccount newAccount = new BankAccount(
                    request.getAccountNumber(),
                    request.getUsername(),
                    request.getInitialBalance()
            );

            accounts.add(newAccount);
            System.out.println("Request processed. Account created for " + request.getUsername());
        }
    }

    // Task 5 - Display pending account requests
    public void displayPendingRequests() {
        accountRequests.display();
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
        for (int i = 0; i < arrayAccounts.length; i++) {
            System.out.println(arrayAccounts[i]);
        }
    }
}