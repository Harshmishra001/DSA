import java.util.List;
import java.util.ArrayList;

// Time complexity: O(2^n), Space complexity: O(n)

class GenerateParenthesis {
    
    // Function to generate all combinations of n pairs of parentheses
    public List<String> AllParenthesis(int n) 
    {
        // Initialize an empty string to store current combination
        String curr = "";
        
        // List to store all valid combinations of parentheses
        List<String> list = new ArrayList<>();
        
        // Start the recursive helper function
        helper(0, 0, n, curr, list);
        
        // Return the list of valid parentheses combinations
        return list;
    }
    
    // Helper function for recursion to generate parentheses
    static void helper(int open, int close, int n, String curr, List<String> list) {
        
        // Base case: if both open and close parentheses count reach n, we have a valid combination
        if (open == n && close == n) {
            list.add(curr); // Add the valid combination to the list
            return;         // Backtrack
        }
        
        // If the number of open parentheses is less than n, add an open parenthesis
        if (open < n) {
            helper(open + 1, close, n, curr + "(", list); // Add '(' and call the function recursively
        }
        
        // If the number of close parentheses is less than the number of open ones, add a close parenthesis
        if (open > close) {
            helper(open, close + 1, n, curr + ")", list); // Add ')' and call the function recursively
        }
    }
    
    // Test case with debugging information
    public static void main(String[] args) {
        GenerateParenthesis solution = new GenerateParenthesis();
        
        // Test case with n = 3
        int n = 3;
        
        // Get all valid combinations of parentheses
        List<String> result = solution.AllParenthesis(n);
        
        // Print the result with debug info
        System.out.println("Test case n = " + n);
        for (String str : result) {
            System.out.println(str);
        }
        
        // Expected output for n = 3:
        // ((()))
        // (()())
        // (())()
        // ()(())
        // ()()()
    }
}
