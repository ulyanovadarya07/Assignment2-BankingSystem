import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        // Initial demo accounts
        bankSystem.addAccount(new BankAccount("B001", "Ali", 150000));
        bankSystem.addAccount(new BankAccount("B002", "Sara", 220000));

        int mainChoice;

        do {
            System.out.println("===== MINI BANKING MENU =====");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Show predefined accounts (Array)");
            System.out.println("5 - Exit");
            System.out.print("Choose: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1:
                    bankMenu(sc, bankSystem);
                    break;

                case 2:
                    atmMenu(sc, bankSystem);
                    break;

                case 3:
                    adminMenu(sc, bankSystem);
                    break;

                case 4:
                    bankSystem.showArrayAccounts(); // TASK 6
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (mainChoice != 5);

        sc.close();
    }

    public static void bankMenu(Scanner sc, BankSystem bankSystem) {
        int choice;

        do {
            System.out.println("===== BANK MENU =====");
            System.out.println("1 - Add new account directly");
            System.out.println("2 - Display all accounts");
            System.out.println("3 - Search account by username");
            System.out.println("4 - Deposit money");
            System.out.println("5 - Withdraw money");
            System.out.println("6 - Submit account opening request");
            System.out.println("7 - Add bill payment request");
            System.out.println("8 - Show last transaction");
            System.out.println("9 - Undo last transaction");
            System.out.println("10 - Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    bankSystem.addAccount(new BankAccount(accountNumber, username, balance));
                    System.out.println("Account added successfully.");
                    break;

                case 2:
                    bankSystem.displayAccounts();
                    break;

                case 3:
                    System.out.print("Enter username to search: ");
                    String searchUsername = sc.nextLine();
                    BankAccount found = bankSystem.searchAccountByUsername(searchUsername);

                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter username: ");
                    String depUser = sc.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depAmount = sc.nextDouble();
                    sc.nextLine();
                    bankSystem.depositMoney(depUser, depAmount);
                    break;

                case 5:
                    System.out.print("Enter username: ");
                    String withUser = sc.nextLine();
                    System.out.print("Enter withdraw amount: ");
                    double withAmount = sc.nextDouble();
                    sc.nextLine();
                    bankSystem.withdrawMoney(withUser, withAmount);
                    break;

                case 6:
                    System.out.print("Enter account number for request: ");
                    String reqAccNum = sc.nextLine();
                    System.out.print("Enter username for request: ");
                    String reqUser = sc.nextLine();
                    System.out.print("Enter initial balance for request: ");
                    double reqBalance = sc.nextDouble();
                    sc.nextLine();

                    bankSystem.submitAccountRequest(new AccountRequest(reqAccNum, reqUser, reqBalance));
                    break;

                case 7:
                    System.out.print("Enter bill name: ");
                    String billName = sc.nextLine();
                    bankSystem.addBillPayment(billName);
                    break;

                case 8:
                    bankSystem.showLastTransaction();
                    break;

                case 9:
                    bankSystem.undoLastTransaction();
                    break;

                case 10:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 10);
    }

    public static void atmMenu(Scanner sc, BankSystem bankSystem) {
        int choice;

        do {
            System.out.println("===== ATM MENU =====");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    bankSystem.checkBalance(user);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String withdrawUser = sc.nextLine();
                    System.out.print("Enter withdraw amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    bankSystem.withdrawMoney(withdrawUser, amount);
                    break;

                case 3:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    public static void adminMenu(Scanner sc, BankSystem bankSystem) {
        int choice;

        do {
            System.out.println("===== ADMIN MENU =====");
            System.out.println("1 - View pending account requests");
            System.out.println("2 - Process next account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill payment");
            System.out.println("5 - Display all accounts");
            System.out.println("6 - Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bankSystem.displayPendingRequests();
                    break;

                case 2:
                    bankSystem.processNextAccountRequest();
                    break;

                case 3:
                    bankSystem.displayBillQueue();
                    break;

                case 4:
                    bankSystem.processNextBillPayment();
                    break;

                case 5:
                    bankSystem.displayAccounts();
                    break;

                case 6:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}