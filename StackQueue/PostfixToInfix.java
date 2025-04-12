

import java.util.Stack;

public class PostfixToInfix {
    
    // Function to convert postfix expression to infix
    static String convertToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        // Iterate through each character in the postfix expression
        for (char c : postfix.toCharArray()) {
            // If the character is an operand (letter or digit), push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));   //push use kia h toh character .toString use krenge 
            } else {
                // Operator encountered: pop two operands from the stack
                String op1 = stack.pop(); // First operand
                String op2 = stack.pop(); // Second operand
                // Form a valid infix expression by placing the operator between operands
                String temp = "(" + op2 + c + op1 + ")";
                stack.push(temp); // Push the new infix expression back to the stack
            }
        }

        // The final result is the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        // Example postfix expression
        String postfix = "ab-de+f*/";
        System.out.println("Postfix expression: " + postfix);
        System.out.println("Infix expression: " + convertToInfix(postfix));
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
// Postfix Expression: "ab-de+f*/"
// Step-by-Step Dry Run with Correct Stack Updates:
// Step	Read	Stack State	Explanation
// 1	'a'	["a"]	Operand → Push to stack
// 2	'b'	["a", "b"]	Operand → Push to stack
// 3	'-'	["(a - b)"]	Operator - → Pop "a" and "b", compute "(a - b)", push result
// 4	'd'	["(a - b)", "d"]	Operand → Push to stack
// 5	'e'	["(a - b)", "d", "e"]	Operand → Push to stack
// 6	'+'	["(a - b)", "(d + e)"]	Operator + → Pop "d" and "e", compute "(d + e)", push result
// 7	'f'	["(a - b)", "(d + e)", "f"]	Operand → Push to stack
// 8	'*'	["(a - b)", "((d + e) * f)"]	Operator * → Pop "(d + e)" and "f", compute "((d + e) * f)", push result (Corrected Step)
// 9	'/'	["((a - b) / ((d + e) * f))"]	Operator / → Pop "(a - b)" and "((d + e) * f)", compute final expression (Corrected Step)
