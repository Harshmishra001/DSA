import java.util.Stack;

public class ReverseStack {
    // Method to reverse the stack
    static void reverse(Stack<Integer> s) {
        // Base case: If stack is empty, return
        if (s.isEmpty()) {
            return;
        }
        
        // Pop the top element and hold it
        int top = s.pop();
        
        // Recursively reverse the remaining stack
        reverse(s);
        
        // Insert the popped element at the bottom of the stack
        insertAtBottom(s, top);    //mtlb uppr ki 2 line pop krti rhegi ab jo last m 1 reh jayega top vo pop hoga fir vhi dusre stack s insert hona shuru hoga
    }
    
    // Helper function to insert an element at the bottom of the stack
    static void insertAtBottom(Stack<Integer> s, int element) {
        // Base case: If the stack is empty, push the element
        if (s.isEmpty()) {
            s.push(element);
            return;
        }
        
        // Pop the top element and hold it
        int top = s.pop();
        
        // Recursively insert the element at the bottom
        insertAtBottom(s, element);
        
        // Push the top element back on the stack
        s.push(top);
    }
    
    public static void main(String[] args) {
        // Create a stack and push some elements onto it
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        // Print the stack before reversing
        System.out.println("Stack before reversing: " + stack);
        
        // Reverse the stack
        reverse(stack);
        
        // Print the stack after reversing
        System.out.println("Stack after reversing: " + stack);
    }

}

// Initial Stack :
// 1 2 3 4 5
// Stack<Integer> stack = new Stack<>();
// stack.push(1);
// stack.push(2);
// stack.push(3);
// stack.push(4);
// Expected Output: 4 3 2 1

// Execution Walkthrough:
// Initial Call to reverse(stack):

// Stack: [1, 2, 3, 4]
// 4 is popped.
// Calls reverse([1, 2, 3]).
// Recursive Call:

// Stack: [1, 2, 3]
// 3 is popped.
// Calls reverse([1, 2]).
// Recursive Call:

// Stack: [1, 2]
// 2 is popped.
// Calls reverse([1]).
// Recursive Call:

// Stack: [1]
// 1 is popped.
// Calls reverse([]) (empty stack).
// Base Case:

// Stack is empty, return from the reverse([]) call.

// Rebuilding the Stack:

// Insert 1 at Bottom:
// Stack: [] (empty)
// Push 1: Stack becomes [1]
// Insert 2 at Bottom:
// Stack: [1]
// Pop 1, insert 2, push 1 back: Stack becomes [2, 1]
// Insert 3 at Bottom:
// Stack: [2, 1]
// Pop 2, insert 3, push 2 back: Stack becomes [3, 2, 1]
// Insert 4 at Bottom:
// Stack: [3, 2, 1]
// Pop 3, insert 4, push 3 back: Stack becomes [4, 3, 2, 1]