
// Example 1:

// Input: s = "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
// Example 2:

// Input: s = "(()())(())(()(()))"
// Output: "()()()()(())"
// Explanation: 
// The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
// After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
// Example 3:

// Input: s = "()()"
// Output: ""
// Explanation: 
// The input string is "()()", with primitive decomposition "()" + "()".
// After removing outer parentheses of each part, this is "" + "" = "".
 

// t.c-o(n) , s.c-o(n)

import java.util.*;

class RemoveOuterParenthesis  {
    public String removeOuterParentheses(String s) {
        // StringBuilder to store the result (removing outer parentheses)
        StringBuilder sf = new StringBuilder();
        
        // Variable to track the current level of parentheses
        int count = 0;
        // Loop through each character in the input string 's'
        for (char i : s.toCharArray()) {
            // When encountering an opening parenthesis '('
            if (i == '(') {
                // If we are not at the outermost level (count > 0), append the '(' to the result
                if (count > 0) {
                    sf.append(i);
                }
                // Increment the count to track the nested level
                count++;
            }
            // When encountering a closing parenthesis ')'
            if (i == ')') {
                // Decrement the count to move one level up in parentheses nesting
                count--;
                
                // If we are not at the outermost level (count > 0), append the ')' to the result
                if (count > 0) {
                    sf.append(i);
                }
            }
        }
        // Return the result as a string (final string without outer parentheses)
        return sf.toString();
    }

    // Main method to run dry run of the code
    public static void main(String[] args) {
        RemoveOuterParenthesis  sol = new RemoveOuterParenthesis();
        
        // Input string to perform dry run
        String input = "(()())(())";
        
        // Call the method and print the result
        String result = sol.removeOuterParentheses(input);
        System.out.println(result); // Expected output: "()()()"
    }
}
// Dry Run for the input: "(()())(())"

// Initial variables:
// sf = "" (StringBuilder to store the final result)
// count = 0 (tracks the nesting level of parentheses)

// Step-by-Step Dry Run:

// 1. Process first character: '('
// Current state:
// i = '('
// count = 0
// Action: Increment count (since '(' increases the nesting level).
// count = 1
// Since count == 1 (this is an outer parenthesis), do not append it to sf.

// Result so far:
// sf = ""


// 2. Process second character: '('
// Current state:
// i = '('
// count = 1
// Action: Increment count (another opening parenthesis).
// count = 2
// Since count > 1 (this is a nested parenthesis), append '(' to sf.

// Result so far:
// sf = "("


// 3. Process third character: ')'
// Current state:
// i = ')
// count = 2
// Action: Decrement count (closing parenthesis decreases the level).
// count = 1
// Since count > 0 (this is still a nested parenthesis), append ')' to sf.

// Result so far:
// sf = "()"

// 4. Process fourth character: '('
// Current state:
// i = '('
// count = 1
// Action: Increment count (another opening parenthesis).
// count = 2
// Since count > 1 (this is a nested parenthesis), append '(' to sf.

// Result so far:
// sf = "()("
// 5. Process fifth character: ')'
// Current state:
// i = ')
// count = 2
// Action: Decrement count (closing parenthesis decreases the level).
// count = 1
// Since count > 0 (this is still a nested parenthesis), append ')' to sf.

// Result so far:
// sf = "()()"


// 6. Process sixth character: ')'
// Current state:
// i = ')
// count = 1
// Action: Decrement count (closing parenthesis decreases the level).
// count = 0
// Since count == 0 (this is the outermost closing parenthesis), do not append it to sf.

// Result so far:
// sf = "()()"


// 7. Process seventh character: '('
// Current state:
// i = '('
// count = 0
// Action: Increment count (another opening parenthesis).
// count = 1
// Since count == 1 (this is the outermost opening parenthesis), do not append it to sf.

// Result so far:
// sf = "()()"

// 8. Process eighth character: '('
// Current state:
// i = '('
// count = 1
// Action: Increment count (another opening parenthesis).
// count = 2
// Since count > 1 (this is a nested parenthesis), append '(' to sf.

// Result so far:
// sf = "()()("

// 9. Process ninth character: ')'
// Current state:
// i = ')
// count = 2
// Action: Decrement count (closing parenthesis decreases the level).
// count = 1
// Since count > 0 (this is still a nested parenthesis), append ')' to sf.

// Result so far:
// sf = "()()()"

// 10. Process tenth character: ')'
// Current state:
// i = ')
// count = 1
// Action: Decrement count (closing parenthesis decreases the level).
// count = 0
// Since count == 0 (this is the outermost closing parenthesis), do not append it to sf.

// Result so far:
// sf = "()()()"

// Final Output:
// The final value of sf is "()()()".