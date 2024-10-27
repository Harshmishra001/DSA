// Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.

// Examples
// Example 1:
// Input:
//  arr = [-2,1,-3,4,-1,2,1,-5,4] 
// Output:
//  6 
// Explanation:
//  [4,-1,2,1] has the largest sum = 6. 

// Examples 2:
// Input:
//  arr = [1] 
// Output:
//  1 
// Explanation:
//  Array has only one element and which is giving positive sum of 1. 

// Brute-Force Approach
// Time Complexity: O(n^3)
// Space Complexity: O(1)
// Where n is the number of elements in the array.

import java.util.*;

// public class MaximumSubarraySum {
//     public static int maxSubarraySum(int[] arr, int n) {
//        int  mexi = Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//          for(int j=i;j<n;j++){
//             int sum=0;
//             for(int k=i;k<=j;k++){
//                 sum+=arr[k];
//             }
//            mexi = Math.max(mexi,sum);
//          }
//        }
//        return mexi;
//     }

//     public static void main(String args[]) {
//         int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
//         int n = arr.length;
//         int maxSum = maxSubarraySum(arr, n);
//         System.out.println("The maximum subarray sum is: " + maxSum);

//     }

// }

// BETTER APPROACH

// Time Complexity: O(n^2)
// Space Complexity: O(1)

// public class MaximumSubarraySum{
//     public static int maxSubarraySum(int[] arr, int n) {
//         int maxi = Integer.MIN_VALUE; // maximum sum

//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n; j++) {
//                 // current subarray = arr[i.....j]

//                 //add the current element arr[j]
//                 // to the sum i.e. sum of arr[i...j-1]
//                 sum += arr[j];

//                 maxi = Math.max(maxi, sum); // getting the maximum
//             }
//         }

//         return maxi;
//     }

//     public static void main(String args[]) {
//         int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
//         int n = arr.length;
//         int maxSum = maxSubarraySum(arr, n);
//         System.out.println("The maximum subarray sum is: " + maxSum);

//     }

// }



// OPTIMAL APPROACH
// Kadane's Algorithm 

// public class Main {
//     public static long maxSubarraySum(int[] arr, int n) {
//         long maxi = Long.MIN_VALUE; // maximum sum
//         long sum = 0;

//         for (int i = 0; i < n; i++) {

//             sum += arr[i];

//             if (sum > maxi) {
//                 maxi = sum;
//             }

//             // If sum < 0: discard the sum calculated
//             if (sum < 0) {
//                 sum = 0;
//             }
//         }

//         // To consider the sum of the empty subarray
//         // uncomment the following check:

//         //if (maxi < 0) maxi = 0;

//         return maxi;
//     }

//     public static void main(String args[]) {
//         int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
//         int n = arr.length;
//         long maxSum = maxSubarraySum(arr, n);
//         System.out.println("The maximum subarray sum is: " + maxSum);

//     }

// }



// FOLLOW-UP QN. WE NEED TO PRINT ,MAXIMUM SUM SUBARRAY   , TIME AND SPACE COMPLEXITY REMAINS THE SAME 


import java.util.*;

public class MaximumSubarraySum {
    // Method to find the maximum subarray sum and the subarray itself
    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // Variable to hold the maximum sum found
        long sum = 0; // Variable to keep track of the current subarray sum

        int start = 0; // Starting index of the current subarray
        int ansStart = -1, ansEnd = -1; // Variables to hold the start and end indices of the maximum subarray

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // If the current sum is zero, start a new subarray from index i
            if (sum == 0) start = i;

            // Add the current element to the current sum
            sum += arr[i];

            // Update maximum sum and record the indices if the current sum exceeds maxi
            if (sum > maxi) {
                maxi = sum;
                ansStart = start; // Update the starting index of the maximum subarray
                ansEnd = i; // Update the ending index of the maximum subarray
            }

            // If the current sum drops below zero, reset it
            if (sum < 0) {
                sum = 0; // Discard the current subarray and start fresh
            }
        }

        // Print the subarray that corresponds to the maximum sum
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " "); // Print each element in the subarray
        }
        System.out.print("]"); // Close the subarray print

        // To consider the sum of the empty subarray, uncomment the following check:
        // if (maxi < 0) maxi = 0; // Set maxi to 0 if all numbers are negative

        return maxi; // Return the maximum sum found
    }

    public static void main(String args[]) {
        // Example input array
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length; // Get the length of the array
        long maxSum = maxSubarraySum(arr, n); // Call the maxSubarraySum method
        System.out.println("The maximum subarray sum is: " + maxSum); // Print the result
    }
}













