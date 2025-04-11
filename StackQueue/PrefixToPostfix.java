package StackQueue;
import java.util.Stack;

public class PrefixToPostfix {
    
    // Function to convert prefix expression to postfix
    static String convertToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Traverse the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If the scanned character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                // Pop two operands from the stack
                String op1 = stack.pop(); // First operand
                String op2 = stack.pop(); // Second operand
                // Form a valid postfix expression by placing the operator at the end
                String temp = op1 + op2 + c;
                stack.push(temp); // Push the new postfix expression back to the stack
            }
        }

        // The final result is the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        // Example prefix expression
        String prefix = "*+pq-mn";
        System.out.println("Prefix expression: " + prefix);
        System.out.println("Postfix expression: " + convertToPostfix(prefix));
    }
}
// ### **Prefix to Postfix Conversion - Dry Run for `*+pq-mn`**  

// #### **Expression:** `* + p q - m n`  
// We traverse **right to left** using a **stack** to store operands and build the postfix expression.  

// ---

// ### **Step-by-Step Dry Run**  

// | Step | Read Character | Stack After Operation |
// |------|--------------|------------------------|
// | 1    | `n` (operand) | `["n"]` |
// | 2    | `m` (operand) | `["n", "m"]` |
// | 3    | `-` (operator) | `["mn-"]` (`op1 = m`, `op2 = n`, `result = mn-`) |
// | 4    | `q` (operand) | `["mn-", "q"]` |
// | 5    | `p` (operand) | `["mn-", "q", "p"]` |
// | 6    | `+` (operator) | `["mn-", "pq+"]` (`op1 = p`, `op2 = q`, `result = pq+`) |
// | 7    | `*` (operator) | `["pq+mn-*"]` (`op1 = pq+`, `op2 = mn-`, `result = pq+mn-*`) |

// ---

// ### **Final Postfix Expression:**  
// ✅ **`pq+mn-*`**  

// ---

// ### **Time & Space Complexity Analysis**  
// - **Time Complexity:** **O(n)** (Each character is processed once)  
// - **Space Complexity:** **O(n)** (Stack stores up to `n/2` elements in the worst case)  

