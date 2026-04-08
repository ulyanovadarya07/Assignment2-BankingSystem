public class AccountLinkedList {
    private static class Node {
        BankAccount account;
        Node next;

        Node(BankAccount account) {
            this.account = account;
        }
    }

    private Node head;

    public void add(BankAccount account) {
        Node newNode = new Node(account);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("No accounts found.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.account);
            current = current.next;
        }
    }

    public BankAccount searchByUsername(String username) {
        Node current = head;

        while (current != null) {
            if (current.account.getUsername().equalsIgnoreCase(username)) {
                return current.account;
            }
            current = current.next;
        }

        return null;
    }
}
