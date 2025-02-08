// Optimal O(n) and O(1)
class InsertAtEnd {
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        Node(int d) { // Constructor to initialize the node
            data = d;
            next = null;
        }
    }

    // Method to insert a node at the end of the list
    public static Node insertAtEnd(Node head, int element) {
        // If the list is empty, create a new node and return it as the head
        if (head == null) {
            return new Node(element);
        }

        Node temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Create a new node and add it at the end
        temp.next = new Node(element);

        return head; // Return the updated head of the list
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

        // Insert an element at the end
        int element = 4;
        head = insertAtEnd(head, element);

        System.out.println("\nLinked List After Inserting " + element + " at the End:");
        printList(head);
    }
}

