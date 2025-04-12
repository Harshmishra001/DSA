// ### **Final Thoughts**
// - **Time Complexity**:
//   - `push()` → **O(1)**
//   - `pop()` → **Amortized O(1)** (since elements are transferred once)
//   - `peek()` → **Amortized O(1)**
//   - `empty()` → **O(1)**
// - **Space Complexity**: **O(n)** (since two stacks store elements)

// This is an efficient two-stack implementation of a queue, where costly transfers happen only when needed. Let me know if you need any modifications! 🚀



import java.util.Stack;

public class ImplementQueueUsingStack  {

  // Two stacks to implement the queue
  private final Stack<Integer> input;  // Used for enqueue operations
  private final Stack<Integer> output; // Used for dequeue operations

  // Constructor initializes both stacks
  public ImplementQueueUsingStack () {
    input = new Stack<>();
    output = new Stack<>();
  }

  // Push operation: Always push to the input stack
  public void push(int x) {
    input.push(x);
  }

  // Pop operation: Transfers elements to output stack if empty, then pops
  public int pop() {
    peek(); // Ensures output stack has elements
    return output.pop();
  }

  // Peek operation: Ensures the front element is in the output stack
  public int peek() {
    if (output.empty()) {
      // Move elements from input to output only when output is empty
      while (!input.empty()) {
        output.push(input.pop());
      }
    }
    return output.peek(); // The top of the output stack is the front of the queue
  }

  // Check if both stacks are empty
  public boolean empty() {
    return input.empty() && output.empty();
  }

  public static void main(String[] args) {
    ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
    
    queue.push(1);
    queue.push(2);
    
    System.out.println(queue.peek());  // Expected Output: 1
    System.out.println(queue.pop());   // Expected Output: 1
    System.out.println(queue.empty()); // Expected Output: false
  }
}
// ```

// ---

// ### **Dry Run of the Code**

// #### **Step-by-Step Execution**
// | Operation      | `input` Stack | `output` Stack | Output |
// |---------------|--------------|---------------|--------|
// | push(1)       | `[1]`        | `[]`          |        |
// | push(2)       | `[1, 2]`     | `[]`          |        |
// | peek()        | `[]`         | `[2, 1]`      | `1`    |
// | pop()         | `[]`         | `[2]`         | `1`    |
// | empty()       | `[]`         | `[2]`         | `false` |

