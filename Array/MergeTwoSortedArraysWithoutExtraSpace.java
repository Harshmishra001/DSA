// Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
//  Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it 
// contains the last M elements.

// Examples
// Example 1:
// Input:
 
// n = 4, arr1[] = [1 4 8 10] 
// m = 5, arr2[] = [2 3 9]

// Output:
 
// arr1[] = [1 2 3 4]
// arr2[] = [8 9 10]

// Explanation:

// After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

// Example2:
// Input:
 
// n = 4, arr1[] = [1 3 5 7] 
// m = 5, arr2[] = [0 2 6 8 9]

// Output:
 
// arr1[] = [0 1 2 3]
// arr2[] = [5 6 7 8 9]

// Explanation:

// After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.



// BRUTE-FORCE APPROACH -  (used extra space)

// Time Complexity: O(n+m) + O(n+m), where n and m are the sizes of the given arrays.
// Reason: O(n+m) is for copying the elements from arr1[] and arr2[] to arr3[]. And another O(n+m) is for filling back the two given arrays from arr3[].

// Space Complexity: O(n+m) as we use an extra array of size n+m.

// import java.util.*;

// public class MergeTwoSortedArrayWithoutExtraSpc {

//     public static void merge(long[] arr1, long[] arr2, int n, int m) {

//         // Declare a 3rd array to hold merged elements and initialize two pointers for arr1 and arr2:
//         long[] arr3 = new long[n + m];
//         int left = 0;  // Pointer for arr1
//         int right = 0; // Pointer for arr2
//         int index = 0; // Pointer for arr3

//         // Merge elements from arr1 and arr2 into arr3 in sorted order:
//         while (left < n && right < m) {
//             if (arr1[left] <= arr2[right]) {
//                 arr3[index] = arr1[left];
//                 left++; // Move the left pointer forward
//             } else {
//                 arr3[index] = arr2[right];
//                 right++; // Move the right pointer forward
//             }
//             index++; // Move the index pointer of arr3 forward
//         }

//         // If elements remain in arr1, add them to arr3:
//         while (left < n) {
//             arr3[index++] = arr1[left++];
//         }

//         // If elements remain in arr2, add them to arr3:
//         while (right < m) {
//             arr3[index++] = arr2[right++];
//         }

//         // Copy elements from arr3 back to arr1 and arr2:
//         for (int i = 0; i < n + m; i++) {
//             if (i < n) {
//                 arr1[i] = arr3[i]; // Fill arr1 with the first n elements
//             } else {
//                 arr2[i - n] = arr3[i]; // Fill arr2 with the remaining elements
//             }
//         }
//     }

//     public static void main(String[] args) {
//         long[] arr1 = {1, 4, 8, 10};
//         long[] arr2 = {2, 3, 9};
//         int n = 4, m = 3;

//         // Call the merge function to merge arr1 and arr2:
//         merge(arr1, arr2, n, m);

//         // Print the results:
//         System.out.println("The merged arrays are:");
//         System.out.print("arr1[] = ");
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr1[i] + " ");
//         }
//         System.out.print("\narr2[] = ");
//         for (int i = 0; i < m; i++) {
//             System.out.print(arr2[i] + " ");
//         }
//         System.out.println();
//     }
// }

/*
Step-wise Walkthrough:

Input:
arr1 = {1, 4, 8, 10}
arr2 = {2, 3, 9}
n = 4, m = 3

Step 1: Initialize pointers
- left = 0, right = 0, index = 0
- arr3 = {}

Step 2: Compare and merge (while both arrays have elements)
- Compare arr1[0] (1) with arr2[0] (2):
  - arr3 = {1}, left++, index++
- Compare arr1[1] (4) with arr2[0] (2):
  - arr3 = {1, 2}, right++, index++
- Compare arr1[1] (4) with arr2[1] (3):
  - arr3 = {1, 2, 3}, right++, index++
- Compare arr1[1] (4) with arr2[2] (9):
  - arr3 = {1, 2, 3, 4}, left++, index++

Step 3: Add remaining elements from arr1
- arr3 = {1, 2, 3, 4, 8, 10}, left++, index++

Step 4: Add remaining elements from arr2
- arr3 = {1, 2, 3, 4, 8, 9, 10}, right++, index++

Step 5: Copy elements from arr3 back to arr1 and arr2
- arr1 = {1, 2, 3, 4}
- arr2 = {8, 9, 10}

Output:
arr1[] = 1 2 3 4
arr2[] = 8 9 10
*/






// OPTIMAL APPROACH (without using any extra space): 

// Time Complexity: O(min(n, m)) + O(n*logn) + O(m*logm), where n and m are the sizes of the given arrays.
// Reason: O(min(n, m)) is for swapping the array elements. And O(n*logn) and O(m*logm) are for sorting the two arrays.

// Space Complexity: O(1) as we are not using any extra space.


import java.util.*;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Initialize pointers for the two arrays:
        int left = n - 1; // Start at the end of arr1
        int right = 0;    // Start at the beginning of arr2

        // Swap elements between arr1 and arr2 until arr1[left] is smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                // Swap arr1[left] and arr2[right]:
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;  // Move left pointer backward
                right++; // Move right pointer forward
            } else {
                break; // Stop when elements are in correct order
            }
        }

        // Sort both arrays individually to maintain sorted order:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;

        // Call the merge function to merge arr1 and arr2:
        merge(arr1, arr2, n, m);

        // Print the results:
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}

/*
Step-wise Walkthrough:

Input:
arr1 = {1, 4, 8, 10}
arr2 = {2, 3, 9}
n = 4, m = 3

Step 1: Initialize pointers:
- left = 3 (last index of arr1)
- right = 0 (first index of arr2)

Step 2: Compare and swap elements:
- Compare arr1[3] (10) with arr2[0] (2):
  - Swap them → arr1 = {1, 4, 8, 2}, arr2 = {10, 3, 9}
  - left = 2, right = 1

- Compare arr1[2] (8) with arr2[1] (3):
  - Swap them → arr1 = {1, 4, 3, 2}, arr2 = {10, 8, 9}
  - left = 1, right = 2

- Compare arr1[1] (4) with arr2[2] (9):
  - No swap needed, as arr1[1] <= arr2[2].
  - Stop swapping.

Step 3: Sort both arrays:
- arr1 = {1, 2, 3, 4}
- arr2 = {8, 9, 10}

Output:
arr1[] = 1 2 3 4
arr2[] = 8 9 10
*/
