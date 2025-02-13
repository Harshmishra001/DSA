// ### **Time and Space Complexity**  
// - **Time Complexity:**  O(N)  (One pass through the list).  
// - **Space Complexity:**  O(1)  (In-place modification, no extra list). 

 class SegregateEvenOddInll {

    // Definition for the Node class inside the same class
    static class Node {
        int data;
        Node next;

        // Constructor to initialize a node
        Node(int d) {
           data = d;
           next = null;
        }
    }

    // Function to segregate even and odd nodes in the given linked list
    public static Node segregateEvenOdd(Node head) {
        if (head == null) return null; // If list is empty, return null

        // Creating dummy nodes for even and odd lists
        Node even = new Node(-1), odd = new Node(-1);

        Node evenHead = even, oddHead = odd;

        Node ptr = head;

        // Traverse through the linked list
        while (ptr != null) {
            if (ptr.data % 2 == 0) { // Even number
                even.next = ptr; // Append current node to even list
                even = even.next; // Move even pointer forward
            } else { // Odd number
                odd.next = ptr; // Append current node to odd list
                odd = odd.next; // Move odd pointer forward
            }
            ptr = ptr.next; // Move to the next node
        }

        // Mark the end of the odd list
        odd.next = null;

        // Connect even and odd lists
        even.next = oddHead.next;

        // Return the head of the new list
        return evenHead.next;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original Linked List:");
        printList(head);

        // Segregating even and odd nodes
        head = segregateEvenOdd(head);

        System.out.println("Modified Linked List:");
        printList(head);
    }
}


// #### **Initial List:**  
// `1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL`  

// #### **Step 1: Create Dummy Nodes**  
// `evenHead(-1)` and `oddHead(-1)` created to store even and odd lists separately.  
// Pointers `even` and `odd` initialized to these dummy nodes.  

// #### **Step 2: Traverse the list and segregate nodes**  

// After the loop,  
// - **Even List:** `2 -> 4 -> 6`  
// - **Odd List:** `1 -> 3 -> 5`  

// #### **Step 3: Merge Even and Odd Lists**  
// We connect the last even node `6` to the first odd node `1`.  

// #### **Final List (Output):**  
// `2 -> 4 -> 6 -> 1 -> 3 -> 5 -> NULL`  


 



