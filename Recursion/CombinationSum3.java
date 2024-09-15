import java.util.ArrayList;
import java.util.List;

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

public class CombinationSum3 {

    // Method to find all valid combinations of k numbers that sum up to n
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();  // To store all valid combinations
        List<Integer> combination = new ArrayList<>();   // To store the current combination
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};       // Numbers from 1 to 9
        backtrack(nums, k, n, 0, combination, result);   // Call the recursive backtrack function
        return result;
    }

    // Backtracking function to generate all possible combinations
    private void backtrack(int[] nums, int k, int n, int start, 
                           List<Integer> combination, List<List<Integer>> result) {
        // Base condition: if we have k numbers in the combination and their sum is equal to n
        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));  // Add a copy of the valid combination to the result
            return;
        }

        // Loop through the numbers starting from the given index
        for (int i = start; i < nums.length; ++i) {
            // If the current number exceeds the remaining sum, skip it (pruning)
            if (n < nums[i]) continue; 
            
            // Include the current number in the combination
            combination.add(nums[i]);
            
            // Recursively call the backtrack function to build the rest of the combination
            // We use 'i + 1' to ensure each number is only used once
            backtrack(nums, k, n - nums[i], i + 1, combination, result);
            
            // Remove the last number added to try the next possible candidate
            combination.remove(combination.size() - 1);
        }
    }
     // Main method to test the function with the provided test cases
     public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3 ();
        
        // Test case 1: k = 3, n = 7
        System.out.println("Test Case 1: " + solution.combinationSum3(3, 7)); // Output: [[1, 2, 4]]
        
        // Test case 2: k = 3, n = 9
        System.out.println("Test Case 2: " + solution.combinationSum3(3, 9)); // Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        
        // Test case 3: k = 4, n = 1
        System.out.println("Test Case 3: " + solution.combinationSum3(4, 1)); // Output: []
    }
}


// ### Step-by-Step Execution:
// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.

// 1. **Initial Call to `combinationSum3(3, 7)`**:
//    - `combinationSum3` calls the `backtrack` method with the following initial parameters:
//      - `nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}` (available numbers)
//      - `k = 3` (number of numbers to select)
//      - `n = 7` (target sum)
//      - `start = 0` (starting index)
//      - `combination = []` (currently selected numbers)
//      - `result = []` (final list to store valid combinations)

// 2. **First Iteration of the `backtrack` Function**:
//    - We start from `nums[0]` which is `1`.
//    - The current combination is `[]`, and `n = 7`.
//    - We add `1` to the combination: `combination = [1]`.
//    - Now, `n = 7 - 1 = 6` (remaining sum).
//    - Recursively call `backtrack(nums, k = 3, n = 6, start = 1, combination = [1], result = [])`.

// 3. **Second Iteration of the `backtrack` Function**:
//    - We start from `nums[1]` which is `2`.
//    - The current combination is `[1]`, and `n = 6`.
//    - We add `2` to the combination: `combination = [1, 2]`.
//    - Now, `n = 6 - 2 = 4` (remaining sum).
//    - Recursively call `backtrack(nums, k = 3, n = 4, start = 2, combination = [1, 2], result = [])`.

// 4. **Third Iteration of the `backtrack` Function**:
//    - We start from `nums[2]` which is `3`.
//    - The current combination is `[1, 2]`, and `n = 4`.
//    - Since `n < nums[2]` (i.e., `4 < 3`), we **skip** this number.
//    - Move to the next number: `nums[3]` which is `4`.
//    - The current combination is still `[1, 2]`, and `n = 4`.
//    - We add `4` to the combination: `combination = [1, 2, 4]`.
//    - Now, `n = 4 - 4 = 0` (target sum reached).
//    - Since the combination length is 3 (`combination.size() == k`) and `n == 0`, we add this combination to the result list:
//      - `result = [[1, 2, 4]]`.
//    - Backtrack by removing the last element: `combination = [1, 2]`.

// 5. **Backtracking and Exploring Other Possibilities**:
//    - We backtrack and continue from the previous state where `combination = [1, 2]` and `n = 4`.
//    - Move to the next number `nums[4]` which is `5`.
//    - Since `5 > 4` (remaining sum), we skip it, and similarly skip all larger numbers in subsequent iterations.
//    - Backtrack again: `combination = [1]`.

// 6. **Exploring Other Combinations**:
//    - Continue exploring combinations starting from `nums[2]`, `nums[3]`, etc.:
//    - When we try combinations starting from `nums[1] = 2`, none of them result in a valid combination of 3 numbers that sum up to `7`.

// 7. **Conclusion**:
//    - After trying all possibilities, we finish the recursion and return the result:
//      - `result = [[1, 2, 4]]`.

// ### Final Output:
// ```
// [[1, 2, 4]]
// ```

