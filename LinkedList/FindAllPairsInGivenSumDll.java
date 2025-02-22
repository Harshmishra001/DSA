// Time Complexity: O(n) (Only one traversal using two pointers)
// Space Complexity: O(1) (Constant extra space for pointers)
import java.util.*;

class FindAllPairsInGivenSumDll {

    // Node class for a doubly linked list
    static class Node {
        int data;
        Node next, prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static List<int[]> findPairsWithGivenSum(Node head, int target) {
        List<int[]> result = new ArrayList<>();

        if (head == null || head.next == null) return result; // Edge case

        // Step 1: Find last node (t1)
        Node t1 = head;
        while (t1.next != null) {
            t1 = t1.next;
        }

        // Step 2: Initialize first pointer (t2) at head
        Node t2 = head;

        // Step 3: Two-pointer approach
        while (t2.data < t1.data) {
            int sum = t1.data + t2.data; // Calculate sum of current pair

            if (sum == target) { // If sum matches target, store the pair
                result.add(new int[]{t2.data, t1.data});
                t2 = t2.next; // Move left pointer forward
                t1 = t1.prev; // Move right pointer backward
            } 
            else if (sum < target) { // If sum is smaller, move t2 forward
                t2 = t2.next;
            } 
            else { // If sum is greater, move t1 backward
                t1 = t1.prev;
            }
        }

        return result; // Return all found pairs
    }

    // Utility function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Creating doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8 <-> 9
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next.next;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        int target = 7;
        List<int[]> result = findPairsWithGivenSum(head, target);

        System.out.println("Pairs with sum " + target + ":");
        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
