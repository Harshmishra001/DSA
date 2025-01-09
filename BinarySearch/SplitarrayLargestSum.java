package BinarySearch;
// Problem Statement: Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Pre-requisite: BS-18. Allocate Books or Book Allocation | Hard Binary Search

// Examples
// Example 1:
// Input Format:
//  N = 5, a[] = {1,2,3,4,5}, k = 3
// Result:
//  6
// Explanation:
//  There are many ways to split the array a[] into k consecutive subarrays. The best way to do this is to split the array a[] into [1, 2, 3], [4], and [5], where the largest sum among the three subarrays is only 6.

// Example 2:
// Input Format:
//  N = 3, a[] = {3,5,1}, k = 3
// Result:
//  5
// Explanation:
//  There is only one way to split the array a[] into 3 subarrays, i.e., [3], [5], and [1]. The largest sum among these subarrays is 5.





// Brute Force Approach

// Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible values of time. Inside the loop, we are calling the countPartitions() function for each number. Now, inside the countPartitions() function, we are using a loop that runs for N times.

// Space Complexity:  O(1) as we are not using any extra space to solve this problem.

// import java.util.*;

// public class SplitarrayLargestSum  {
//     public static int countPartitions(int[] a, int maxSum) {
//         int n = a.length; //size of array.
//         int partitions = 1;
//         long subarraySum = 0;
//         for (int i = 0; i < n; i++) {
//             if (subarraySum + a[i] <= maxSum) {
//                 //insert element to current subarray
//                 subarraySum += a[i];
//             } else {
//                 //insert element to next subarray
//                 partitions++;
//                 subarraySum = a[i];
//             }
//         }
//         return partitions;
//     }

//     public static int largestSubarraySumMinimized(int[] a, int k) {
//         int low = a[0];
//         int high = 0;
//         //find maximum and summation:
//         for (int i = 0; i < a.length; i++) {
//             low = Math.max(low, a[i]);
//             high += a[i];
//         }

//         for (int maxSum = low; maxSum <= high; maxSum++) {
//             if (countPartitions(a, maxSum) == k)
//                 return maxSum;
//         }
//         return low;
//     }

//     public static void main(String[] args) {
//         int[] a = {10, 20, 30, 40};
//         int k = 2;
//         int ans = largestSubarraySumMinimized(a, k);
//         System.out.println("The answer is: " + ans);
//     }
// }





// Optimal Approach

// Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countPartitions() function for the value of ‘mid’. Now, inside the countPartitions() function, we are using a loop that runs for N times.

// Space Complexity:  O(1) as we are not using any extra space to solve this problem.


import java.util.*;

public class SplitarrayLargestSum  {
    public static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(a, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}

