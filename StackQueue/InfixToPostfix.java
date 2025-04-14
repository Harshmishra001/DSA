
import java.util.Stack;
// Time Complexity (TC):
// - Each character is processed once (O(n)).
// - Operators are pushed and popped from stack (O(n)).
// - Overall, the time complexity is O(n).

// Space Complexity (SC):
// - Stack can store at most O(n) elements in worst case (all operators).
// - Output string takes O(n) space.
// - Overall, the space complexity is O(n).
public class InfixToPostfix {
    
    // Function to return precedence of operators
    static int getPrecedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1; // Low precedence operators
            case '*': case '/': return 2; // Medium precedence operators
            case '^': return 3; // Highest precedence (right associative)
            default: return -1; // Invalid operator case
        }
    }
    
    
    // Function to convert infix expression to postfix
    static String convertToPostfix(String exp) {
        StringBuilder result = new StringBuilder(); // Stores the final postfix expression
        Stack<Character> stack = new Stack<>(); // Stack to hold operators

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            // If the character is an operand (letter or digit), add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);  
            }
            // If character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop from stack and add to output until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove the '(' from stack
            }
            // If an operator is encountered
            else {
                // Pop operators from stack to result while they have higher or equal precedence
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c); // Push the current operator onto the stack
            }
        }

        // Pop all remaining operators from stack and add to result
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Mismatched parentheses case
            }
            result.append(stack.pop());
        }

        return result.toString(); // Return the postfix expression
    }

    // Driver method
    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)"; // Example infix expression
        System.out.println("Infix expression: " + exp);
        System.out.println("Postfix expression: " + convertToPostfix(exp)); // Output postfix expression
    }
}

/*
Dry Run:
Input: (p+q)*(m-n)

| Step | Character | Stack Content | Output |
|------|------------|---------------|---------|
|  1   | '('        | (             |         |
|  2   | 'p'        | (             | p       |
|  3   | '+'        | (+            | p       |
|  4   | 'q'        | (+            | pq      |
|  5   | ')'        |               | pq+     |
|  6   | '*'        | *             | pq+     |
|  7   | '('        | *(            | pq+     |
|  8   | 'm'        | *(            | pq+m    |
|  9   | '-'        | *(-           | pq+m    |
| 10   | 'n'        | *(-           | pq+mn   |
| 11   | ')'        | *             | pq+mn-  |
| 12   | '*'        |               | pq+mn-* |

Output: pq+mn-*
*/
