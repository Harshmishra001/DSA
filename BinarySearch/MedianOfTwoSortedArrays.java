// Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, 
// return the median of the two sorted arrays. The median is defined as the middle value of a 
// sorted list of numbers. In case the length of the list is even, the median is the average of 
// the two middle elements.

// Examples
// Example 1:
// Input Format:
//  n1 = 3, arr1[] = {2,4,6}, n2 = 3, arr2[] = {1,3,5}
// Result:
//  3.5
// Explanation:
//  The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 5, 6 }. As the length of the merged list is even, the median is the average of the two middle elements. Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.

// Example 2:
// Input Format:
//  n1 = 3, arr1[] = {2,4,6}, n2 = 2, arr2[] = {1,3}
// Result:
//  3
// Explanation:
//  The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 6 }. The median is simply 3.



// Brute Force Approach

// Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
// Reason: We traverse through both arrays linearly.

// Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
// Reason: We are using an extra array of size (n1+n2) to solve this problem.

// import java.util.*;
// public class MedianOfTwoSortedArrays {

//     // Function to find the median of two sorted arrays
//     public static double median(int[] a, int[] b) {
//         // Size of two given arrays
//         int n1 = a.length;
//         int n2 = b.length;

//         // Create a list to hold the merged array
//         List<Integer> arr3 = new ArrayList<>();
        
//         // Merge the two arrays in sorted order
//         int i = 0, j = 0, k = 0;
        
//         while (i < n1 && j < n2) {  // While both arrays have elements left to merge
//             if (a[i] < b[j]) {  // Compare elements from both arrays
//                 arr3.add(a[i++]);  // Add the smaller element to arr3
//             } else {
//                 arr3.add(b[j++]);  // Add the smaller element from array b to arr3
//             }
//         }

//         // Copy the remaining elements from array a (if any)
//         while (i < n1) {
//             arr3.add(a[i++]);  // Add remaining elements of a to arr3
//         }

//         // Copy the remaining elements from array b (if any)
//         while (j < n2) {
//             arr3.add(b[j++]);  // Add remaining elements of b to arr3
//         }

//         // Find the median of the merged array
//         int n = n1 + n2;  // Total number of elements in the merged array

//         // If the total number of elements is odd, return the middle element
//         if (n % 2 == 1) {
//             return (double) arr3.get(n / 2);  // Return the middle element of the merged array
//         }

//         // If the total number of elements is even, return the average of the two middle elements
//         double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;  
//         return median;
//     }

//     // Main method to test the median function
//     public static void main(String[] args) {
//         // Two sorted arrays for testing
//         int[] a = {1, 4, 7, 10, 12};
//         int[] b = {2, 3, 6, 15};
        
//         // Call the median function and print the result
//         System.out.println("The median of two sorted arrays is " + median(a, b));
//     }
// }


// ### Dry Run:
// Let’s walk through the dry run for the input arrays:
// - `a = {1, 4, 7, 10, 12}`
// - `b = {2, 3, 6, 15}`

// 1. **Merging step:**
//     - Start with `i = 0` and `j = 0`:
//     - `a[0] = 1` and `b[0] = 2` → `1 < 2`, so add `1` to `arr3`.
//     - `i = 1`, `arr3 = [1]`
//     - `a[1] = 4` and `b[0] = 2` → `2 < 4`, so add `2` to `arr3`.
//     - `j = 1`, `arr3 = [1, 2]`
//     - `a[1] = 4` and `b[1] = 3` → `3 < 4`, so add `3` to `arr3`.
//     - `j = 2`, `arr3 = [1, 2, 3]`
//     - `a[1] = 4` and `b[2] = 6` → `4 < 6`, so add `4` to `arr3`.
//     - `i = 2`, `arr3 = [1, 2, 3, 4]`
//     - `a[2] = 7` and `b[2] = 6` → `6 < 7`, so add `6` to `arr3`.
//     - `j = 3`, `arr3 = [1, 2, 3, 4, 6]`
//     - `a[2] = 7` and `b[3] = 15` → `7 < 15`, so add `7` to `arr3`.
//     - `i = 3`, `arr3 = [1, 2, 3, 4, 6, 7]`
//     - `a[3] = 10` and `b[3] = 15` → `10 < 15`, so add `10` to `arr3`.
//     - `i = 4`, `arr3 = [1, 2, 3, 4, 6, 7, 10]`
//     - `a[4] = 12` and `b[3] = 15` → `12 < 15`, so add `12` to `arr3`.
//     - `i = 5`, `arr3 = [1, 2, 3, 4, 6, 7, 10, 12]`
//     - `b[3] = 15`, add `15` to `arr3` since `j = 4` (no more elements in `b`).
//     - `arr3 = [1, 2, 3, 4, 6, 7, 10, 12, 15]`

// 2. **Finding the median:**
//     - The merged array has 9 elements.
//     - Since the total number of elements is odd (`9 % 2 == 1`), the median is the element at index `9 / 2 = 4`.
//     - The element at index `4` is `6`.

// Thus, the median is `6`.

// ### Output:
// ```
// The median of two sorted arrays is 6.0
// ```









// Optimal Approach

// Time Complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
// Reason: We are applying binary search on the range [0, min(n1, n2)].

// Space Complexity: O(1) as no extra space is used.

import java.util.*;

public class MedianOfTwoSortedArrays {

    // Function to find the median of two sorted arrays using binary search
    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;

        // If n1 is greater than n2, swap the arrays to ensure binary search is applied on the smaller array
        if (n1 > n2) return median(b, a);

        int n = n1 + n2;  // Total length of both arrays
        int left = (n1 + n2 + 1) / 2;  // Length of the left half of the merged array

        // Apply binary search on the smaller array
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;  // Midpoint of array a
            int mid2 = left - mid1;  // Corresponding midpoint in array b

            // Calculate the boundary elements: l1, l2, r1, r2
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;  // Left element of a
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;  // Left element of b
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;  // Right element of a
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;  // Right element of b

            // Check if we have found the correct partition
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {  // Odd total number of elements
                    return Math.max(l1, l2);  // The median is the maximum of the left elements
                } else {  // Even total number of elements
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;  // Average of the middle elements
                }
            } else if (l1 > r2) {  // If l1 is too large, reduce the size of the partition in array a
                high = mid1 - 1;
            } else {  // If l2 is too large, increase the size of the partition in array a
                low = mid1 + 1;
            }
        }

        return 0;  // Dummy statement (this should never be reached if inputs are valid)
    }

    // Main method to test the median function
    public static void main(String[] args) {
        // Two sorted arrays for testing
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        
        // Call the median function and print the result
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}  

// Step-by-step Dry Run:
// Initial Setup:

// a = {1, 4, 7, 10, 12}
// b = {2, 3, 6, 15}

// Lengths of a and b:
// n1 = a.length = 5
// n2 = b.length = 4

// Since n1 > n2 is true, the function swaps a and b to apply the binary search on the smaller array.
// New a = {2, 3, 6, 15} and b = {1, 4, 7, 10, 12}.

// Updated lengths:
// n1 = 4 (new length of a)
// n2 = 5 (new length of b)

// Total length of both arrays:
// n = n1 + n2 = 4 + 5 = 9 (total length of merged arrays)

// Left half size (length of the left part of the merged array):
// left = (n + 1) / 2 = (9 + 1) / 2 = 5

// Binary Search Setup:
// low = 0, high = n1 = 4 (searching in array a)
// We will now apply binary search to find the correct partition.

// First Iteration (Binary Search Loop):

// Midpoint Calculation:
// mid1 = (low + high) / 2 = (0 + 4) / 2 = 2 (midpoint of array a)
// mid2 = left - mid1 = 5 - 2 = 3 (corresponding midpoint in array b)

// Boundary Elements:
// l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE = a[1] = 3 (left element of a)
// l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE = b[2] = 7 (left element of b)
// r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE = a[2] = 6 (right element of a)
// r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE = b[3] = 10 (right element of b)
// Check if partition is correct:

// We need to check if l1 <= r2 and l2 <= r1:

// l1 = 3, r2 = 10, l2 = 7, r1 = 6
// l1 <= r2 is 3 <= 10, which is true.
// l2 <= r1 is 7 <= 6, which is false.
// Since l2 > r1, it means that the partition is incorrect, so we need to move to the right in a by adjusting low.

// Adjust Search Range:

// We now adjust the search range for a:
// low = mid1 + 1 = 2 + 1 = 3
// So, we will now focus on low = 3 and high = 4.
// Second Iteration (Binary Search Loop):
// Midpoint Calculation:

// mid1 = (low + high) / 2 = (3 + 4) / 2 = 3 (midpoint of array a)
// mid2 = left - mid1 = 5 - 3 = 2 (corresponding midpoint in array b)
// Boundary Elements:

// l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE = a[2] = 6 (left element of a)
// l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE = b[1] = 3 (left element of b)
// r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE = a[3] = 10 (right element of a)
// r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE = b[2] = 7 (right element of b)
// Check if partition is correct:

// Check if l1 <= r2 and l2 <= r1:

// l1 = 6, r2 = 7, l2 = 3, r1 = 10
// l1 <= r2 is 6 <= 7, which is true.
// l2 <= r1 is 3 <= 10, which is true.
// Both conditions are satisfied, so we have found the correct partition.

// Final Calculation of Median:
// Total length n = 9 is odd, so the median is the maximum of the left elements (l1 and l2):
// median = Math.max(l1, l2) = Math.max(6, 3) = 6
// Thus, the median of the two sorted arrays is 6.

// Output:
// The median of two sorted arrays is 6.0