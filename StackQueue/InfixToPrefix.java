package StackQueue;
import java.util.Stack;

public class InfixToPrefix {
    // Function to return precedence of operators
    static int getPrecedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1; // Low precedence operators
            case '*': case '/': return 2; // Medium precedence operators
            case '^': return 3; // Highest precedence (right associative)
            default: return -1; // Invalid operator case
        }
    }
   
    // Function to reverse a string
    static String reverse(String exp) {
        StringBuilder sb = new StringBuilder(exp);
        return sb.reverse().toString();
    }
    
    // Function to convert infix expression to prefix
    static String convertToPrefix(String exp) {
        // **Step 1: Reverse the infix expression
        exp = reverse(exp);
        
        // **Step 2: Replace '(' with ')' and vice versa
        StringBuilder modifiedExp = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (c == '(') modifiedExp.append(')');
            else if (c == ')') modifiedExp.append('(');
            else modifiedExp.append(c);
        }
        
        // **Step 3: Convert modified infix expression to postfix
        String postfix = convertToPostfix(modifiedExp.toString());
        
        // **Step 4: Reverse the postfix expression to get prefix ANSWER JO MILEGA POSTFIX USKO REVER KRDO MIL JAYEGA PREFIC
        return reverse(postfix);
    }
    
    // Function to convert infix expression to postfix (used in prefix conversion)
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
        System.out.println("Prefix expression: " + convertToPrefix(exp)); // Output prefix expression
    }
}

/*
Time Complexity (TC):
- Reversing the string: O(n)
- Modifying parentheses: O(n)
- Converting to postfix: O(n)
- Reversing the postfix expression: O(n)
- Overall, the time complexity is O(n).

Space Complexity (SC):
- Stack can store at most O(n) elements in worst case (all operators).
- Output string takes O(n) space.
- Overall, the space complexity is O(n).

Dry Run:
Input: (p+q)*(m-n)

| Step | Character | Stack Content | Output |
|------|------------|---------------|---------|
|  1   | ')'        | )             |         |
|  2   | 'n'        | )             | n       |
|  3   | '-'        | )-            | n       |
|  4   | 'm'        | )-            | nm      |
|  5   | '('        |               | nm-     |
|  6   | '*'        | *             | nm-     |
|  7   | ')'        | *)            | nm-     |
|  8   | 'q'        | *)            | nm-q    |
|  9   | '+'        | *)+           | nm-q    |
| 10   | 'p'        | *)+           | nm-qp   |
| 11   | '('        | *             | nm-qp+  |
| 12   | '*'        |               | *nm-qp+ |

Output: *+pq-mn
*/
