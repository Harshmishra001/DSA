// Java program to add two numbers represented as linked lists

public class Add2NoLL {

    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    // Function to print a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    // Function to add two numbers represented by linked lists
    // Time Complexity: O(max(m, n)) | Space Complexity: O(max(m, n))
    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(-1); // Dummy node to simplify list construction
        Node temp = dummy; // Pointer to track the new list
        int carry = 0; // To store the carry during addition

        // Loop until both lists are exhausted and carry is zero
        while (l1 != null || l2 != null || carry != 0) {
           
            int sum = carry;

            // Add value from first list if present
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            // Add value from second list if present
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10; // Compute new carry
            temp.next = new Node(sum % 10); // Store the last digit of sum
            temp = temp.next; // Move the pointer forward
        }
        
        return dummy.next; // Return the result list (excluding dummy node)
    }

    public static void main(String[] args) {
        // Creating first linked list: 2 -> 4 -> 3
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Creating second linked list: 5 -> 6 -> 4
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        // Adding the two linked lists
        Node result = addTwoNumbers(l1, l2);
        
        // Printing the result linked list
        printList(result);
    }
}
// ### **Dry Run of `addTwoNumbers(l1, l2)`**

// #### **Given Linked Lists:**
// ```
// l1: 2 -> 4 -> 3  (Represents 342)
// l2: 5 -> 6 -> 4  (Represents 465)
// ```
// We will add these numbers **digit by digit**, considering carry.

// ---

// ### **Step-by-Step Execution**

// 1️⃣ **Initialization:**
//    - Create a dummy node: `dummy = new Node(-1)`.
//    - `temp` points to `dummy` (used to build the result list).
//    - `carry = 0` (stores carry-over during addition).

// ---

// 2️⃣ **First Iteration (Adding 2 and 5):**
//    - `sum = carry + l1.data + l2.data = 0 + 2 + 5 = 7`
//    - `carry = sum / 10 = 7 / 10 = 0`
//    - Create a new node with `sum % 10 = 7`, attach it to `temp`.
//    - Move `temp` to this new node.
//    - Move `l1` to next node (`4`), `l2` to next node (`6`).

//    **Intermediate result:**
//    ```
//    dummy -> 7 -> NULL
//    ```

// ---

// 3️⃣ **Second Iteration (Adding 4 and 6):**
//    - `sum = carry + l1.data + l2.data = 0 + 4 + 6 = 10`
//    - `carry = sum / 10 = 10 / 10 = 1`
//    - Create a new node with `sum % 10 = 0`, attach it to `temp`.
//    - Move `temp` to this new node.
//    - Move `l1` to next node (`3`), `l2` to next node (`4`).

//    **Intermediate result:**
//    ```
//    dummy -> 7 -> 0 -> NULL
//    ```

// ---

// 4️⃣ **Third Iteration (Adding 3 and 4):**
//    - `sum = carry + l1.data + l2.data = 1 + 3 + 4 = 8`
//    - `carry = sum / 10 = 8 / 10 = 0`
//    - Create a new node with `sum % 10 = 8`, attach it to `temp`.
//    - Move `temp` to this new node.
//    - Move `l1` and `l2` to `null` (end of lists).

//    **Final result list:**
//    ```
//    dummy -> 7 -> 0 -> 8 -> NULL
//    ```

// ---

// 5️⃣ **End Condition:**
//    - Both `l1` and `l2` are `null`, and `carry = 0`.
//    - Return `dummy.next`, which is `7 -> 0 -> 8 -> NULL`.

// ---

// 6️⃣ **Printing the Result:**
// ```java
// printList(result);
// ```
// **Output:**
// ```
// 7 -> 0 -> 8 -> NULL
// ```
// This correctly represents **807**, which is the sum of **342 + 465**. ✅🚀

