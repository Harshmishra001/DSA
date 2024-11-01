// Problem Statement: You are given an array of ‘N’ integers. You need to find the 
// length of the longest sequence which contains the consecutive elements.

// Examples

// Example 1:
// Input:
//  [100, 200, 1, 3, 2, 4]
// Output:
//  4
// Explanation:
//  The longest consecutive subsequence is 1, 2, 3, and 4.

// Input:
//  [3, 8, 5, 7, 6]
// Output:
//  4
// Explanation:
//  The longest consecutive subsequence is 5, 6, 7, and 8.


// BRUTE-FORCE APPROACH
// Time Complexity: O(N2), N = size of the given array.
// Reason: We are using nested loops each running for approximately N times.

// Space Complexity: O(1), as we are not using any extra space to solve this problem.


import java.util.*;


// public class LongestConsecutiveSequence {
//     public static boolean linearSearch(int []a, int num) {
//         int n = a.length; //size of array
//         for (int i = 0; i < n; i++) {
//             if (a[i] == num)
//                 return true;
//         }
//         return false;
//     }
//     public static int longestSuccessiveElements(int []a) {
//         int n = a.length; //size of array
//         int longest = 1;
//         //pick a element and search for its
//         //consecutive numbers:
//         for (int i = 0; i < n; i++) {
//             int x = a[i];
//             int cnt = 1;
//             //search for consecutive numbers
//             //using linear search:
//             while (linearSearch(a, x + 1) == true) {
//                 x += 1;
//                 cnt += 1;
//             }

//             longest = Math.max(longest, cnt);
//         }
//         return longest;
//     }

//     public static void main(String[] args) {
//         int[] a = {100, 200, 1, 2, 3, 4};
//         int ans = longestSuccessiveElements(a);
//         System.out.println("The longest consecutive sequence is " + ans);
//     }
// }

// BETTER APPROACH
// Time Complexity: O(NlogN) + O(N), N = size of the given array.
// Reason: O(NlogN) for sorting the array. To find the longest sequence, we are using a loop that results in O(N).

// Space Complexity: O(1), as we are not using any extra space to solve this problem.

// import java.util.Arrays;

// public class LongestConsecutiveSequence {
//     public static int longestSuccessiveElements(int []a) {
//         int n = a.length;
//         if (n == 0) return 0;

//         //sort the array:
//         Arrays.sort(a);
//         int lastSmaller = Integer.MIN_VALUE;
//         int cnt = 0;
//         int longest = 1;

//         //find longest sequence:
//         for (int i = 0; i < n; i++) {
//             if (a[i] - 1 == lastSmaller) {
//                 //a[i] is the next element of the
//                 //current sequence.
//                 cnt += 1;
//                 lastSmaller = a[i];
//             } else if (a[i] != lastSmaller) {
//                 cnt = 1;
//                 lastSmaller = a[i];
//             }
//             longest = Math.max(longest, cnt);
//         }
//         return longest;
//     }

//     public static void main(String[] args) {
//         int[] a = {100, 200, 1, 2, 3, 4};
//         int ans = longestSuccessiveElements(a);
//         System.out.println("The longest consecutive sequence is " + ans);
//     }
// }

// // OPTIMAL APPROACH

// // - Time Complexity: (O(n)) — Inserting elements into the set and checking consecutive sequences each take \(O(n)\) time.
// // - Space Complexity: (O(n)) — The set stores each unique element from the array.

import java.util.HashSet;

public class LongestConsecutiveSequence {
    
    // Function to find the longest consecutive sequence in the array
    public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0) // if array is empty, return 0
            return 0;

        int longest = 1; // variable to store the longest sequence length
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to a HashSet to allow O(1) lookups
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Check each element to find the starting point of a sequence
        for (int x : set) {
            // Check if 'it' is the start of a sequence by confirming (it - 1) is not in the set
            if (!set.contains(x - 1)) {
                int cnt = 1; // count for current sequence length
            
                
                // Keep checking the next consecutive elements
                while (set.contains(x + 1)) {
                    x = x + 1; // move to the next number
                    cnt = cnt + 1; // increment current sequence length
                }
                
                // Update longest sequence length if current one is longer
                longest = Math.max(longest, cnt);
            }
        }
        return longest; // return the length of the longest sequence found
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}

/* 
Dry Run:
Input: a = {100, 200, 1, 2, 3, 4}
1. Insert all elements into the set: set = {100, 200, 1, 2, 3, 4}
2. Iterate over each element in the set:
    - For '100': set contains 99, so skip (not a sequence start)
    - For '200': set contains 199, so skip (not a sequence start)
    - For '1': set does not contain 0, so it's the start of a sequence
        - Check sequence starting from 1: 1 → 2 → 3 → 4
        - Sequence length = 4, update longest = 4
    - For '2', '3', '4': skip as they are part of the sequence starting at '1'
    - For '100' and '200': already checked
3. Result: Longest sequence length is 4
Output: The longest consecutive sequence is 4
*/







