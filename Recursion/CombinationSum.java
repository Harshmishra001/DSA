
import java.util.*;

class CombinationSum
{
    // Function to return a list of indexes denoting the required 
    // combinations whose sum is equal to the given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);  // Sort the array to ensure non-descending order in combinations
        solve(A, 0, B, temp, ans);
        return ans;
    }
    
    // Recursive backtracking function to find the combinations.
    static void solve(ArrayList<Integer> A, int ind, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        // Base case: if target becomes zero, add the combination to the answer
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        // Iterate through the array starting from 'ind'
        for(int i = ind; i < A.size(); i++) {
            // Skip duplicates
            if(i > ind && A.get(i) == A.get(i-1)) {
                continue;
            }
            // If the current element exceeds the target, stop the loop
            if(A.get(i) > target) break;
            
            // Include the current element in the combination
            temp.add(A.get(i));
            
            // Recur to include the same element again (as elements can be reused)
            solve(A, i, target - A.get(i), temp, ans);
            
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
        
       System.out.println( result);
    }
}


// Let's walk through the step-by-step execution of the program. We'll break down each phase and describe what happens during the recursive backtracking process.

// ### Input:
// ```
// N = 4
// arr[] = {7, 2, 6, 5}
// B = 16
// ```

// ### Step 1: Sort the Array
// The first step is to sort the input array to ensure combinations are generated in non-descending order.

// - Before sorting: `arr[] = {7, 2, 6, 5}`
// - After sorting: `arr[] = {2, 5, 6, 7}`

// ### Step 2: Call `combinationSum`
// - Call the `combinationSum` method with the sorted array `{2, 5, 6, 7}` and the target sum `B = 16`.

// ### Step 3: Backtracking Process
// The core of the algorithm is the `solve` function, which uses recursive backtracking. Here's a breakdown of the recursive process:

// 1. **First Call (index 0, target 16)**
//    - We start from index `0`, which is element `2`.
//    - We subtract `2` from the target, so `target = 16 - 2 = 14`.
//    - Now, we recursively call `solve` with the updated target `14`.

// 2. **Second Call (index 0, target 14)**
//    - We continue from index `0` (element `2`).
//    - Subtract `2`, so `target = 14 - 2 = 12`.
//    - Recursively call `solve` with the updated target `12`.

// 3. **Third Call (index 0, target 12)**
//    - We subtract `2`, so `target = 12 - 2 = 10`.
//    - Recursively call `solve` with target `10`.

// 4. **Continue the Process...**
//    This process continues, subtracting `2` repeatedly from the target, until we get:

//    ```
//    target = 16 - 2 - 2 - 2 - 2 - 2 - 2 - 2 - 2 = 0
//    ```

//    - When the `target` reaches `0`, we have found a valid combination: `[2, 2, 2, 2, 2, 2, 2, 2]`.
//    - Add this combination to the result list.

// 5. **Backtrack**
//    After adding the valid combination, we backtrack:
//    - We remove the last added `2`, so the current combination becomes `[2, 2, 2, 2, 2, 2, 2]`.
//    - Now, we explore other possibilities by adding different elements instead of continuing with just `2`.

// 6. **Switch to Next Element (index 1, element 5)**
//    - Try adding `5` instead of `2`.
//    - New target: `16 - 2 - 2 - 2 - 2 - 2 - 2 = 6`.
//    - Recursively call `solve` with the new target.

// 7. **Next Valid Combination**
//    - Continue the process similarly, and find combinations like `[2, 2, 2, 2, 2, 6]`.

// 8. **Explore All Combinations**
//    - This process is repeated for all elements (5, 6, 7), and for each element, the algorithm tries to find all valid combinations whose sum equals `16`.

// ### Step 4: Output
// The recursive exploration generates all valid combinations that sum to `16`. These combinations are stored in the result list, and once the recursive function completes, the `combinationSum` method returns the final result.

// ### Final Output:
// ```
// [[2, 2, 2, 2, 2, 2, 2, 2], 
//  [2, 2, 2, 2, 2, 6], 
//  [2, 2, 2, 5, 5], 
//  [2, 2, 5, 7], 
//  [2, 2, 6, 6], 
//  [2, 7, 7], 
//  [5, 5, 6]]
// ```

// ### Detailed Backtracking Path:
// - Initially, the combination `[2, 2, 2, 2, 2, 2, 2, 2]` is found.
// - Then, we backtrack, explore other combinations by replacing some `2`s with other elements like `5`, `6`, or `7`.
// - Every time the `target` becomes `0`, a valid combination is recorded.
// - If the target goes negative or no valid combination is found, the algorithm backtracks by removing the last added number and continues the search.

// ### Efficiency Considerations:
// - **Avoiding Duplicates**: The condition `if(i > ind && A.get(i) == A.get(i-1))` helps in skipping duplicate elements to avoid generating duplicate combinations.
// - **Pruning**: The check `if(A.get(i) > target)` ensures that we stop further exploration if the current number exceeds the remaining target.

// By the end of this process, we get all the unique combinations that sum up to the target value `16`.