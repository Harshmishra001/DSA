public class RemoveNthNodeFromEndOfLL {
    // Define Node class
    static class Node {
        int data;
        Node next;

        Node(int d) { 
            data = d; 
            next = null;
        }
    }

    // Method to remove the nth node from the end
    public Node removeNthFromEnd(Node head, int n) {
        int count = 0;
        Node tmp = head;

        // Count the total number of nodes
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        // Find the position to remove
        int steps = count - n;

        // If we need to remove the head node  agr n=5 hua or size hi 5 h ll ka mtlb piche s cout krenge 5 tk mtlb 1st node remove krna h
        if (steps == 0) {
            return head.next;
        }

        tmp = head;
        for (int i = 1; i < steps; i++) {
            tmp = tmp.next;
        }

        // Remove the target node
        tmp.next = tmp.next.next;

        return head;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Call the removeNthFromEnd method to remove the 2nd node from the end
        RemoveNthNodeFromEndOfLL solution = new RemoveNthNodeFromEndOfLL();
        head = solution.removeNthFromEnd(head, 2);

        // Print the updated linked list
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }
}
