// ******************************************
// ** Time Complexity: O(n) **
// - O(n) for finding length
// - O(n - k) for repositioning nodes

// ** Space Complexity: O(1) **
// - No extra space used
// ******************************************
import java.util.*;

class RotateALL{
    static class Node {
        int num;
        Node next;
    
        Node(int a) {
            num = a;
            next = null;
        }
    }
    // Utility function to rotate the linked list to the right by k positions
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head; // Edge case handling
        
        // Step 1: Calculate the length of the linked list
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        
        // Step 2: Connect the last node to the head to form a circular list
        temp.next = head;

        // Step 3: Adjust k if it is greater than the length of the list
        k = k % length;

        // Step 4: Find the new tail (node before the new head)
        int end = length - k; // Position of the new tail
        while (end-- != 0) temp = temp.next;

        // Step 5: Break the circular link and set the new head
        head = temp.next;
        temp.next = null;

        return head;
    }

    // Utility function to print the linked list
    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static void main(String args[]) {
        // Manually creating the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list: ");
        printList(head);

        int k = 2;

        // Rotating the linked list to the right by k positions
        Node newHead = rotateRight(head, k);

        System.out.println("After " + k + " rotations: ");
        printList(newHead);
    }
}

/*
******************************************
*************** DRY RUN ******************
******************************************

** Input List: **
1 -> 2 -> 3 -> 4 -> 5

** k = 2 **

Step 1: Find length of linked list.
- Start from head (1), traverse till last node (5).
- Length = 5

Step 2: Connect last node (5) to head (1) to form a circular list.

Step 3: Adjust k:
- k = k % length → 2 % 5 = 2 (remains 2)

Step 4: Find the new tail:
- We need (length - k) = (5 - 2) = 3rd node as new tail.
- Move 3 steps from head:
  - Start at 1 → Move to 2 → Move to 3 (new tail)

Step 5: Set new head and break the link:
- New head = 4
- Break link after 3 (set 3.next = null)

** Output List after Rotation: **
4 -> 5 -> 1 -> 2 -> 3


*/
