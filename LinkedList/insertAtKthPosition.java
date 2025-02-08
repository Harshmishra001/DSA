class insertAtKthPosition{
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Calculate length of linked list
    static int lengthofLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // Print linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Insert at start
    static Node insertAtStart(Node head, int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        return newNode;
    }

    // Insert at end
    static Node insertAtEnd(Node head, int element) {
        if (head == null) return new Node(element);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        return head;
    }

    //  optimal o(n)  o(1)
    // Insert at Kth position            
    static Node insertAtKthPosition(Node head, int element, int k) {
        if (head == null || k == 1) return insertAtStart(head, element);
        int length = lengthofLL(head);
        if (k > length + 1) return head;
        if (k == length + 1) return insertAtEnd(head, element);
        
        Node temp = head;
        for (int i = 1; i < k - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(element);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // optimal o(n)  o(1)
    // Insert before a value
    static Node insertValue(Node head, int element, int x) {      //element mtlb kisse phle dalna h or x mtlb vo data jo dalna h
        if (head == null) return null;
        if (head.data == element) {
            Node newNode = new Node(x);
            newNode.next = head;
            return newNode;
        }
        
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == element) {
                Node newNode = new Node(x);
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);

        System.out.println("Original Linked List:");
        printLinkedList(head);
        
        head = insertAtStart(head, 1);
        System.out.println("After Inserting First Node:");
        printLinkedList(head);
        
        head = insertAtEnd(head, 20);
        System.out.println("After Inserting Last Node:");
        printLinkedList(head);
        
        head = insertAtKthPosition(head, 4, 3);
        System.out.println("After Inserting Kth Node:");
        printLinkedList(head);
        
        head = insertValue(head, 8, 6);
        System.out.println("After Inserting Element:");
        printLinkedList(head);
    }
} 