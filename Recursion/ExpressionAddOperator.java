import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {

    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();  // List to store valid expressions

        if (num == null || num.length() == 0) return result; // Edge case: empty string

        helper(result, "", num, target, 0, 0, 0); // Start the recursive exploration
        
        return result; // Return all valid expressions

    }


    private void helper(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        // Base Case: If we've reached the end of the string, check if the current expression evaluates to the target
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path); // Add the valid expression to the result list
            }
            return; // Backtrack to explore other possibilities
        }

        // Iterate through the string to partition it into substrings representing numbers
        for (int i = pos; i < num.length(); i++) {
            // Avoid numbers with leading zeros (e.g., "05" is invalid)
            if (i != pos && num.charAt(pos) == '0') break;

            // Extract the current number substring and convert it to a long
            String currentStr = num.substring(pos, i + 1);
            long currentNum = Long.parseLong(currentStr);

            // If at the start of the expression, initialize without any operator
            if (pos == 0) {
                // Example: num = "123", currentStr = "1"
                helper(result, currentStr, num, target, i + 1, currentNum, currentNum);
            } else {
                // Recursive call with '+' operator
                helper(result, path + "+" + currentStr, num, target, i + 1, eval + currentNum, currentNum);

                // Recursive call with '-' operator
                helper(result, path + "-" + currentStr, num, target, i + 1, eval - currentNum, -currentNum);

                // Recursive call with '*' operator
                // Handle multiplication with proper operator precedence
                helper(result, path + "*" + currentStr, num, target, i + 1, eval - multed + multed * currentNum, multed * currentNum);
            }
        }
    }


    public static void main(String[] args) {
        // Test Case 1
        String num1 = "123";
        int target1 = 6;

        // Test Case 2
        String num2 = "232";
        int target2 = 8;

        // Test Case 3
        String num3 = "3456237490";
        int target3 = 9191;

        // Create an instance of the Solution class
        ExpressionAddOperator solution = new ExpressionAddOperator();

        // Execute addOperators for Test Case 1
        List<String> result1 = solution.addOperators(num1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input: num = \"" + num1 + "\", target = " + target1);
        System.out.println("Output: " + result1);
        System.out.println();

        // Execute addOperators for Test Case 2
        List<String> result2 = solution.addOperators(num2, target2);
        System.out.println("Test Case 2:");
        System.out.println("Input: num = \"" + num2 + "\", target = " + target2);
        System.out.println("Output: " + result2);
        System.out.println();

        // Execute addOperators for Test Case 3
        List<String> result3 = solution.addOperators(num3, target3);
        System.out.println("Test Case 3:");
        System.out.println("Input: num = \"" + num3 + "\", target = " + target3);
        System.out.println("Output: " + result3);
        System.out.println();
    }
}
