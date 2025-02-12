import java.util.*;

class CountNodesinDetectedLoop{
    // Node class for Linked List
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Brute Force Approach - Uses HashMap to detect loop (O(n) time, O(n) space)
    public static Node firstNode(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        
        while (temp != null) {
            if (map.containsKey(temp)) 
                return temp; // Cycle detected, return the starting node
            map.put(temp, 1);
            temp = temp.next;
        }
        return null; // No cycle detected
    }

    // Function to count the number of nodes in the loop using HashMap method
    public static int countNodesInLoop(Node head) {
        Node temp = firstNode(head);

        if (temp == null) return 0; // */ No loop detected

        int count = 1;
        Node temp2 = temp.next;
        
        while (temp != temp2) {
            count++;
            temp2 = temp2.next;
        }
        return count;
    }


    // Optimal Approach - Floyd’s Cycle Detection Algorithm (O(n) time, O(1) space)
    public static Node firstNode2(Node head) {
        Node slow = head, fast = head;

        // Phase 1: Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                slow = head;
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

    // Function to count the number of nodes in the loop using Floyd’s algorithm
    public static int countNodesInLoop2(Node head) {
        Node temp = firstNode2(head);
        if (temp == null) return 0; // No loop detected

        int count = 1;
        Node temp2 = temp.next;

        while (temp != temp2) {
            count++;
            temp2 = temp2.next;
        }
        return count;
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

        // Finding loop length using both approaches
        int length1 = countNodesInLoop(head);
        int length2 = countNodesInLoop2(head);

        System.out.println("Length of the loop (Brute Force): " + length1);
        System.out.println("Length of the loop (Floyd’s Algorithm): " + length2);
    }
}
