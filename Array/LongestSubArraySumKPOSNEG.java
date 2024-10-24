import java.util.*;

// BRUTE-FORCE APPROACH

// T.C->O(N^3)
// S.C->O(1)

// public class LongestSubarraywithgivenSumKPOSNEG {
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


// OPTIMAL APPROACH 
// Expected Time Complexity: O(n).
// Expected Auxiliary Space: O(n).
class LongestSubArraySumKPOSNEG{
    public static int lenOfLongSubarr(int A[], int N, int K) {

        // HashMap to store the prefix sums and their corresponding indices
        Map<Integer, Integer> map = new HashMap<>();   //MAP K ANDR 2 BAAR INT ISLIYE LIKHA KYUKI HUM MAP M STORE NO. AND INDEX KR RE HAI LOOK 106 LINE

        int sum = 0; // Variable to hold the running sum
        int length = 0; // Variable to track the maximum length of the subarray
        
        // Iterate through the array
        for (int i = 0; i < N; i++) {
            // Calculate the current prefix sum
            sum += A[i];

            // If the current sum equals K, update length
            if (sum == K) {
                length = i + 1; // Length of subarray from start to current index   ,, 0 base indexing hai isliye 1 plus kr re h taaki exact lenth pta chle
            } 
            // Check if there exists a prefix sum such that sum - K is in the map
            else if (map.containsKey(sum - K)) {
                // Update length if we find a longer subarray
                length = Math.max(length, i - map.get(sum - K));
            }
            
            // Store the current prefix sum and its index only if it's not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return length; // Return the maximum length found
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int k1 = 15;
        int len1 = lenOfLongSubarr(arr1, arr1.length, k1);
        System.out.println("The length of the longest subarray is: " + len1); // Output: 4
        
        // Test case 2
        int[] arr2 = {-1, 2, 3};
        int k2 = 6;
        int len2 = lenOfLongSubarr(arr2, arr2.length, k2);
        System.out.println("The length of the longest subarray is: " + len2); // Output: 0
    }
}


/*
Detailed Dry Run for Test Case 1:
Input: A = [10, 5, 2, 7, 1, 9], N = 6, K = 15
- Initialize: map = {}, sum = 0, length = 0

1. i = 0, A[0] = 10
   - sum = 0 + 10 = 10
   - sum (10) != K (15), so length remains 0
   - rem = 10 - 15 = -5; -5 not in map
   - Update map: map = {10: 0}

2. i = 1, A[1] = 5
   - sum = 10 + 5 = 15
   - sum (15) == K (15), update length to 2 (i + 1)
   - rem = 15 - 15 = 0; 0 not in map
   - Update map: map = {10: 0, 15: 1}

3. i = 2, A[2] = 2
   - sum = 15 + 2 = 17
   - sum (17) != K (15), so length remains 2
   - rem = 17 - 15 = 2; 2 not in map
   - Update map: map = {10: 0, 15: 1, 17: 2}

4. i = 3, A[3] = 7
   - sum = 17 + 7 = 24
   - sum (24) != K (15), so length remains 2
   - rem = 24 - 15 = 9; 9 not in map
   - Update map: map = {10: 0, 15: 1, 17: 2, 24: 3}

5. i = 4, A[4] = 1
   - sum = 24 + 1 = 25
   - sum (25) != K (15), so length remains 2
   - rem = 25 - 15 = 10; 10 found in map (index 0)
   - Calculate length: len = 4 - 0 = 4
   - Update length to 4 (max(2, 4))
   - Update map: map = {10: 0, 15: 1, 17: 2, 24: 3, 25: 4}

6. i = 5, A[5] = 9
   - sum = 25 + 9 = 34
   - sum (34) != K (15), so length remains 4
   - rem = 34 - 15 = 19; 19 not in map
   - Update map: map = {10: 0, 15: 1, 17: 2, 24: 3, 25: 4, 34: 5}

Final length for Test Case 1 = 4
Output: The length of the longest subarray is: 4

Detailed Dry Run for Test Case 2:
Input: A = [-1, 2, 3], N = 3, K = 6
- Initialize: map = {}, sum = 0, length = 0

1. i = 0, A[0] = -1
   - sum = 0 + (-1) = -1
   - sum (-1) != K (6), so length remains 0
   - rem = -1 - 6 = -7; -7 not in map
   - Update map: map = {-1: 0}

2. i = 1, A[1] = 2
   - sum = -1 + 2 = 1
   - sum (1) != K (6), so length remains 0
   - rem = 1 - 6 = -5; -5 not in map
   - Update map: map = {-1: 0, 1: 1}

3. i = 2, A[2] = 3
   - sum = 1 + 3 = 4
   - sum (4) != K (6), so length remains 0
   - rem = 4 - 6 = -2; -2 not in map
   - Update map: map = {-1: 0, 1: 1, 4: 2}

Final length for Test Case 2 = 0
Output: The length of the longest subarray is: 0
*/