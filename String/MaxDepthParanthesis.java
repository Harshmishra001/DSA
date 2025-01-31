// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the 
// maximum number of nested parentheses.

// Example 1:

// Input: s = "(1+(2*3)+((8)/4))+1"
// Output: 3
// Explanation:
// Digit 8 is inside of 3 nested parentheses in the string.

// Example 2:
// Input: s = "(1)+((2))+(((3)))"
// Output: 3
// Explanation:
// Digit 3 is inside of 3 nested parentheses in the string.

// Example 3:
// Input: s = "()(())((()()))"
// Output: 3


// Time Complexity (TC):
// O(n)
// Space Complexity (SC):
// O(1)

class MaxNestedDepthParenthesis {
    /**
     * This method calculates the maximum depth of valid parentheses nesting in a given string.
     * 
     * @param s the input string containing parentheses
     * @return the maximum nesting depth of parentheses
     */
    public int maxDepth(String s) {
        int openBrackets = 0; // Tracks the count of open brackets
        int nestingDepth = 0; // Stores the maximum depth of nested parentheses

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Increment openBrackets when encountering an open parenthesis
                openBrackets += 1;
            } else if (ch == ')') {
                // Decrement openBrackets when encountering a close parenthesis
                openBrackets -= 1;
            }
            // Update the maximum depth of nesting
            nestingDepth = Math.max(nestingDepth, openBrackets);
        }

        return nestingDepth; // Return the maximum depth found
    }

    public static void main(String[] args) {
        MaxNestedDepthParenthesis  solution = new MaxNestedDepthParenthesis();
        String s = "(1+(2*3)+((8)/4))+1";
        
        // Calculate and print the maximum depth
        int result = solution.maxDepth(s);
        System.out.println("Maximum Depth of Parentheses: " + result);
    }
}


// Dry Run:
// Input: s = "(1+(2*3)+((8)/4))+1"

// Character	openBrackets	nestingDepth	Explanation
// (	1	1	Open a parenthesis, increment openBrackets.
// 1	1	1	Ignore non-parentheses characters.
// +	1	1	Ignore non-parentheses characters.
// (	2	2	Open another parenthesis, update nestingDepth.
// 2	2	2	Ignore non-parentheses characters.
// *	2	2	Ignore non-parentheses characters.
// 3	2	2	Ignore non-parentheses characters.
// )	1	2	Close a parenthesis, decrement openBrackets.
// +	1	2	Ignore non-parentheses characters.
// (	2	2	Open another parenthesis.
// (	3	3	Open another parenthesis, update nestingDepth.
// 8	3	3	Ignore non-parentheses characters.
// )	2	3	Close a parenthesis, decrement openBrackets.
// /	2	3	Ignore non-parentheses characters.
// 4	2	3	Ignore non-parentheses characters.
// )	1	3	Close a parenthesis, decrement openBrackets.
// )	0	3	Close the last parenthesis.
// +	0	3	Ignore non-parentheses characters.
// 1	0	3	Ignore non-parentheses characters.
// Output: 3
// The maximum nesting depth of parentheses in the string is 3.