import java.util.*;

class CycleDetectionStartingPoint {
    // Inner class to define the structure of a linked list node
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Brute Force Approach - Uses HashMap to store visited nodes (O(n) time, O(n) space)
    public static Node firstNode(Node head) {
        Map<Node, Integer> mpp = new HashMap<>();
        Node temp = head;
        
        while (temp != null) {
            if (mpp.containsKey(temp)) 
                return temp; // Cycle detected, return the starting node
            mpp.put(temp, 1);
            temp = temp.next;
        }
        
        return null; // No cycle detected
    }

    // Optimal Approach - Floyd’s Cycle Detection Algorithm (O(n) time, O(1) space)
    public static Node firstNode2(Node head) {
        Node slow = head, fast = head;

        // Phase 1: Detect the cycle using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow one step
            fast = fast.next.next; // Move fast two steps

            if (slow == fast) { // Cycle detected
                slow = head; // Reset slow to head
                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Start of the loop
            }
        }
        return null; // No cycle detected
    }
    public static void main(String[] args) {
        // Creating the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a cycle: connecting node5 to node2
        head.next.next.next.next.next = head.next;

        // Detect the loop using both methods
        Node loopStartNode = firstNode(head.next);  // Brute Force Approach
        Node loopStartNode2 = firstNode2(head.next); // Floyd’s Cycle Detection Algorithm

        // Printing the result
        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }

        if (loopStartNode2 != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode2.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
