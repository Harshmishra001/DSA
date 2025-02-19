
public class DoublellInsert {
    static class Node {
        int data;
        Node next, back;
        // Constructor to initialize node with data, next, and back references
        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        // Constructor for Node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    Node head;

    // Function to calculate length of linked list
    // Time Complexity: O(n), where n is the number of nodes in the list.
    // Space Complexity: O(1), as we are using only a constant amount of extra space.
    static int lengthofLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    // Function to print linked list
    // Time Complexity: O(n), where n is the number of nodes in the list.
    // Space Complexity: O(1), as we are using only a constant amount of extra space.
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Function to insert node at the start
    // Time Complexity: O(1), constant time operation as it only involves linking the head node.
    // Space Complexity: O(1), we are only using a constant amount of extra space for the new node.
    static void insertAtStart(Node head, int element) {
        Node temp = new Node(element);
        temp.next = head;
        if (head != null) {
            head.back = temp;
        }
        head = temp; // Update head to the new node
    }

    // Function to insert node at the end
    // Time Complexity: O(n), where n is the number of nodes in the list.
    // Space Complexity: O(1), as we only need a constant amount of space for the new node.
    static void insertAtEnd(Node head, int element) {
        if (head == null) {
            head = new Node(element);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(element);
        temp.next = newNode;
        newNode.back = temp;
    }

    // Function to insert node at the kth position
    // Time Complexity: O(n), where n is the number of nodes in the list.
    // Space Complexity: O(1), we only need a constant amount of space for the new node.
    static void insertAtKthPosition(Node head, int element, int k) {
        if (head == null) {
            head = new Node(element);
            return;
        }
        int length = lengthofLL(head);
        if (k == 1) {
            insertAtStart(head, element);
        } else if (k == length + 1) {
            insertAtEnd(head, element);
        } else if (k > length + 1) {
            return;
        } else {
            Node temp = head;
            for (int i = 1; i < k - 1; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(element);
            newNode.next = temp.next;
            newNode.back = temp;
            if (temp.next != null) {
                temp.next.back = newNode;
            }
            temp.next = newNode;
        }
    }

    // Function to insert value after a specific element
    // Time Complexity: O(n), where n is the number of nodes in the list.
    // Space Complexity: O(1), we only need a constant amount of space for the new node.
    static void insertValue(Node head, int element, int x) {
        if (head == null) return;
        if (head.data == element) {
            Node newNode = new Node(x);
            newNode.next = head;
            head.back = newNode;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == element) {
                Node newNode = new Node(x);
                newNode.next = temp.next;
                newNode.back = temp;
                temp.next.back = newNode;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Directly creating the linked list
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

        insertAtStart(head, 1);
        System.out.println("After Inserting First Node: ");
        printLinkedList(head);

        insertAtEnd(head, 20);
        System.out.println("After Inserting Last Node: ");
        printLinkedList(head);

        insertAtKthPosition(head, 4, 3);
        System.out.println("After Inserting Kth Node: ");
        printLinkedList(head);

        insertValue(head, 16, 15);
        System.out.println("After Inserting Element: ");
        printLinkedList(head);
    }
}
