package BinarySearch;


// Brute Force 

// import java.util.*;

// public class KthMissingPositiveNo {
//     // Function to find the kth missing number in the array.
//     public static int missingK(int[] vec, int n, int k) {
//         // Loop through each element in the array.
//         for (int i = 0; i < n; i++) {
//             // If the current element is less than or equal to k, we increment k
//             if (vec[i] <= k) {
//                 k++; // Shift k by 1, since k is a missing number
//             } else {
//                 break; // If the current element is greater than k, break the loop
//             }
//         }
//         return k; // Return the kth missing number
//     }

//     public static void main(String[] args) {
//         // Array vec contains the sorted numbers, n is the size of the array, and k is the kth missing number to find.
//         int[] vec = {4, 7, 9, 10};
//         int n = 4, k = 4;
        
//         // Call the missingK function to find the kth missing number.
//         int ans = missingK(vec, n, k);
        
//         // Print the result.
//         System.out.println("The missing number is: " + ans);
//     }
// }

// Dry Run Walkthrough:
// Input:
// vec = {4, 7, 9, 10}
// n = 4 (size of the array)
// k = 4 (we need to find the 4th missing number)
// Initial Setup:
// The array vec[] is {4, 7, 9, 10}.
// We start with k = 4 and n = 4.

// Step-by-Step Dry Run:

// First Iteration (i = 0):
// Check if vec[0] = 4 is less than or equal to k = 4. Since it is true:
// k is incremented by 1. Now, k = 5.
// Continue to the next iteration.

// Second Iteration (i = 1):
// Check if vec[1] = 7 is less than or equal to k = 5. Since it is false:
// The loop breaks here, because vec[i] > k.

// End of Loop:
// The loop ends because the element 7 is greater than k = 5, so we stop checking further.
// The function now returns the value of k, which is 5.

// Output:
// The missing number is 5.




// Optimal Approach 

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are using the simple binary search algorithm.

// Space Complexity: O(1) as we are not using any extra space to solve this problem.

import java.util.*;

public class KthMissingPositiveNo {
    // Function to find the kth missing number in a sorted array.
    public static int missingK(int[] vec, int n, int k) {
        // Initialize the low and high pointers for binary search.
        int low = 0, high = n - 1;
        
        // Binary search loop to find the kth missing element.
        while (low <= high) {
            // Calculate the middle index for binary search.
            int mid = (low + high) / 2;
            
            // Calculate the number of missing elements up to the current mid index.
            int missing = vec[mid] - (mid + 1); // Elements missing before the mid index.
            
            // If the missing numbers are less than k, we need to search in the right half.
            if (missing < k) {
                low = mid + 1; // Move the low pointer to the right of mid.
            } else {
                // Otherwise, we search in the left half.
                high = mid - 1; // Move the high pointer to the left of mid.
            }
        }
        
        // Return the kth missing number using the formula: k + high + 1.
        return k + high + 1; 
    }

    public static void main(String[] args) {
        // Array vec contains the sorted numbers, n is the size of the array, and k is the kth missing number to find.
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
        
        // Call the missingK function to find the kth missing number.
        int ans = missingK(vec, n, k);
        
        // Print the result.
        System.out.println("The missing number is: " + ans);
    }
}
// Dry Run Walkthrough:
// Input:
// vec = {4, 7, 9, 10}
// n = 4 (size of the array)
// k = 4 (we need to find the 4th missing number)
// Initial Setup:
// low = 0
// high = 3 (size of the array - 1)
// Step-by-Step Dry Run:

// First Iteration:
// low = 0, high = 3
// Calculate mid = (low + high) / 2 = (0 + 3) / 2 = 1
// Calculate the missing number count: missing = vec[mid] - (mid + 1) = vec[1] - (1 + 1) = 7 - 2 = 5
// Condition check: missing = 5 which is greater than k = 4.
// So, we move the high pointer to the left: high = mid - 1 = 1 - 1 = 0.

// Second Iteration:
// low = 0, high = 0
// Calculate mid = (low + high) / 2 = (0 + 0) / 2 = 0
// Calculate the missing number count: missing = vec[mid] - (mid + 1) = vec[0] - (0 + 1) = 4 - 1 = 3
// Condition check: missing = 3, which is less than k = 4.
// So, we move the low pointer to the right: low = mid + 1 = 0 + 1 = 1.

// End of Loop:
// Now, low = 1, high = 0. The loop condition low <= high is no longer true, so the loop ends.

// Final Calculation:
// The high pointer is now 0.
// We use the formula k + high + 1 = 4 + 0 + 1 = 5 to get the 4th missing number.

// Output:
// The missing number is 5.