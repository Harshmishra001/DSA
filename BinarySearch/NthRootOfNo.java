package BinarySearch;

// Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. 
// If the 'nth root is not an integer, return -1.

// Examples
// Example 1:
// Input Format:
//  N = 3, M = 27
// Result:
//  3
// Explanation:
//  The cube root of 27 is equal to 3.

// Example 2:
// Input Format:
//  N = 4, M = 69
// Result:
//  -1
// Explanation:
//  The 4th root of 69 does not exist. So, the answer is -1.




// Brute Force approach

// Time Complexity: O(M), M = the given number.
// Reason: Since we are using linear search, we traverse the entire answer space.

// Space Complexity: O(1) as we are not using any extra space.

/* import java.util.*;

public class NthRootOfNo {

    // Power exponential method:
    public static long func(int b, int exp) {
        long ans = 1; // Initialize result as 1
        long base = b; // The base value to be raised to the power
        // Using the method of exponentiation by squaring to efficiently calculate power
        while (exp > 0) {
            // If the exponent is odd, multiply the result by the current base
            if (exp % 2 == 1) {
                exp--; // Reduce exponent by 1
                ans = ans * base; // Multiply the result by the base
            } else {
                // If exponent is even, square the base and halve the exponent
                exp /= 2; 
                base = base * base; // Square the base
            }
        }
        return ans; // Return the final result
    }

    // Method to find the Nth root of a number m
    public static int NthRoot(int n, int m) {
        // Use linear search on the answer space (1 to m)
        for (int i = 1; i <= m; i++) {
            // Calculate i raised to the power of n
            long val = func(i, n);
            // If i^n equals m, we've found the Nth root
            if (val == (long) m) return i;
            // If i^n exceeds m, we can stop since the Nth root can't be greater than m
            else if (val > (long) m) break;
        }
        return -1; // Return -1 if no such integer Nth root exists
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        int n = 3, m = 27; // We want the 3rd root of 27
        int ans = NthRoot(n, m); // Find the 3rd root of 27
        System.out.println("The answer is: " + ans); // Output the result
    }
*/

/*
Dry Run Walkthrough:

1. **Input:** n = 3, m = 27 (We want to find the 3rd root of 27).
2. **Method Call:** NthRoot(3, 27)
   
   a. We start a loop where i goes from 1 to 27 (the search space for the Nth root).
   
   - **Iteration 1 (i = 1):**
     - Call `func(1, 3)` to calculate 1^3.
     - Inside `func`: base = 1, exp = 3.
       - Since exp is odd, multiply the result by the base: ans = 1 * 1 = 1.
       - Decrease exp by 1: exp = 2.
       - Now exp is even, so square the base: base = 1 * 1 = 1.
       - Halve exp: exp = 1.
       - Now exp is odd again, so multiply the result by the base: ans = 1 * 1 = 1.
       - Decrease exp by 1: exp = 0 (exit loop).
     - `func(1, 3)` returns 1.
     - Since 1 != 27, continue to the next iteration.

   - **Iteration 2 (i = 2):**
     - Call `func(2, 3)` to calculate 2^3.
     - Inside `func`: base = 2, exp = 3.
       - Since exp is odd, multiply the result by the base: ans = 1 * 2 = 2.
       - Decrease exp by 1: exp = 2.
       - Now exp is even, so square the base: base = 2 * 2 = 4.
       - Halve exp: exp = 1.
       - Now exp is odd again, so multiply the result by the base: ans = 2 * 4 = 8.
       - Decrease exp by 1: exp = 0 (exit loop).
     - `func(2, 3)` returns 8.
     - Since 8 != 27, continue to the next iteration.

   - **Iteration 3 (i = 3):**
     - Call `func(3, 3)` to calculate 3^3.
     - Inside `func`: base = 3, exp = 3.
       - Since exp is odd, multiply the result by the base: ans = 1 * 3 = 3.
       - Decrease exp by 1: exp = 2.
       - Now exp is even, so square the base: base = 3 * 3 = 9.
       - Halve exp: exp = 1.
       - Now exp is odd again, so multiply the result by the base: ans = 3 * 9 = 27.
       - Decrease exp by 1: exp = 0 (exit loop).
     - `func(3, 3)` returns 27.
     - Since 27 == 27, we've found the answer: the 3rd root of 27 is 3.

3. **Output:** The answer is 3. 
*/




// Optimal Approach

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using binary search to find the minimum.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


import java.util.*;

public class  NthRootOfNo {

    // Helper function that compares mid^n with m
    // Returns 1 if mid^n == m
    // Returns 0 if mid^n < m
    // Returns 2 if mid^n > m
    public static int func(int mid, int n, int m) {
        long ans = 1; // Initialize the result as 1
        for (int i = 1; i <= n; i++) {
            ans = ans * mid; // Multiply mid n times
            if (ans > m) return 2; // If result exceeds m, return 2 (indicating mid^n > m)
        }
        if (ans == m) return 1; // If result equals m, return 1 (indicating mid^n == m)
        return 0; // Otherwise, return 0 (indicating mid^n < m)
    }

    // Method to find the Nth root of a number m using binary search
    public static int NthRoot(int n, int m) {
        // Binary search between low and high
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2; // Midpoint of the current search space
            int midN = func(mid, n, m); // Calculate mid^n and compare with m using func()

            if (midN == 1) {
                return mid; // Found the Nth root, return mid
            } else if (midN == 0) {
                low = mid + 1; // Increase low, as mid^n is too small
            } else {
                high = mid - 1; // Decrease high, as mid^n is too large
            }
        }
        return -1; // Return -1 if no integer Nth root is found
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        int n = 3, m = 27; // We want the 3rd root of 27
        int ans = NthRoot(n, m); // Find the 3rd root of 27
        System.out.println("The answer is: " + ans); // Output the result
    }
}

/*
Dry Run Walkthrough:

1. **Input:** n = 3, m = 27 (We want to find the 3rd root of 27).
2. **Method Call:** NthRoot(3, 27)
   
   a. We initialize the binary search range with low = 1 and high = 27.

   b. **First Iteration:**
      - Mid = (1 + 27) / 2 = 14.
      - Call `func(14, 3, 27)` to calculate 14^3 = 2744.
      - Inside `func`: Since 2744 > 27, return 2 (indicating mid^n > m).
      - Set `high = 14 - 1 = 13` and continue the binary search.

   c. **Second Iteration:**
      - Mid = (1 + 13) / 2 = 7.
      - Call `func(7, 3, 27)` to calculate 7^3 = 343.
      - Inside `func`: Since 343 > 27, return 2 (indicating mid^n > m).
      - Set `high = 7 - 1 = 6` and continue the binary search.

   d. **Third Iteration:**
      - Mid = (1 + 6) / 2 = 3.
      - Call `func(3, 3, 27)` to calculate 3^3 = 27.
      - Inside `func`: Since 27 == 27, return 1 (indicating mid^n == m).
      - Return `mid = 3` as the 3rd root of 27.

3. **Output:** The answer is 3. 
*/
