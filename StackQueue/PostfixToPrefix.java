

import java.util.Stack;

public class PostfixToPrefix {
    
    // Function to convert postfix expression to prefix
    static String convertToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        // Iterate through each character in the postfix expression
        for (char c : postfix.toCharArray()) {
            // If the character is an operand (letter or digit), push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));  // Alternative to String.valueOf(c)
            } else {
                // Operator encountered: pop two operands from the stack
                String op1 = stack.pop(); // First operand
                String op2 = stack.pop(); // Second operand
                
                // Form a valid prefix expression by placing the operator before operands
                String temp = c + op2 + op1;
                stack.push(temp); // Push the new prefix expression back to the stack
            }
        }

        // The final result is the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        // Example postfix expression
        String postfix = "ab-de+f*/";
        System.out.println("Postfix expression: " + postfix);
        System.out.println("Prefix expression: " + convertToPrefix(postfix));
    }
}

/*
Time Complexity: O(n)
   - Each character is pushed and popped from the stack at most once.
   - Total operations performed: O(2n) -> Simplifies to O(n).

Space Complexity: O(n)
   - Stack stores at most n/2 elements in the worst case.
   - Additional space for the result string: O(n).
   - Overall: O(n).
*/

// Here’s the correct **dry run** for the **Postfix to Prefix** conversion of `"ab-de+f*/"`:
// ---

// ### **Postfix Expression:** `ab-de+f*/`
// ### **Step-by-Step Dry Run:**
// We process the postfix expression **left to right** and use a **stack** to store intermediate results.

// | Step | Read Character | Stack After Operation |
// |------|--------------|------------------------|
// | 1    | `a` (operand) | `["a"]` |
// | 2    | `b` (operand) | `["a", "b"]` |
// | 3    | `-` (operator) | `["-ab"]` (`op2 = a`, `op1 = b`, `result = -ab`) |
// | 4    | `d` (operand) | `["-ab", "d"]` |
// | 5    | `e` (operand) | `["-ab", "d", "e"]` |
// | 6    | `+` (operator) | `["-ab", "+de"]` (`op2 = d`, `op1 = e`, `result = +de`) |
// | 7    | `f` (operand) | `["-ab", "+de", "f"]` |
// | 8    | `*` (operator) | `["-ab", "*+def"]` (`op2 = +de`, `op1 = f`, `result = *+def`) |
// | 9    | `/` (operator) | `["/-ab*+def"]` (`op2 = -ab`, `op1 = *+def`, `result = /-ab*+def`) |

// ---

// ### **Final Prefix Expression:**  
// **`/-ab*+def`**  
