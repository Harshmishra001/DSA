// Time Complexity: O(n) because we traverse the list to find the second-last node.
// Space Complexity: O(1) since no extra space is used

class DelFromEnd {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    // Method to delete the last node of the linked list
    public static Node removeLast(Node head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        Node current = head;
        while (current.next.next != null) { // Traverse to the second-last node
            current = current.next;
        }

        current.next = null; // Remove the last node by setting the next pointer of the second-last node to null
        return head;
    }

    public static void main(String[] args) {
        // Creating the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Removing the last node
        head = removeLast(head);

        // Displaying the updated list,,,  printingll
        Node current = head;
        System.out.print("Updated List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
