// package BinarySearch;

// Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) 
// and a target value k. Now the array is rotated at some pivot point unknown to you. 
// Return True if k is present and otherwise, return False. 

// Pre-requisite: Search Element in Rotated Sorted Array I & Binary Search algorithm

// Examples
// Example 1:
// Input Format:
//  arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
// Result:
//  True
// Explanation:
//  The element 3 is present in the array. So, the answer is True.

// Example 2:
// Input Format:
//  arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10
// Result:
//  False
// Explanation:
//  The element 10 is not present in the array. So, the answer is False.





// Brute Force Approach

// Time Complexity: O(N), N = size of the given array.
// Reason: We have to iterate through the entire array to check if the target is present in the array.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


// import java.util.*;

// public class searchInARotatedSortedArrayII {
//     public static boolean searchInARotatedSortedArray(int []arr, int k) {
//         int n = arr.length; // size of the array.
//         for (int i = 0; i < n; i++) {
//             if (arr[i] == k) return true;
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
//         int k = 3;
//         boolean ans = searchInARotatedSortedArray(arr, k);
//         if (ans == false)
//             System.out.println("Target is not present.");
//         else
//             System.out.println("Target is present in the array.");
//     }
// }








// optimal approach

// Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.
// Reason: In the best and average scenarios, the binary search algorithm is primarily utilized and hence the time complexity is O(logN). However, in the worst-case scenario, where all array elements are the same but not the target (e.g., given array = {3, 3, 3, 3, 3, 3, 3}), we continue to reduce the search space by adjusting the low and high pointers until they intersect. This worst-case situation incurs a time complexity of O(N/2).

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


import java.util.*;

public class searchInARotatedSortedArrayII {
    public static boolean searchInARotatedSortedArray(int []arr, int k) {
        
        int n = arr.length; // size of the array.
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if mid points the target
            if (arr[mid] == k) return true;

            //Edge case:
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    //element exists:
                    high = mid - 1;
                } else {
                    //element does not exist:
                    low = mid + 1;
                }
            } else { //if right part is sorted:
                if (arr[mid] <= k && k <= arr[high]) {
                    //element exists:
                    low = mid + 1;
                } else {
                    //element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        boolean ans = searchInARotatedSortedArray(arr, k);
        if (ans == false)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}

/* 
Dry Run Walkthrough:

Input:
arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6}, k = 3

Step-by-Step Execution:
1. Initial values: low = 0, high = 9
   mid = (0 + 9) / 2 = 4
   arr[mid] = 3, which matches k.
   Result: Found target, return true.

Output:
Target is present in the array.
*/


