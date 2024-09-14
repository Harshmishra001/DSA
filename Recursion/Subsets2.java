import java.util.ArrayList;
import java.util.Arrays;
// Input: 
// nums = [1,2,2] 
// Output: 
// [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Explanation: 
// We can have subsets ranging from length 0 to 3. which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.
// Expected Time Complexity: O(2N).
// Expected Auxiliary Space: O(2N).


// QN. SIMILAR TO COMBINATIONSUM2 BUT THERE TARGET IS GIVEN HRE WITHOUT TARGET

class Subsets2 {      

    // Function to print all unique subsets
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        Arrays.sort(nums);  // Sort the array to handle duplicates
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        solve(0, nums, ans, al);
        return ans;
    }

    // Helper function to generate subsets using backtracking
    public static void solve(int indx, int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> al) {
        ans.add(new ArrayList<>(al));  // Add the current subset to the result
        for (int i = indx; i < arr.length; i++) {
            // Skip duplicate elements
            if (i > indx && arr[i] == arr[i - 1]) continue;
            
            al.add(arr[i]);  // Include the current element
            solve(i + 1, arr, ans, al);  // Recur for the next index
            al.remove(al.size() - 1);  // Backtrack to explore other possibilities
        }
    }

    public static void main(String[] args) {
        // Example input array
        int[] nums = {1, 2, 2};

        // Call the function to get unique subsets
        ArrayList<ArrayList<Integer>> result = printUniqueSubsets(nums);

        // Print the result
        System.out.println("Unique subsets are: ");
        for (ArrayList<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
