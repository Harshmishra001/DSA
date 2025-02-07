class DeletionOfKthEle {
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        Node(int d) { // Constructor to initialize node
            data = d;
            next = null;
        }
    }

    // Method to delete the kth element
    public static Node deleteKth(Node head, int k) {
        if (head == null || k <= 0) {
            // Invalid cases: empty list or invalid position
            return head;
        }

        if (k == 1) {
            // Special case: deleting the head node
            return head.next;
        }

        // Traverse the list to find the (k-1)th node
        Node current = head;
        for (int i = 1; i < k - 1 && current != null; i++) {
            current = current.next; // Move to the next node
        }

        if (current == null || current.next == null) {
            // If k is out of bounds (greater than the length of the list)
            return head;
        }

        // Skip the kth node
        current.next = current.next.next;

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

        // Delete the 3rd element
        int k = 3; // Position to delete

        /* EASY DRY RUN:
           Linked List: 1 -> 2 -> 3 -> 4 -> 5
           k = 3

           Step 1: Check if the list is empty or k is invalid. (List is not empty, continue)
           Step 2: Check if k == 1 (deleting the head). (False, continue)
           Step 3: Traverse to the (k-1)th node:
                   - Start at Node 1
                   - Move to Node 2
           Step 4: Delete the kth node by skipping it:
                   - Node 2's next pointer skips Node 3 and points to Node 4.
           Step 5: Updated Linked List: 1 -> 2 -> 4 -> 5
        */

        head = deleteKth(head, k); // Perform the deletion

        System.out.println("\nLinked List After Deleting " + k + "rd Element:");
        printList(head);
    }
}
