package BinarySearch;

// Problem Statement: Given an integer array arr of size N, sorted in ascending order 
// (with distinct values). Now the array is rotated between 1 to N times which is unknown. 
// Find the minimum element in the array. 

// Pre-requisites: Search in Rotated Sorted Array I,  Search in Rotated Sorted Array II & Binary Search algorithm

// Examples
// Example 1:
// Input Format:
//  arr = [4,5,6,7,0,1,2,3]
// Result:
//  0
// Explanation:
//  Here, the element 0 is the minimum element in the array.

// Example 2:
// Input Format:
//  arr = [3,4,5,1,2]
// Result:
//  1
// Explanation:
//  Here, the element 1 is the minimum element in the array.






// Brute - Force Approach

// Time Complexity: O(N), N = size of the given array.
// Reason: We have to iterate through the entire array to check if the target is present in the array.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


// import java.util.*;

// public class FindMinimumInSortedArray {
//     public static int findMin(int []arr) {
//         int n = arr.length; // size of the array.
//         int mini = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             // Always keep the minimum.
//             mini = Math.min(mini, arr[i]);
//         }
//         return mini;
//     }

//     public static void main(String[] args) {
//         int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
//         int ans = findMin(arr);
//         System.out.println("The minimum element is: " + ans );
//     }
// }


// Optimal Approach(Using Binary Search): 

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using binary search to find the minimum.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

import java.util.*;

public class FindMinimumInSortedArray {
    public static int findMin(int []arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findMin(arr);
        System.out.println("The minimum element is: " + ans );
    }
}

/*
Dry Run:
Input: arr = {4, 5, 6, 7, 0, 1, 2, 3}

Initial values:
low = 0, high = 7, ans = Integer.MAX_VALUE

Iteration 1:
mid = (0 + 7) / 2 = 3
arr[low] = 4, arr[mid] = 7
Since arr[low] <= arr[mid], the left part is sorted.
ans = min(Integer.MAX_VALUE, 4) = 4
low = mid + 1 = 4

Iteration 2:
low = 4, high = 7
mid = (4 + 7) / 2 = 5
arr[low] = 0, arr[mid] = 1
Since arr[low] <= arr[mid], the left part is sorted.
ans = min(4, 0) = 0
low = mid + 1 = 6

Iteration 3:
low = 6, high = 7
mid = (6 + 7) / 2 = 6
arr[low] = 2, arr[mid] = 2
Since arr[low] <= arr[mid], the left part is sorted.
ans = min(0, 2) = 0
low = mid + 1 = 7

Iteration 4:
low = 7, high = 7
mid = (7 + 7) / 2 = 7
arr[low] = 3, arr[mid] = 3
Since arr[low] <= arr[mid], the left part is sorted.
ans = min(0, 3) = 0
low = mid + 1 = 8

Exit loop:
low = 8, high = 7 (low > high)

Final result:
ans = 0
Output: The minimum element is: 0
*/
