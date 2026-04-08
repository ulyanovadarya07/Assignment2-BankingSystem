public class TransactionStack {
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }

        String value = top.data;
        top = top.next;
        return value;
    }

    public String peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (top == null) {
            System.out.println("Transaction history is empty.");
            return;
        }

        Node current = top;
        System.out.println("Transaction History:");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
