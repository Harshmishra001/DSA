import java.util.*;

class Traversal {
    
    static class Node {
        int data;
        Node next;
        // Constructor
        Node(int d ) {
            data = d;
            next = null;
        }

    }
    
    // Convert Array to Linked List
    public static Node convertArr2LL(int[] arr) {
        if (arr.length == 0) return null;
        
        Node head = new Node(arr[0]);  
        Node mover = head;
        
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;            
            mover = temp;      
        }
        return head;
    }
    
    // Calculate and print length of Linked List
    public static int lengthofLL(Node head) {
        int count = 0;
        Node temp = head;
        
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println("NULL");
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        Node head = convertArr2LL(arr);
        int length = lengthofLL(head);
        System.out.println("Length of Linked List: " + length);
    }
}
// ### **Dry Run of the Code**

// #### **Input**
// Array: `arr = {2, 5, 8, 7}`

// ### **Step-by-Step Execution**

// #### **Main Method**
// 1. Call `convertArr2LL(arr)`  
//    Pass `{2, 5, 8, 7}` to convert it into a Linked List.


// #### **Inside `convertArr2LL()`**
// 1. **Check Array Length**  
//    - `arr.length = 4` → Not empty, proceed.

// 2. **Create Head Node**  
//    - `head = Node(2)` → `head.data = 2, head.next = null`
//    - `mover = head`

// 3. **Iterate Through Array**  
//    - **Iteration 1 (i = 1):**  
//      - `temp = Node(5)` → `temp.data = 5, temp.next = null`
//      - `mover.next = temp` → Link `Node(2)` to `Node(5)`
//      - `mover = temp` → `mover` now points to `Node(5)`

//    - **Iteration 2 (i = 2):**  
//      - `temp = Node(8)` → `temp.data = 8, temp.next = null`
//      - `mover.next = temp` → Link `Node(5)` to `Node(8)`
//      - `mover = temp` → `mover` now points to `Node(8)`

//    - **Iteration 3 (i = 3):**  
//      - `temp = Node(7)` → `temp.data = 7, temp.next = null`
//      - `mover.next = temp` → Link `Node(8)` to `Node(7)`
//      - `mover = temp` → `mover` now points to `Node(7)`

// 4. **Return Head**  
//    - Linked List is now:  
//      ```
//      head → 2 → 5 → 8 → 7 → NULL
//      ```

// ---

// #### **Back to Main Method**
// 1. `head` of the Linked List is received.
// 2. Call `lengthofLL(head)` to calculate and print the length.

// ---

// #### **Inside `lengthofLL()`**
// 1. **Initialize Variables**  
//    - `count = 0`  
//    - `temp = head` → Start from `Node(2)`

// 2. **Traverse Linked List**
//    - **Iteration 1:**  
//      - `temp.data = 2` → Print `2 -> `  
//      - `count = 1`  
//      - `temp = temp.next` → Move to `Node(5)`

//    - **Iteration 2:**  
//      - `temp.data = 5` → Print `5 -> `  
//      - `count = 2`  
//      - `temp = temp.next` → Move to `Node(8)`

//    - **Iteration 3:**  
//      - `temp.data = 8` → Print `8 -> `  
//      - `count = 3`  
//      - `temp = temp.next` → Move to `Node(7)`

//    - **Iteration 4:**  
//      - `temp.data = 7` → Print `7 -> `  
//      - `count = 4`  
//      - `temp = temp.next` → Move to `NULL`

// 3. **End of List**  
//    - `temp = NULL` → Print `NULL`
//    - Return `count = 4`

// ---

// #### **Back to Main Method**
// 1. `length = 4` is received.
// 2. Print:  
//    ```
//    Length of Linked List: 4
//    ```

// ---

// ### **Output**
// ```
// 2 -> 5 -> 8 -> 7 -> NULL
// Length of Linked List: 4
// ```