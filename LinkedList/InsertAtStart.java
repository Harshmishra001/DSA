// Optimal O(1) and O(1)

 public class InsertAtStart{
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        Node(int d) { // Constructor to initialize the node
            data = d;
            next = null;
        }
    }

    // Method to insert a node at the start
    public static Node insertAtStart(Node head, int element) {
        Node newNode = new Node(element); // Create a new node
        newNode.next = head; // Point the new node to the current head
        return newNode; // Return the new node as the updated head
    }

    // Utility method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> "); // Print the data
            temp = temp.next; // Move to the next node
        }
        System.out.println("NULL"); // End of the list
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        // Insert an element at the start
        int element = 0;
        head = insertAtStart(head, element);

        System.out.println("\nLinked List After Inserting " + element + " at the Start:");
        printList(head);
    }
}
