import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum2 {
    // Function to find all unique combinations where the sum equals the target
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Result list to store all the unique combinations
        List<List<Integer>> result = new ArrayList<>();
        // Temporary list to store current combination
        List<Integer> currentCombination = new ArrayList<>();
        
        // Sort the array to handle duplicates and ensure non-descending order
        Arrays.sort(arr);
        
        // Call the helper function to perform backtracking
        backtrack(arr, 0, k, currentCombination, result);
        
        // Return the final result
        return result;
    }
    
    // Helper function to perform the recursive backtracking
    private void backtrack(int[] arr, int index, int target, List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: if target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));  // Add a copy of the current combination
            return;
        }
        
        // Iterate through the array starting from the current index
        for (int i = index; i < arr.length; i++) {
            // Skip duplicates by ensuring we only pick the first occurrence of a number
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            
            // If the current number is greater than the target, stop further exploration
            if (arr[i] > target) {
                break;
            }
            
            // Include the current number in the combination
            currentCombination.add(arr[i]);
            
            // Recur for the next index with the reduced target (as elements can't be reused)
            backtrack(arr, i + 1, target - arr[i], currentCombination, result);
            
            // Backtrack: remove the last added number to explore other possibilities
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        
        // Example input
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        
        // Get the result
        List<List<Integer>> result = solution.CombinationSum2(arr, arr.length, target);
        
        // Print the result
        System.out.println("Unique combinations where the sum equals "+  result);
        
    }
}
