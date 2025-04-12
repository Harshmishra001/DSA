
// Time Complexity:
// - push(): O(1) → Adds element at the top
// - pop(): O(1) → Removes top element
// - size(): O(1) → Returns stack size
// - isEmpty(): O(1) → Checks if stack is empty

// Space Complexity:
// - O(n) → Each element is stored in a separate node

class ImplementStackUsingLL {
    // Node structure for stack elements
    private class StackNode {
        int data;
        StackNode next;
        
        StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private StackNode top; // Pointer to the top of the stack
    private int size; // Tracks the number of elements

    // Constructor to initialize an empty stack
    ImplementStackUsingLL() {
        this.top = null;
        this.size = 0;
    }

    // Push operation - Adds an element at the top
    public void push(int value) {
        StackNode newNode = new StackNode(value);
        newNode.next = top; // New node points to previous top mtlb null s kyuki top phle null ko hi point kr ra h
        top = newNode; // Update top to the new node
        size++;
        System.out.println("Pushed: " + value);
    }

    // Pop operation - Removes and returns the top element
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1; // Indicates stack is empty
        }
        int poppedValue = top.data;
        top = top.next; // Move top to the next node
        size--;
        System.out.println("Popped: " + poppedValue);
        return poppedValue;
    }

    // Returns the current size of the stack
    public int size() {
        return size;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Prints the stack from top to bottom
    public void printStack() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode current = top;
        System.out.print("Stack elements (top → bottom): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // New line for better readability
    }

    public static void main(String[] args) {
        ImplementStackUsingLL stack = new ImplementStackUsingLL();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Displaying the stack
        stack.printStack();

        // Popping the top element
        stack.pop();

        // Displaying updated stack size
        System.out.println("Current Stack Size: " + stack.size());

        // Checking if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Printing the stack after pop operation
        stack.printStack();
    }
}

/*
Dry Run:

Step 1: Initialize empty stack
-----------------------------------
Stack: (empty)
top = null, size = 0

Step 2: push(10)
-----------------------------------
Stack: [10]
top = 10, size = 1

Step 3: push(20)
-----------------------------------
Stack: [20 → 10]
top = 20, size = 2

Step 4: push(30)
-----------------------------------
Stack: [30 → 20 → 10]
top = 30, size = 3

Step 5: printStack()
-----------------------------------
Output: Stack elements (top → bottom): 30 20 10

Step 6: pop()
-----------------------------------
Stack: [20 → 10]
top = 20, size = 2
Output: Popped: 30

Step 7: size()
-----------------------------------
Output: Current Stack Size: 2

Step 8: isEmpty()
-----------------------------------
Output: Is stack empty? false

Step 9: printStack()
-----------------------------------
Output: Stack elements (top → bottom): 20 10
*/

