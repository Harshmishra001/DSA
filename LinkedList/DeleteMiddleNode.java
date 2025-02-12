
// TC: O(n),o(1)
public class DeleteMiddleNode {
    // Definition for singly-linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // Function to find the middle node using slow & fast pointer approach
    public static Node middle2(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to delete the middle node
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null; // Edge case: If only one node exists

        Node mid = middle2(head);
        Node temp = head;

        // Traverse till the node before mid
        while (temp.next != mid) { 
            temp = temp.next;
        }

        // Remove the middle node
        temp.next = mid.next;
        return head;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("Linked List after deleting middle node:");
        printList(head);
    }
}
