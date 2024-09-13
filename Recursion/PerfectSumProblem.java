// Count all subsequences with sum K
// Input: 
// n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
// Output: 
// 3
// Explanation: 
// {5, 2, 3}, {2, 8}, {10} are possible subsets.


class PerfectSumProblem {

    // Method to calculate the number of subsets that sum up to the given 'sum'.
    public int perfectSum(int arr[], int n, int sum) {
        // Create a dp array of size sum+1 to store the count of subsets for each sum
        int[] dp = new int[sum + 1];

        // Initialize dp[0] as 1 because there's always one way to make sum 0 (by choosing no elements)
        dp[0] = 1;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Traverse dp array backwards from 'sum' to 'arr[i]'
            for (int j = sum; j >= arr[i]; j--) {
                // Update dp[j] by adding the number of ways to form (j-arr[i]) sum
                dp[j] = (dp[j] + dp[j - arr[i]]) % 1000000007;

                // // Debug statement to print dp array at each update
                // System.out.println("dp[" + j + "] = " + dp[j]);
            }
        }

        // Return the number of ways to form the 'sum', modulo 1000000007
        return dp[sum] % 1000000007;
    }

    // Main method to test the perfectSum function
    public static void main(String[] args) {
        PerfectSumProblem  solution = new PerfectSumProblem();

        // Example input array and sum
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int sum = 10;

        // Call the perfectSum method and store the result
        int result = solution.perfectSum(arr, n, sum);

        // Print the result
        System.out.println("The number of subsets with sum " + sum + " is: " + result);
    }
}

