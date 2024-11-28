
// Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.

// Examples
// Example 1:
// Input:

//  Nums = [1,2,3,4,5,0]
// Output:

//  120
// Explanation:

//  In the given array, we can see 1×2×3×4×5 gives maximum product value.


// Example 2:
// Input:
//  Nums = [1,2,-3,0,-4,-5]
// Output:

//  20
// Explanation:

//  In the given array, we can see (-4)×(-5) gives maximum product value.





// BRUTE- FORCE APPROACH

// Time Complexity: O(N3)

// Reason: We are using 3 nested loops for finding all possible subarrays and their product.

// Space Complexity: O(1)

// Reason: No extra data structure was used


// import java.util.*;

// public class MaxProductSubarray {

//     // Function to calculate the maximum product subarray
//     static int maxProductSubArray(int arr[]) {
//         // Initialize result with the smallest possible integer value
//         int result = Integer.MIN_VALUE;

//         // Outer loop: starting index of the subarray
//         for (int i = 0; i < arr.length; i++) {
//             // Inner loop: ending index of the subarray
//             for (int j = i; j < arr.length; j++) {
//                 int prod = 1; // Variable to store the product of the current subarray

//                 // Loop through the subarray from index i to j
//                 for (int k = i; k <= j; k++) {
//                     prod *= arr[k]; // Multiply each element in the subarray
//                 }

//                 // Update the result if the current product is greater
//                 result = Math.max(result, prod);
//             }
//         }

//         return result; // Return the maximum product found
//     }

//     public static void main(String[] args) {
//         int nums[] = {1, 2, -3, 0, -4, -5}; // Input array
//         int answer = maxProductSubArray(nums); // Call the function
//         System.out.print("The maximum product subarray is: " + answer); // Output result
//     }
// }

/*
Dry Run for Input Array: nums[] = {1, 2, -3, 0, -4, -5}

Initialization:
- result = Integer.MIN_VALUE

Execution:
1. Outer loop (i = 0):
   - Subarrays: [1], [1, 2], [1, 2, -3], [1, 2, -3, 0], [1, 2, -3, 0, -4], [1, 2, -3, 0, -4, -5]
   - Products: 1, 2, -6, 0, 0, 0
   - result = 2

2. Outer loop (i = 1):
   - Subarrays: [2], [2, -3], [2, -3, 0], [2, -3, 0, -4], [2, -3, 0, -4, -5]
   - Products: 2, -6, 0, 0, 0
   - result = 2

3. Outer loop (i = 2):
   - Subarrays: [-3], [-3, 0], [-3, 0, -4], [-3, 0, -4, -5]
   - Products: -3, 0, 0, 0
   - result = 2

4. Outer loop (i = 3):
   - Subarrays: [0], [0, -4], [0, -4, -5]
   - Products: 0, 0, 0
   - result = 2

5. Outer loop (i = 4):
   - Subarrays: [-4], [-4, -5]
   - Products: -4, 20
   - result = 20

6. Outer loop (i = 5):
   - Subarray: [-5]
   - Product: -5
   - result = 20

Final Result:
- Maximum product of any subarray = 20
*/




// OPTIMAL APPROACH

// Time Complexity: O(N)

// Reason: A single iteration is used.

// Space Complexity: O(1)

// Reason: No extra data structure is used for computation

// The following approach is motivated by Kandane’s algorithm. To know Kadane’s Algorithm follow Kadane's Algorithm

import java.util.*;

public class MaxProductSubarray {

    // Function to calculate the maximum product subarray using optimized approach
    static int maxProductSubArray(int arr[]) {
        // Initialize prod1 and prod2 to the first element
        // prod1: Tracks the maximum product at the current position
        // prod2: Tracks the minimum product at the current position (to handle negative values)
        // result: Stores the overall maximum product
        int prod1 = arr[0], prod2 = arr[0], result = arr[0];

        // Traverse the array from the second element onwards
        for (int i = 1; i < arr.length; i++) {
            // Temporary variable to store the maximum product at the current step
            int temp = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * arr[i]));

            // Update prod2 to the minimum product at the current step
            prod2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));

            // Update prod1 with the temporary maximum value
            prod1 = temp;

            // Update the result with the maximum of the current result and prod1
            result = Math.max(result, prod1);
        }

        return result; // Return the maximum product subarray
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, -3, 0, -4, -5}; // Input array
        int answer = maxProductSubArray(nums); // Call the function
        System.out.print("The maximum product subarray is: " + answer); // Output result
    }
}

/*
Dry Run for Input Array: nums[] = {1, 2, -3, 0, -4, -5}

Initialization:
- prod1 = 1, prod2 = 1, result = 1

Execution:
1. i = 1, arr[i] = 2:
   - temp = max(2, max(1 * 2, 1 * 2)) = 2
   - prod2 = min(2, min(1 * 2, 1 * 2)) = 2
   - prod1 = 2
   - result = max(1, 2) = 2

2. i = 2, arr[i] = -3:
   - temp = max(-3, max(2 * -3, 2 * -3)) = -3
   - prod2 = min(-3, min(2 * -3, 2 * -3)) = -6
   - prod1 = -3
   - result = max(2, -3) = 2

3. i = 3, arr[i] = 0:
   - temp = max(0, max(-3 * 0, -6 * 0)) = 0
   - prod2 = min(0, min(-3 * 0, -6 * 0)) = 0
   - prod1 = 0
   - result = max(2, 0) = 2

4. i = 4, arr[i] = -4:
   - temp = max(-4, max(0 * -4, 0 * -4)) = -4
   - prod2 = min(-4, min(0 * -4, 0 * -4)) = -4
   - prod1 = -4
   - result = max(2, -4) = 2

5. i = 5, arr[i] = -5:
   - temp = max(-5, max(-4 * -5, -4 * -5)) = 20
   - prod2 = min(-5, min(-4 * -5, -4 * -5)) = -5
   - prod1 = 20
   - result = max(2, 20) = 20

Final Result:
- Maximum product of any subarray = 20
*/
