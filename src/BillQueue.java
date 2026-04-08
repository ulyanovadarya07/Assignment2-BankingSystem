public class BillQueue {
    private static class Node {
        String billName;
        Node next;

        Node(String billName) {
            this.billName = billName;
        }
    }

    private Node front;
    private Node rear;

    public void enqueue(String billName) {
        Node newNode = new Node(billName);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (front == null) {
            return null;
        }

        String value = front.billName;
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
            System.out.println("Bill queue is empty.");
            return;
        }

        Node current = front;
        System.out.println("Bill Queue:");
        while (current != null) {
            System.out.println(current.billName);
            current = current.next;
        }
    }
}
