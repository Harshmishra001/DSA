
// Time Complexity: O(1) for push(), pop(), top(), and getMin().
// Space Complexity: O(N) in the worst case when all elements are in decreasing order.
import java.util.Stack;

public class ImplementMinStack {

  // Main stack to store elements
  Stack<Integer> stack;
  
  
  // Auxiliary stack to track the minimum element at each step
  Stack<Integer> minStack;

  // Constructor to initialize both stacks
  public ImplementMinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  // Push operation: Adds an element to the stack
  public void push(int val) {
    stack.push(val); // Push value to the main stack

    // If minStack is empty OR new value is smaller/equal to the current min, push to minStack
    if (minStack.isEmpty() || val <= minStack.peek()) {
      minStack.push(val);
    }
  }

  // Pop operation: Removes the top element from the stack
  public void pop() {
    if (!stack.isEmpty()) {
      int poppedValue = stack.pop(); // Remove top element from the main stack

      // If the popped value was the current minimum, also pop it from minStack
      if (poppedValue == minStack.peek()) {
        minStack.pop();
      }
    }
  }

  // Returns the top element of the stack without removing it
  public int top() {
    return stack.peek();
  }

  // Returns the minimum element in the stack in O(1) time
  public int getMin() {
    return minStack.peek();
  }

  // Main method to test the ImplementMinStack functionality
  public static void main(String[] args) {
    ImplementMinStack minStack = new ImplementMinStack(); // Create an instance of ImplementMinStack

    // Pushing elements onto the stack
    minStack.push(5);
    minStack.push(2);
    minStack.push(4);
    minStack.push(1);

    // Get the minimum element (should be 1)
    System.out.println("Minimum: " + minStack.getMin()); // Expected output: 1

    // Pop the top element (1) and check the new minimum
    minStack.pop();
    System.out.println("Minimum after popping 1: " + minStack.getMin()); // Expected output: 2

    // Pop another element (4) and check the minimum
    minStack.pop();
    System.out.println("Minimum after popping 4: " + minStack.getMin()); // Expected output: 2

    // Pop another element (2) and check the minimum
    minStack.pop();
    System.out.println("Minimum after popping 2: " + minStack.getMin()); // Expected output: 5
  }
}
