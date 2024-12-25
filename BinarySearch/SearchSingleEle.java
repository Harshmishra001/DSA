package BinarySearch;
// Problem Statement: Given an array of N integers. Every number in the array except one appears twice. 
// Find the single number in the array.
// Example 1:
// Input Format:
//  arr[] = {1,1,2,2,3,3,4,5,5,6,6}
// Result:
//  4
// Explanation:
//  Only the number 4 appears once in the array.

// Example 2:
// Input Format:
//  arr[] = {1,1,3,5,5}
// Result:
//  3
// Explanation:
//  Only the number 3 appears once in the array.


// BRUTE-FORCE

// Time Complexity: O(N), N = size of the given array.
// Reason: We are traversing the entire array.

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;

// public class SearchSingleEle {
//     public static int singleNonDuplicate(int[] arr) {
//         int n = arr.length; // size of the array
//         int ans = 0;
//         // XOR all the elements:
//         for (int i = 0; i < n; i++) {
//             ans = ans ^ arr[i];
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
//         int ans = singleNonDuplicate(arr);
//         System.out.println("The single element is: " + ans);
//     }
// }




// optimal approach

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using the Binary Search algorithm.

// Space Complexity: O(1) as we are not using any extra space.


public class SearchSingleEle {
    // Method to find the single non-duplicate element in the array
    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length; // Get the size of the array

        // Edge cases:
        // If the array has only one element, return it directly.
        if (n == 1)
            return arr[0];
        
        // If the first element is not equal to the second, the first element is the unique one.
        if (arr[0] != arr[1])
            return arr[0];
        
        // If the last element is not equal to the second-to-last, the last element is the unique one.
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        // Initialize low and high pointers for binary search
        int low = 1, high = n - 2;
        
        // Binary search to find the non-duplicate element
        while (low <= high) {
            int mid = (low + high) / 2;  // Find the middle element

            // If arr[mid] is not equal to its neighbors, it's the unique element.
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // Check if we are on the left half of the array
            // If mid is odd and arr[mid] equals arr[mid - 1], we know the unique element is on the right
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1])
                    || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1; // Eliminate the left half
            } else {
                high = mid - 1; // Eliminate the right half
            }
        }

        // This should never happen if the input follows the rules (every element except one appears twice)
        return -1;  // Dummy return statement
    }

    public static void main(String[] args) {
        // Test the function with an array of integers
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        int ans = singleNonDuplicate(arr);
        // Output the result
        System.out.println("The single element is: " + ans);
    }
}

/*
Dry Run Walkthrough:

Let the input array be: arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6}

1. Initial Input:
   arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6}

2. Edge Case Check:
   - arr[0] != arr[1]: No, 1 == 1
   - arr[n-1] != arr[n-2]: No, 6 == 6
   So, proceed with binary search.

3. Set low = 1, high = 9.

4. First iteration of binary search:
   - mid = (1 + 9) / 2 = 5
   - arr[5] = 3
   - arr[5] != arr[4] and arr[5] != arr[6] (3 != 3, 3 != 4)
   - Check the left side: mid = 5 is odd and arr[5] == arr[4], so we eliminate the left half.
   - Update low = mid + 1 = 6.

5. Second iteration of binary search:
   - low = 6, high = 9.
   - mid = (6 + 9) / 2 = 7
   - arr[7] = 5
   - arr[7] == arr[8] (5 == 5), so we eliminate the left half.
   - Update low = mid + 1 = 8.

6. Third iteration of binary search:
   - low = 8, high = 9.
   - mid = (8 + 9) / 2 = 8
   - arr[8] == arr[9] (5 == 6)
   - We find the element 4 as the unique element (mid element is neither equal to the previous nor next element).
   
7. The output is:
   "The single element is: 4"
*/


