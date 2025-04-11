package StackQueue;

import java.util.Stack;

public class PrefixToInfix {

    // Function to convert prefix expression to infix
    static String convertToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Traverse the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If the scanned character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                // Operator encountered: pop two operands from the stack
                String op1 = stack.pop(); // First operand
                String op2 = stack.pop(); // Second operand
                // Form a valid infix expression by placing the operator between operands
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp); // Push the new infix expression back to the stack
            }
        }

        // The final result is the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        // Example prefix expression
        String prefix = "*+pq-mn";
        System.out.println("Prefix expression: " + prefix);
        System.out.println("Infix expression: " + convertToInfix(prefix));
    }
}
// Dry Run for Prefix = "*+pq-mn"
// Step	Read	Stack State	Explanation
// 1	'n'	["n"]	Operand → Push to stack
// 2	'm'	["n", "m"]	Operand → Push to stack
// 3	'-'	["(m-n)"]	Operator - → Pop "m", "n", form "(m-n)", push result
// 4	'q'	["(m-n)", "q"]	Operand → Push to stack
// 5	'p'	["(m-n)", "q", "p"]	Operand → Push to stack
// 6	'+'	["(p+q)", "(m-n)"]	Operator + → Pop "p", "q", form "(p+q)", push result
// 7	'*'	["((p+q)*(m-n))"]	Operator * → Pop "(p+q)", "(m-n)", form "((p+q)*(m-n))", push result
// Final Infix Expression
// ✅ ((p+q)*(m-n))

// Time & Space Complexity
// Time Complexity: O(n)

// Space Complexity: O(n) (for the stack)