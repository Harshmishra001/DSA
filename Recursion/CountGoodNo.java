// Expected Time Complexity: O(logN)
// Expected Auxiliary Space: O(1)

public class CountGoodNo {
    // Constant for modulo to avoid overflow in large number calculations
    private static final int mod = 1000000007;
    
    // Method to count good numbers in a sequence of length N
    public static int countGoodNumbers(long N) {
        // Calculate the number of even and odd indices
        long even = (N + 1) / 2; // Even indices count
        long odd = N / 2;        // Odd indices count
        
        // Compute the number of ways to fill the even and odd positions
        long first = pow(5, even) % mod;   //  5 choices (even digits: 0, 2, 4, 6, 8)
        long second = pow(4, odd) % mod;   //  4 choices (prime digits: 2, 3, 5, 7).
        
        // Multiply the results and return the final result modulo mod
        return (int)((first * second) % mod);
    }
    
    // Helper method to compute x^n % mod using efficient exponentiation by squaring
    private static long pow(long x, long n) {
        if (n == 0) return 1;  // Base case: any number to the power 0 is 1
        
        // If n is even, square the result
        if (n % 2 == 0) {
            long temp = pow(x, n / 2);  // Recursively calculate x^(n/2)
            return (temp * temp) % mod;
        } else {
            long temp = pow(x, n - 1);
            // If n is odd, multiply one more x to the squared result
            return (x * temp ) % mod;
        }
    }

    // Main method to run a test case for debugging
    public static void main(String[] args) {
        long N = 3;  // Test case with N = 4
        
        // Debugging messages
        System.out.println("Test Case: N = " + N);
        
        // Call countGoodNumbers with the test case value
        int result = countGoodNumbers(N);
        
        // Output the result
        System.out.println("Result: " + result);
    }
}

    

/*Example 1:

Input:
N = 1

Explanation:

Since N = 1, there is only 1 position in the string.

This position is an even-indexed position (since it's the 0th position).

As per the rules, even-indexed positions can take any of the 5 even digits: {0, 2, 4, 6, 8}.

Thus, the possible "good digit strings" of length 1 are: "0", "2", "4", "6", "8"
Therefore, the output is 5.

Example 2:
Input:
N = 3
Explanation:

Since N = 3, we have 3 positions: position 0, position 1, and position 2.

Positions 0 and 2 are even-indexed positions, and even indices can take any of the 5 even digits: {0, 2, 4, 6, 8}.
Position 1 is an odd-indexed position, and odd indices can take any of the 4 prime digits: {2, 3, 5, 7}.

So, the number of good digit strings can be calculated as:
For position 0 (even index): 5 choices.
For position 1 (odd index): 4 choices.
For position 2 (even index): 5 choices.

Total number of possible good digit strings is: 5×4×5=100
Thus, the output is 100.

Summary:
For even-indexed positions, there are 5 choices (even digits: 0, 2, 4, 6, 8).
For odd-indexed positions, there are 4 choices (prime digits: 2, 3, 5, 7).
*/