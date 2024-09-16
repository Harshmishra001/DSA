import java.util.Arrays;

class PalindromPartitioning {
    
    // Function to find the minimum number of cuts required to partition the string into palindromes.
    static int palindromicPartition(String s) {
        int n = s.length();

        // DP array to store the minimum cuts needed for substring `s[i...n-1]`
        int[] dp = new int[n];
        Arrays.fill(dp, -1);  // Initialize DP array with -1 (indicating uncomputed subproblems)

        // Call the recursive function starting from index 0
        // Subtract 1 because the algorithm counts an extra partition after the end of the string, which is invalid
        return getMinPartition(0, n, s, dp) - 1;    
    }
    
    
    // Helper function to recursively find the minimum number of partitions for the substring `s[i...n-1]`
    private static int getMinPartition(int i, int n, String s, int[] dp) {
        // Base case: If we've reached the end of the string, no more partitions are needed
        if (i == n) {
            return 0;
        }

        // If the result for the current subproblem is already computed, return it
        if (dp[i] != -1) return dp[i];

        // Initialize the minimum number of partitions to a large value
        int mini = Integer.MAX_VALUE;

        // Try partitioning the string at every position `k` such that `s[i...k]` is a palindrome
        for (int k = i; k < n; k++) {
            // Check if the substring `s[i...k]` is a palindrome
            if (isPalindrome(i, k, s)) {
                // If it's a palindrome, recursively compute the minimum cuts for the remaining substring `s[k+1...n-1]`
                int partition = 1 + getMinPartition(k + 1, n, s, dp);

                // Update the minimum partitions required
                mini = Math.min(mini, partition);
            }
        }

        // Store the result for the current subproblem in the DP array
        return dp[i] = mini;
    }

    // Helper function to check if the substring `s[i...j]` is a palindrome
    private static boolean isPalindrome(int i, int j, String s) {
        // Check if the substring is the same when read forwards and backwards
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case
        String input = "aab";
        
        // Call the palindromicPartition method
        int result = palindromicPartition(input);
        
        // Print the result
        System.out.println("Minimum cuts required for palindromic partitioning: " + result);
    }
}

// Let's break down the step-by-step execution of the provided code using the test case `"aab"`:

// Input:
// String input = "aab";


// ### Step 1: Initialization

// - We start by calling the `palindromicPartition` method:
//   int result = palindromicPartition(input);


//  Step 2: Setup Dynamic Programming (DP) Array

// - Inside the `palindromicPartition` function, the length of the string `n` is calculated as `n = 3` (since the string is `"aab"`).
// - A DP array `dp[]` of size `n` is initialized with all values set to `-1`:

//   dp[] = [-1, -1, -1]

//  Step 3: Recursive Call to `getMinPartition`

// - We now call the helper function `getMinPartition(0, 3, "aab", dp)`. Here:
//   - `i = 0`: Starting index.
//   - `n = 3`: Length of the string.
//   - `s = "aab"`.
//   - `dp[] = [-1, -1, -1]`.

// Step 4: Recursive Traversal for Substring `"aab"`

// We enter the `getMinPartition` function for the substring `"aab"` starting at index `i = 0`. We check all possible partitions starting from this index.

//  Partition at index `k = 0` (`s[0...0] = "a"`):
// - We check if the substring `"a"` is a palindrome:
//   isPalindrome(0, 0, "aab") returns true

// - Since `"a"` is a palindrome, we recursively compute the minimum cuts for the remaining substring `"ab"` by calling:

//   getMinPartition(1, 3, "aab", dp)
//  Step 5: Recursive Traversal for Substring `"ab"`

// We now process the substring `"ab"` starting at `i = 1`.

// Partition at index `k = 1` (`s[1...1] = "a"`):
// - We check if the substring `"a"` is a palindrome:

//   isPalindrome(1, 1, "aab") returns true

// - Since `"a"` is a palindrome, we recursively compute the minimum cuts for the remaining substring `"b"` by calling:

//   getMinPartition(2, 3, "aab", dp)


//  Step 6: Recursive Traversal for Substring `"b"`

// We now process the substring `"b"` starting at `i = 2`.

//  Partition at index `k = 2` (`s[2...2] = "b"`):
// - We check if the substring `"b"` is a palindrome:

//   isPalindrome(2, 2, "aab") returns true

// - Since `"b"` is a palindrome, we reach the end of the string and return `0` because no more partitions are needed:

//   getMinPartition(3, 3, "aab", dp) returns 0

// - The recursive call for `getMinPartition(2, 3, "aab", dp)` returns `1` (since `partition = 1 + 0`):

//   dp[] = [-1, -1, 1]


// Step 7: Returning to Substring `"ab"`

// We return to the recursive call for `getMinPartition(1, 3, "aab", dp)` with the minimum cuts needed for `"b"` known to be `1`. Thus, the partition `"a"` results in:

//   partition = 1 + 1 = 2

// - Next, we check the next possible partition for the substring `"ab"`:

//  Partition at index `k = 2` (`s[1...2] = "ab"`):
// - We check if the substring `"ab"` is a palindrome:

//   isPalindrome(1, 2, "aab") returns false

// - Since `"ab"` is not a palindrome, we skip this partition.
// - The minimum cuts needed for `"ab"` remains `2`, so we store the result in `dp[1]`:

//   dp[] = [-1, 2, 1]

//  Step 8: Returning to Substring `"aab"`

// We return to the recursive call for `getMinPartition(0, 3, "aab", dp)` with the minimum cuts needed for `"ab"` known to be `2`. Thus, the partition `"a"` results in:

//   partition = 1 + 2 = 3


//  Partition at index `k = 1` (`s[0...1] = "aa"`):
// - We check if the substring `"aa"` is a palindrome:

//   isPalindrome(0, 1, "aab") returns true

// - Since `"aa"` is a palindrome, we recursively compute the minimum cuts for the remaining substring `"b"` by calling:

//   getMinPartition(2, 3, "aab", dp)

// - We already know the minimum cuts for `"b"` is `1` from a previous calculation. Thus, the partition `"aa"` results in:

//   partition = 1 + 1 = 2


// Partition at index `k = 2` (`s[0...2] = "aab"`):
// - We check if the substring `"aab"` is a palindrome:

//   isPalindrome(0, 2, "aab") returns false

// - Since `"aab"` is not a palindrome, we skip this partition.

// Step 9: Final Result

// The minimum cuts needed for the entire string `"aab"` is `1`, so we store the result in `dp[0]`:

//   dp[] = [1, 2, 1]


// The final result is `1`, which means that the minimum number of cuts required to partition `"aab"` into palindromes is `1`.

// Output:
// Minimum cuts required for palindromic partitioning: 1

// This matches the expected output, where the string `"aab"` can be partitioned into `["aa", "b"]` with 1 cut.