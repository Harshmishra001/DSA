// Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray
//  that sums to k.

// Examples
// Example 1:
// Input Format: N = 3, k = 5, array[] = {2,3,5}
// Result: 2
// Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

// Example 2:
// Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
// Result: 3
// Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.

// BRUTE-FORCE APPROACH

// T.C->O(N^3)
// S.C->O(1)

import java.util.*;

// public class LongestSubarraywithgivenSumK {
//     public static int getLongestSubarray(int[] a, long k) {

//         int n = a.length; // size of the array.

//         int len = 0;
//         for (int i = 0; i < n; i++) { // starting index
//             for (int j = i; j < n; j++) { // ending index
//                 // add all the elements of subarray = a[i...j]:
//                 long s = 0;
//                 for (int K = i; K <= j; K++) {
//                     s += a[K];
//                 }

//                 if (s == k)
//                     len = Math.max(len, j - i + 1);
//             }
//         }
//         return len;
//     }

//     public static void main(String[] args) {
//         int[] a = {2, 3, 5, 1, 9};
//         long k = 10;
//         int len = getLongestSubarray(a, k);
//         System.out.println("The length of the longest subarray is: " + len);
//     }
// }

/*
Dry Run:

1. Input array: a = {2, 3, 5, 1, 9}, k = 10
2. n = a.length => n = 5
3. Initialize len = 0

Outer loop (i):
- i = 0:
  - Inner loop (j):
    - j = 0: subarray = {2} -> sum = 2 (not equal to k)
    - j = 1: subarray = {2, 3} -> sum = 5 (not equal to k)
    - j = 2: subarray = {2, 3, 5} -> sum = 10 (equal to k) -> len = 3
    - j = 3: subarray = {2, 3, 5, 1} -> sum = 11 (not equal to k)
    - j = 4: subarray = {2, 3, 5, 1, 9} -> sum = 20 (not equal to k)

- i = 1:
  - j = 1: subarray = {3} -> sum = 3 (not equal to k)
  - j = 2: subarray = {3, 5} -> sum = 8 (not equal to k)
  - j = 3: subarray = {3, 5, 1} -> sum = 9 (not equal to k)
  - j = 4: subarray = {3, 5, 1, 9} -> sum = 18 (not equal to k)

- i = 2:
  - j = 2: subarray = {5} -> sum = 5 (not equal to k)
  - j = 3: subarray = {5, 1} -> sum = 6 (not equal to k)
  - j = 4: subarray = {5, 1, 9} -> sum = 15 (not equal to k)

- i = 3:
  - j = 3: subarray = {1} -> sum = 1 (not equal to k)
  - j = 4: subarray = {1, 9} -> sum = 10 (equal to k) -> len = 2

- i = 4:
  - j = 4: subarray = {9} -> sum = 9 (not equal to k)

Final value of len = 3 (from subarray {2, 3, 5}).

Final output: "The length of the longest subarray is: 3"
*/



// OPTIMAL APPROACH   (using 2 pointer)

// Time Complexity: O(2*N), where N = size of the given array.
// Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index). Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. So, every time the inner loop does not run for n times rather it can run for n times in total. So, the time complexity will be O(2*N) instead of O(N2).

// Space Complexity: O(1) as we are not using any extra space.

import java.util.*;

public class LongestSubarraywithgivenSumK {
  public static int getLongestSubarray(int []a, long k) {
    
      int n = a.length; // Size of the input array.

      int left = 0, right = 0; // Two pointers for the sliding window.

      long sum = a[0]; // Initialize the sum with the first element.
      int maxLen = 0; // Variable to track the maximum length of subarray found.

      while (right < n) {
          // If the sum is greater than k, reduce the subarray from the left
          // until the sum becomes less than or equal to k.
          while (left <= right && sum > k) {
              sum -= a[left]; // Subtract the leftmost element from the sum.
              left++; // Move the left pointer to the right.
          }
          // If the current sum equals k, update maxLen.
          if (sum == k) {
              maxLen = Math.max(maxLen, right - left + 1); // Update maxLen if this length is greater.
          }

          // Move the right pointer forward.
          right++;
          if (right < n) {
              sum += a[right]; // Add the next element to the sum.
          }
      }

      return maxLen; // Return the maximum length found.
  }

  public static void main(String[] args) {
      int[] a = {2, 3, 5}; // Example input array.
      long k = 5; // Target sum.
      int len = getLongestSubarray(a, k); // Call the function.
      System.out.println("The length of the longest subarray is: " + len); // Print the result.
  }
}

/* 
Dry Run of getLongestSubarray(a, k) with a = {2, 3, 5} and k = 5

1. Initialization:
 - left = 0
 - right = 0
 - sum = a[0] = 2
 - maxLen = 0
 - n = 3 (length of the array)

2. First Iteration (right = 0):
 - Current sum: sum = 2
 - Check if sum < k: (2 < 5) → true
 - Move right pointer to 1.
 - Add next element to sum: sum += a[right] → sum = 2 + 3 = 5

3. Second Iteration (right = 1):
 - Current sum: sum = 5
 - Check if sum == k: (5 == 5) → true
 - Update maxLen: maxLen = Math.max(maxLen, right - left + 1) → maxLen = Math.max(0, 1 - 0 + 1) = 2
 - Move right pointer to 2.
 - Add next element to sum: sum += a[right] → sum = 5 + 5 = 10

4. Third Iteration (right = 2):
 - Current sum: sum = 10
 - Check if sum > k: (10 > 5) → true
 - While sum > k:
   - Subtract a[left] from sum: sum -= a[left] → sum = 10 - 2 = 8
   - Move left pointer: left++ → left = 1
   - Check if sum > k: (8 > 5) → true
   - Subtract a[left] from sum: sum -= a[left] → sum = 8 - 3 = 5
   - Move left pointer: left++ → left = 2
   - Check if sum == k: (5 == 5) → true
   - Update maxLen: maxLen = Math.max(maxLen, right - left + 1) → maxLen = Math.max(2, 2 - 2 + 1) = 2
 - Move right pointer to 3 (exceeds n).

5. Final Result:
 - The loop ends because right has reached the length of the array (n).
 - The function returns maxLen, which is 2.
 - This indicates the length of the longest subarray with a sum of 5 is 2 (subarray [2, 3]).

*/
