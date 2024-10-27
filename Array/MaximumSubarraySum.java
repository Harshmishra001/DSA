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
    public static long maxSubarraySum(int[] arr, int n) {

        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }

    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }

}












