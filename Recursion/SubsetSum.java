 
//  QN. SIMILAR TO PERFECT SUM  WITH SMALL CHNAGE THAT IS PERFECTSUM FUNCTION DATA TYPE IS INT BUT SUBSET SUM DATATYPE IS BOOLEAN
 

// Time Complexity: O(N * S), where N is the number of elements in the array, and S is the target sum.
//Space Complexity: O(S), as the space required is proportional to the target sum S.
public class SubsetSum {

    // Function to check if there is a subset with the given sum
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // Create a dp array of size sum+1 where dp[i] will be true if there's a subset
        // with sum equal to i
        boolean[] dp = new boolean[sum + 1];

        // Initialize dp[0] as true because there's always one way to make sum 0 (by choosing no elements)
        dp[0] = true;

        // Iterate through the array
        for (int i = 0; i < N; i++) {
            // Traverse dp array backwards from 'sum' to 'arr[i]'
            // This ensures that we are using each element at most once
            for (int j = sum; j >= arr[i]; j--) {
                // Update dp[j] to true if dp[j - arr[i]] is true (i.e., if we can form the sum j)
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        // Return true if we can form the sum, otherwise false
        return dp[sum];
    }

    public static void main(String[] args) {
        // Example input array and sum
        int arr[] = {3, 34, 4, 12, 5, 2};
        int n = arr.length;
        int sum = 9;  // Adjusted to a reachable sum for demonstration

        // Call the isSubsetSum method and store the result
        boolean result = isSubsetSum(n, arr, sum);

        // Print the result
        if (result) {
            System.out.println("There is a subset with sum " + sum + ":True");
        } else {
            System.out.println("There is no subset with sum " + sum +":False");
        }
    }
}
