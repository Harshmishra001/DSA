import java.util.*;

class CombinationSum
{
    // Function to return a list of indexes denoting the required 
    // combinations whose sum is equal to the given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // This will store the final combinations
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
     
        // Sort the array to ensure combinations are in non-descending order
        Collections.sort(A);  
        
        // Call the helper function
        helperfunction(A, 0, B, temp, result);
        
        // Return the result
        return result;
    }
    
    // Recursive backtracking function to find the combinations.
    static void helperfunction(ArrayList<Integer> A, int ind, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        // Base case: if target becomes zero, add the combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // Iterate through the array starting from 'ind'
        for (int i = ind; i < A.size(); i++) {
            // Skip duplicates
            if (i > ind && A.get(i) == A.get(i - 1)) {
                continue;
            }
            
            // If the current element exceeds the target, stop the loop
            if (A.get(i) > target) break;
            
            // Include the current element in the combination
            temp.add(A.get(i));
            
            // Recur to include the same element again (as elements can be reused)
            helperfunction(A, i, target - A.get(i), temp, result);
            
            // Backtrack by removing the last added element
            temp.remove(temp.size() - 1);
        }
    }
    
    // Main method to run the solution
    public static void main(String[] args) {
        // Input array
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 2, 6, 5));
        int targetSum = 16;
        
        // Get the combinations
        ArrayList<ArrayList<Integer>> result = combinationSum(arr, targetSum);
        
        // Print the result
        System.out.println(result);
    }
}
