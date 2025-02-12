import java.util.*;

public class DetectCycleInLL {

    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to detect cycle in a linked list
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(14);
        head.next.next.next.next.next.next.next = new Node(16);

        // Creating a cycle for testing
        head.next.next.next.next.next.next.next.next = head.next.next;

        System.out.println("Cycle detected: " + detectCycle(head));
    }
}