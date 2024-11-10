
// Problem Statement: Given an array containing both positive and negative integers, 
// we have to find the length of the longest subarray with the sum of all elements equal to zero.

// Examples

// Example 1:
// Input Format
// : N = 6, array[] = {9, -3, 3, -1, 6, -5}
// Result
// : 5
// Explanation
// : The following subarrays sum to zero:
// {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
// Since we require the length of the longest subarray, our answer is 5!

// Example 2:
// Input Format:
//  N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
// Result
// : 8
// Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
// Length of longest subarray = 8

// Example 3:
// Input Format:
//  N = 3, array[] = {1, 0, -5}
// Result
// : 1
// Subarray : {0}
// Length of longest subarray = 1

// Example 4:
// Input Format:
//  N = 5, array[] = {1, 3, -5, 6, -2}
// Result
// : 0
// Subarray: There is no subarray that sums to zero



// BRUTE-FORCE APPROACH
// Time Complexity: O(N^2) as we have two loops for traversal

// Space Complexity: O(1) as we aren’t using any extra space.
// import java.util.*;

// public class LargestSubarraySumzero {
//     static int solve(int[] a) {
//         int max = 0;
//         for (int i = 0; i < a.length; ++i) {
//             int sum = 0;
//             for (int j = i; j < a.length; ++j) {
//                 sum += a[j];
//                 // Check if the subarray sum is zero
//                 if (sum == 0) {
//                     // Update max length of subarray
//                     max = Math.max(max, j - i + 1);
//                 }
//             }
//         }
//         return max;
//     }

//     public static void main(String args[]) {
//         int a[] = {9, -3, 3, -1, 6, -5};
//         System.out.println(solve(a));
//     }
// }

/*
Dry Run:

Input:
  a[] = {9, -3, 3, -1, 6, -5}

Initial state:
  max = 0

Step 1: Outer loop (i = 0):
  i = 0
    Inner loop (j):
      j = 0, sum = 9 (not zero)
      j = 1, sum = 6 (not zero)
      j = 2, sum = 9 (not zero)
      j = 3, sum = 8 (not zero)
      j = 4, sum = 14 (not zero)
      j = 5, sum = 9 (not zero)

Step 2: Outer loop (i = 1):
  i = 1
    Inner loop (j):
      j = 1, sum = -3 (not zero)
      j = 2, sum = 0 (zero found, subarray = {-3, 3})
        max = Math.max(0, 2 - 1 + 1) = 2
      j = 3, sum = -1 (not zero)
      j = 4, sum = 5 (not zero)
      j = 5, sum = 0 (zero found, subarray = {-3, 3, -1, 6, -5})
        max = Math.max(2, 5 - 1 + 1) = 5

Step 3: Outer loop (i = 2):
  i = 2
    Inner loop (j):
      j = 2, sum = 3 (not zero)
      j = 3, sum = 2 (not zero)
      j = 4, sum = 8 (not zero)
      j = 5, sum = 3 (not zero)

Step 4: Outer loop (i = 3):
  i = 3
    Inner loop (j):
      j = 3, sum = -1 (not zero)
      j = 4, sum = 5 (not zero)
      j = 5, sum = 0 (zero found, subarray = {-1, 6, -5})
        max = Math.max(5, 5 - 3 + 1) = 5

Step 5: Outer loop (i = 4):
  i = 4
    Inner loop (j):
      j = 4, sum = 6 (not zero)
      j = 5, sum = 1 (not zero)

Step 6: Outer loop (i = 5):
  i = 5
    Inner loop (j):
      j = 5, sum = -5 (not zero)

Final Output:
  max = 5

Output:
5
*/


// OPTIMAL APPROACH

// Time Complexity: O(N), as we are traversing the array only once

// Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap

import java.util.*;

public class LargestSubarraySumzero {
    static int maxLen(int A[], int n) {
        // HashMap to store (prefix sum, index)
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int maxi = 0; // Variable to store the maximum length
        int sum = 0;  // Variable to store the prefix sum

        // Traverse the array
        for (int i = 0; i < n; i++) {
            sum += A[i]; // Update the prefix sum

            // Case 1: If the prefix sum is zero, update maxi
            if (sum == 0) {
                maxi = i + 1;
            }
            // Case 2: If the prefix sum is already in the map
            else if (mpp.containsKey(sum)) {
                // Calculate the length of the subarray with sum zero
                maxi = Math.max(maxi, i - mpp.get(sum));
            }
            // Case 3: If the prefix sum is not in the map, add it
            else {
                mpp.put(sum, i);
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int A[] = {9, -3, 3, -1, 6, -5};
        int n = A.length;
        System.out.println("Length of the longest subarray with sum 0: " + maxLen(A, n));
    }
}

/*
Dry Run:

Input:
  A[] = {9, -3, 3, -1, 6, -5}
  n = 6

Initial state:
  maxi = 0
  sum = 0
  mpp = {}

Step 1: i = 0
  A[0] = 9
  sum = 0 + 9 = 9
  mpp = {}
  sum is not 0 and not in mpp, so add (9, 0) to mpp
  mpp = {9: 0}

Step 2: i = 1
  A[1] = -3
  sum = 9 + (-3) = 6
  mpp = {9: 0}
  sum is not 0 and not in mpp, so add (6, 1) to mpp
  mpp = {9: 0, 6: 1}

Step 3: i = 2
  A[2] = 3
  sum = 6 + 3 = 9
  mpp = {9: 0, 6: 1}
  sum (9) is already in mpp at index 0
  maxi = max(0, 2 - 0) = 2

Step 4: i = 3
  A[3] = -1
  sum = 9 + (-1) = 8
  mpp = {9: 0, 6: 1}
  sum is not 0 and not in mpp, so add (8, 3) to mpp
  mpp = {9: 0, 6: 1, 8: 3}

Step 5: i = 4
  A[4] = 6
  sum = 8 + 6 = 14
  mpp = {9: 0, 6: 1, 8: 3}
  sum is not 0 and not in mpp, so add (14, 4) to mpp
  mpp = {9: 0, 6: 1, 8: 3, 14: 4}

Step 6: i = 5
  A[5] = -5
  sum = 14 + (-5) = 9
  mpp = {9: 0, 6: 1, 8: 3, 14: 4}
  sum (9) is already in mpp at index 0
  maxi = max(2, 5 - 0) = 5

Final Output:
  maxi = 5

Output:
Length of the longest subarray with sum 0: 5


*/