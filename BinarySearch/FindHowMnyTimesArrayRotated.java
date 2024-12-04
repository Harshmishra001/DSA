package BinarySearch;

// Problem Statement: Given an integer array arr of size N, sorted in ascending order 
// (with distinct values). Now the array is rotated between 1 to N times which is unknown. 
// Find how many times the array has been rotated. 

// Pre-requisites: Find minimum in Rotated Sorted Array,  Search in Rotated Sorted Array II & Binary Search algorithm

// Examples
// Example 1:
// Input Format:
//  arr = [4,5,6,7,0,1,2,3]
// Result:
//  4
// Explanation:
//  The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

// Example 2:
// Input Format:
//  arr = [3,4,5,1,2]
// Result:
//  3
// Explanation:
//  The original array should be [1,2,3,4,5]. So, we can notice that the array has been rotated 3 times.



// Brute Force Approach

// Time Complexity: O(N), N = size of the given array.
// Reason: We have to iterate through the entire array to check if the target is present in the array.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

// import java.util.*;

// public class FindHowMnyTimesArrayRotated {

//     // Method to find the number of rotations in a rotated sorted array
//     public static int findKRotation(int[] arr) {
//         int n = arr.length; // Size of the array
//         int ans = Integer.MAX_VALUE, index = -1; // Initialize variables to store the minimum element and its index
        
//         // Iterate through the array to find the minimum element and its index
//         for (int i = 0; i < n; i++) {
//             if (arr[i] < ans) { // If current element is smaller than the smallest element found so far
//                 ans = arr[i]; // Update the smallest element
//                 index = i; // Update the index of the smallest element
//             }
//         }
//         return index; // Return the index of the minimum element (which corresponds to the number of rotations)
//     }

//     // Main method to test the findKRotation method
//     public static void main(String[] args) {
//         int[] arr = {4, 5, 6, 7, 0, 1, 2, 3}; // Sample rotated array
//         int ans = findKRotation(arr); // Call the method to find the number of rotations
//         System.out.println("The array is rotated " + ans + " times."); // Output the result
//     }
// }

/* Walkthrough:
   Input: arr = {4, 5, 6, 7, 0, 1, 2, 3}
   
   1. Initialize the following variables:
      - ans = Integer.MAX_VALUE (This will hold the minimum value found so far)
      - index = -1 (This will hold the index of the minimum value)
   
   2. Start iterating through the array:
      - i = 0: arr[0] = 4
        - Since 4 is less than Integer.MAX_VALUE, update ans to 4 and index to 0.
      - i = 1: arr[1] = 5
        - 5 is greater than the current ans (4), so no changes.
      - i = 2: arr[2] = 6
        - 6 is greater than the current ans (4), so no changes.
      - i = 3: arr[3] = 7
        - 7 is greater than the current ans (4), so no changes.
      - i = 4: arr[4] = 0
        - Since 0 is less than the current ans (4), update ans to 0 and index to 4.
      - i = 5: arr[5] = 1
        - 1 is greater than the current ans (0), so no changes.
      - i = 6: arr[6] = 2
        - 2 is greater than the current ans (0), so no changes.
      - i = 7: arr[7] = 3
        - 3 is greater than the current ans (0), so no changes.

   3. After completing the loop, the index of the minimum element is 4.
      - The minimum value is 0, which is at index 4, indicating the array has been rotated 4 times.
   
   4. Output: "The array is rotated 4 times."
*/




// Optimal Approach

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using binary search to find the minimum.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


import java.util.*;

public class FindHowMnyTimesArrayRotated {
    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        // Perform binary search to find the minimum element
        while (low <= high) {
            int mid = (low + high) / 2;

            // If the array is sorted in the current search space
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break; // Break the loop as we have found the minimum
            }

            // If the left part is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1; // Narrow search to the right side
            } else { // If the right part is sorted
                if (arr[mid] < ans) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1; // Narrow search to the left side
            }
        }
        return index; // Return the index of the smallest element (rotation count)
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findKRotation(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }
}

/*
Step-by-Step Walkthrough:

1. **Initialization**:
   - `low = 0`, `high = 7` (array boundaries).
   - `ans = Integer.MAX_VALUE` (to keep track of the smallest value).
   - `index = -1` (to store the index of the minimum value).

2. **First Iteration**:
   - `mid = (low + high) / 2 = 3` (so `arr[mid] = 7`).
   - The array is not sorted in this search space as `arr[low] = 4` and `arr[high] = 3`. Therefore, we move to the next condition.
   - The left side of the array is sorted because `arr[low] = 4` and `arr[mid] = 7` satisfy `arr[low] <= arr[mid]`.
   - Update `ans = 4` and `index = 0`.
   - Since the left part is sorted, we narrow the search to the right half by setting `low = mid + 1` (i.e., `low = 4`).

3. **Second Iteration**:
   - Now, `low = 4` and `high = 7`.
   - `mid = (low + high) / 2 = 5` (so `arr[mid] = 1`).
   - The array is sorted in this search space because `arr[low] = 0` and `arr[high] = 3`, satisfying `arr[low] <= arr[high]`.
   - Update `ans = 0` and `index = 4`.
   - Break the loop as the minimum element has been found.

4. **Final Output**:
   - The program prints: "The array is rotated 4 times."
*/
