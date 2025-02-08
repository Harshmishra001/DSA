class DeletionOfValue {
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        Node(int d) { // Constructor to initialize node
            data = d;
            next = null;
        }
    }

    // Method to delete a node with a specific value
    public static Node deleteValue(Node head, int element) {
        if (head == null) return head; // If the list is empty, do nothing

        // Check if the head node contains the element
        if (head.data == element) {
            Node temp = head; // Store the current head
            head = head.next; // Update the head to the next node
            temp = null; // Free memory (handled by garbage collector)
            return head;
        }

        Node current = head;

        // Traverse the list to find the node containing the element
        while (current.next != null) {
            if (current.next.data == element) {
                Node temp = current.next; // Node to delete
                current.next = current.next.next; // Bypass the node to delete
                temp = null; // Free memory (handled by garbage collector)
                return head;
            }
            current = current.next; // Move to the next node
        }

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
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Delete the node with value 3
        int element = 3;
        head = deleteValue(head, element);

        System.out.println("\nLinked List After Deleting Element " + element + ":");
        printList(head);
    }
}
