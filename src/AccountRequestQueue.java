public class AccountRequestQueue {
    private static class Node {
        AccountRequest request;
        Node next;

        Node(AccountRequest request) {
            this.request = request;
        }
    }

    private Node front;
    private Node rear;

    public void enqueue(AccountRequest request) {
        Node newNode = new Node(request);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public AccountRequest dequeue() {
        if (front == null) {
            return null;
        }

        AccountRequest value = front.request;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (front == null) {
            System.out.println("No pending account requests.");
            return;
        }

        Node current = front;
        System.out.println("Pending Account Requests:");
        while (current != null) {
            System.out.println(current.request);
            current = current.next;
        }
    }
}
