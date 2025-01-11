// package BinarySearch;

// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and
//  a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present 
//  and if k is not present return -1.

// Examples
// Example 1:
// Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
// Result: 4
// Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

// Example 2:
// Input Format: arr = [4,5,6,7,0,1,2], k = 3
// Result: -1
// Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.



// Brute Force Approach

// Time Complexity: O(N), N = size of the given array.
// Reason: We have to iterate through the entire array to check if the target is present in the array.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


// import java.util.*;

// public class SearchElementInRotatedSortedArray {
//     public static int search(ArrayList<Integer> arr, int n, int k) {
//         for (int i = 0; i < n; i++) {
//             if (arr.get(i) == k)
//                 return i;
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
//         int n = 9, k = 1;
//         int ans = search(arr, n, k);
//         if (ans == -1)
//             System.out.println("Target is not present.");
//         else
//             System.out.println("The index is: " + ans);
//     }
// }



// Optimal Approach

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are using binary search to search the target.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

import java.util.*;

public class SearchElementInRotatedSortedArray  {
    /**
     * Function to search for a target element in a rotated sorted array
     *
     * @param arr The rotated sorted array
     * @param n   The size of the array
     * @param k   The target element to search
     * @return The index of the target element if found, otherwise -1
     */
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;

        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2;

            // Check if the mid element is the target
            if (arr.get(mid) == k)
                return mid;

            // Check if the left half is sorted
            if (arr.get(low) <= arr.get(mid)) {
                // Check if the target lies within the sorted left half
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    high = mid - 1; // Narrow down to the left half
                } else {
                    low = mid + 1; // Narrow down to the right half
                }
            } else { // The right half must be sorted
                // Check if the target lies within the sorted right half
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    low = mid + 1; // Narrow down to the right half
                } else {
                    high = mid - 1; // Narrow down to the left half
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = arr.size(); // Size of the array
        int k = 1; // Target element to search

        // Perform the search and print the result
        int ans = search(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}

/**
 * Dry Run Walkthrough:
 * Array: [7, 8, 9, 1, 2, 3, 4, 5, 6]
 * Target (k): 1
 *
 * **Iteration 1:**
 * low = 0, high = 8
 * mid = (0 + 8) / 2 = 4
 * arr[mid] = 2
 *
 * - The left half [7, 8, 9] is not sorted, so check the right half.
 * - Update: high = mid - 1 = 3
 *
 * **Iteration 2:**
 * low = 0, high = 3
 * mid = (0 + 3) / 2 = 1
 * arr[mid] = 8
 *
 * - Target (1) is smaller than arr[mid] and lies outside the sorted right half.
 * - Update: low = mid + 1 = 2
 *
 * **Iteration 3:**
 * low = 2, high = 3
 * mid = (2 + 3) / 2 = 2
 * arr[mid] = 9
 *
 * - The target is not in this range; focus on remaining part.
 * - Update: high gets shrunk directly filtering pointers indirectly targetting narrowed **loop end**
 */
