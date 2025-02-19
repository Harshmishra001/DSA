public class DoublyReversell  {

    // Node class to represent elements in the doubly linked list
    static class Node {
        int data;
        Node next, back;

        // Constructor for Node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    Node head;

    // Function to print the doubly linked list
    // Time Complexity: O(n), as we traverse through the entire list.
    // Space Complexity: O(1), as we use a constant amount of space.
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Function to reverse the doubly linked list
    // Time Complexity: O(n), as we traverse through the entire list once.
    // Space Complexity: O(1), as we use only a few variables to manipulate pointers.
    static void reverse(Node head) {
        Node p = null;
        Node c = head;
        Node n;
        
        // Traverse the list and reverse the links
        while (c != null) {
            n = c.next;
            c.next = p;
            c.back = n;
            p = c;
            c = n;
        }
        head = p; // Update head to the new first node after reversing
    }

    public static void main(String[] args) {
        // Creating a doubly linked list
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.back = head;
        head.next.next = new Node(7);
        head.next.next.back = head.next;
        head.next.next.next = new Node(8);
        head.next.next.next.back = head.next.next;
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.back = head.next.next.next;
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.back = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(14);
        head.next.next.next.next.next.next.back = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next = new Node(16);
        head.next.next.next.next.next.next.next.back = head.next.next.next.next.next.next;

        System.out.println("Original Linked List: ");
        printLinkedList(head);
        
        // Reversing the linked list
        reverse(head);
        
        System.out.println("After Reversing: ");
        printLinkedList(head);
    }
}
