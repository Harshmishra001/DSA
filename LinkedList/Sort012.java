class Sort012 {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // ************* Optimized Approach (Dutch National Flag Algorithm) *************
    // ** Time Complexity: O(N) (Single pass traversal) **
    // ** Space Complexity: O(1) (In-place sorting, no extra space used) **
    static Node segregateOptimized(Node head) {
        if (head == null || head.next == null) return head;

        // Dummy nodes for 0s, 1s, and 2s
        Node zeroDummy = new Node(-1), oneDummy = new Node(-1), twoDummy = new Node(-1);
        
        Node zeroTail = zeroDummy, oneTail = oneDummy, twoTail = twoDummy;

        // Step 1: Segregate nodes into three separate lists
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
            
        }

        // Step 2: Connect the three lists
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // Step 3: Return the new head
        return zeroDummy.next;
    }

    // ************* Brute Force Approach (Counting Method) *************
    // ** Time Complexity: O(N) (Two traversals) **
    // ** Space Complexity: O(1) (In-place sorting, no extra space used) **
    static Node segregateBrute(Node head) {
        // Step 1: Count occurrences of 0s, 1s, and 2s
        Node temp = head;
        int zero = 0, one = 0, two = 0;
        
        while (temp != null) {
            if (temp.data == 0) zero++;
            else if (temp.data == 1) one++;
            else if (temp.data == 2) two++;
            temp = temp.next;
        }

        // Step 2: Refill the linked list with counted values
        temp = head;
        
        for (int i = 0; i < zero; i++) {
            temp.data = 0;
            temp = temp.next;
        }
        for (int i = 0; i < one; i++) {
            temp.data = 1;
            temp = temp.next;
        }
        for (int i = 0; i < two; i++) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

    // Method to print linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 2 -> 1 -> 0 -> 0 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);

        System.out.println("Original List:");
        printList(head);

        // Testing Brute Force Approach
        Node bruteSortedHead = segregateBrute(head);
        System.out.println("Sorted List using Brute Force Approach:");
        printList(bruteSortedHead);

        // Creating the linked list again for the optimized approach
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);

        // Testing Optimized Approach
        Node optimizedSortedHead = segregateOptimized(head);
        System.out.println("Sorted List using Optimized Approach:");
        printList(optimizedSortedHead);
    }
}
