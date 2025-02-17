public class DoublellDelete {
    // Node class representing each element in the doubly linked list
    static class Node {
        int data;
        Node next, back;

        // Constructor to initialize node with data, next, and back references
        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        // Constructor to initialize node with data, next and back are set to null by default
        Node(int data) {
            this(data, null, null);
        }
    }

    Node head;

    // Function to calculate the length of the linked list
    // TC: O(n) where n is the number of nodes in the list
    // SC: O(1) as we're using a constant amount of space
    static int lengthofLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    // Function to print the linked list
    // TC: O(n) where n is the number of nodes in the list
    // SC: O(1) as we're using a constant amount of space
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Function to delete the first node in the linked list
    // TC: O(1) as we are just updating the head pointer
    // SC: O(1) as we are not using additional space
    static Node deleteFromStart(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            return null;
        } else {
            head = head.next; // update head to the next node
            head.back = null; // set back reference of the new head to null
            return head;
        }
    }

    // Function to delete the last node in the linked list
    // TC: O(n) where n is the number of nodes in the list
    // SC: O(1) as we are using constant space
    static Node deleteFromEnd(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            return null;
        }
        Node temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }
        // Update the second last node's next pointer to null
        temp.back.next = null;
        return head;
    }

    // Function to delete the node at the k-th position (1-based index)
    // TC: O(n) where n is the number of nodes in the list
    // SC: O(1) as we're not using extra space
    static Node deleteFromKthPosition(Node head, int k) {
        if (head == null) return null;
        int length = lengthofLL(head); // Get the length of the list
        if (k == 1) return deleteFromStart(head); // Delete from start
        else if (k == length) return deleteFromEnd(head); // Delete from end
        else if (k > length) return head; // If k is greater than the length, do nothing

        Node temp = head;
        // Traverse to the (k-1)-th node
        for (int i = 1; i < k - 1; i++) temp = temp.next;
        // Skip the k-th node
        temp.next = temp.next.next;
        if (temp.next != null) temp.next.back = temp; // Update the back pointer
        return head;
    }

    // Function to delete a node with a specific value
    // TC: O(n) where n is the number of nodes in the list
    // SC: O(1) as we're not using extra space
    static Node deleteValue(Node head, int element) {
        if (head == null) return null;
        if (head.data == element) { // If the element to delete is at the head
            head = head.next;
            if (head != null) head.back = null; // Set back reference to null
            return head;
        }
        Node temp = head;
        // Traverse through the list and find the element to delete
        while (temp.next != null) {
            if (temp.next.data == element) {
                temp.next = temp.next.next; // Skip the node with the given value
                if (temp.next != null) temp.next.back = temp; // Update the back pointer
                return head;
            }
            temp = temp.next;
        }
        return head; // Return head if element is not found
    }

    public static void main(String[] args) {
        // Creating the doubly linked list manually
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.back = head;
        head.next.next = new Node(8);
        head.next.next.back = head.next;
        head.next.next.next = new Node(7);
        head.next.next.next.back = head.next.next;
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.back = head.next.next.next;
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.back = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(14);
        head.next.next.next.next.next.next.back = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next = new Node(16);
        head.next.next.next.next.next.next.next.back = head.next.next.next.next.next.next;

        // Print the original list
        System.out.println("Original Linked List: ");
        printLinkedList(head);

        // Perform delete operations and print results
        head = deleteFromStart(head);
        System.out.println("After Deleting First Node: ");
        printLinkedList(head);

        head = deleteFromEnd(head);
        System.out.println("After Deleting Last Node: ");
        printLinkedList(head);

        head = deleteFromKthPosition(head, 4);
        System.out.println("After Deleting Kth Node: ");
        printLinkedList(head);

        head = deleteValue(head, 7);
        System.out.println("After Deleting Element: ");
        printLinkedList(head);
    }
}
