
// Time Complexity: O(N), as we traverse the list once.
// Space Complexity: O(1), as we only modify pointers.

class DeleteAllOccurrenceOfXDLL {
    // Node class representing a doubly linked list node
    static class Node {
        int data;
        Node next, prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    
    static Node deleteAllOccurOfXDLL(Node head, int x) {
        Node cur = head; // Initialize the current pointer at the head
        while (cur != null) { // Traverse through the list
            if (cur.data == x) { // Check if the current node's data matches x
                if (cur == head) { // If the head node needs to be deleted
                    head = head.next; //* Move the head to the next node
                    if (head != null) head.prev = null; // Update prev pointer of new head
                } else { 
                    if (cur.prev != null) cur.prev.next = cur.next; // Link previous node to next node
                    if (cur.next != null) cur.next.prev = cur.prev; // Link next node to previous node
                }
            }
            cur = cur.next; // Move to the next node
        }
        return head; // Return the new head after deletion
    }
    
    // Utility function to print the linked list
    static void printList(Node head) {
        Node temp = head; // Start from the head
        while (temp != null) { // Traverse and print each node
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL"); // End of list
    }
    
    public static void main(String[] args) {
        // Creating doubly linked list: 1 <-> 2 <-> 3 <-> 2 <-> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head; // Linking back reference
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;
        
        System.out.println("Original List:");
        printList(head);
        
        int x = 2;
        head = deleteAllOccurOfXDLL(head, x); // Deleting occurrences of x
        
        System.out.println("List after deleting all occurrences of " + x + ":");
        printList(head);
    }
}
