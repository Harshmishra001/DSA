//Brute

// * tc-o(n) sc(1)

// class DelHead {

//     // Definition of Node class
//     static class Node {
//         int data;
//         Node next;

//         Node(int d) {
//             data = d;
//             next = null;
//         }
//     }

//     // Method to remove the head of the linked list
//     public static Node removeHead(Node head) {
//         if (head == null) { // If the list is empty, return null
//             return null;
//         }
//         return head.next; // Return the next node as the new head
//     }

//     // Method to print the linked list
//     public static void printList(Node head) {
//         Node current = head;
//         while (current != null) {
//             System.out.print(current.data + " ");
//             current = current.next;
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         // Creating the linked list
//         Node head = new Node(1);
//         head.next = new Node(2);
//         head.next.next = new Node(3);
//         head.next.next.next = new Node(4);

//         System.out.println("Original List:");
//         printList(head);

//         // Removing the head of the linked list
//         head = removeHead(head);

//         System.out.println("List after deleting head:");
//         printList(head);
//     }
// }

// optimal tc-o(1) sc-o(1)
class DelHead {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to remove the head of the linked list in O(1) time and space
    public static Node removeHead(Node head) {
        return (head == null) ? null : head.next; // Return the next node as the new head
    }

    public static void main(String[] args) {
        // Creating the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Removing the head in O(1) time and space
        head = removeHead(head);

        // Displaying the new head
        System.out.println("New head data: " + head.data);
    }
}
