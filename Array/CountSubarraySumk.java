
// Problem Statement: Given an array of integers and an integer k, return the total number of subarrays 
// whose sum equals k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// *Pre-requisite: Longest subarray with given sum


// Examples
// Example 1:
// Input Format:
//  N = 4, array[] = {3, 1, 2, 4}, k = 6
// Result:
//  2
// Explanation:
//  The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].

// Example 2:
// Input Format:
//  N = 3, array[] = {1,2,3}, k = 3
// Result:
//  2
// Explanation:
//  The subarrays that sum up to 3 are [1, 2], and [3].



// BRUTE-FORCE APPROACH

// Time Complexity: O(N3), where N = size of the array.
// Reason: We are using three nested loops here. Though all are not running for exactly N times, the time complexity will be approximately O(N3).

// Space Complexity: O(1) as we are not using any extra space.


// import java.util.*;

// public class CountSubarraySumk {
//     public static int findAllSubarraysWithGivenSum(int arr[], int k) {
//         int n = arr.length; // size of the given array.
//         int cnt = 0; // Number of subarrays:

//         for (int i = 0 ; i < n; i++) { // starting index i
//             for (int j = i; j < n; j++) { // ending index j

//                 // calculate the sum of subarray [i...j]
//                 int sum = 0;
//                 for (int K = i; K <= j; K++)
//                     sum += arr[K];

//                 // Increase the count if sum == k:
//                 if (sum == k)
//                     cnt++;
//             }
//         }
//         return cnt;
//     }

//     public static void main(String[] args) {
//         int[] arr = {3, 1, 2, 4};
//         int k = 6;
//         int cnt = findAllSubarraysWithGivenSum(arr, k);
//         System.out.println("The number of subarrays is: " + cnt);
//     }
// }



// BETTER - APPROACH

// Time Complexity: O(N2), where N = size of the array.
// Reason: We are using two nested loops here. As each of them is running for exactly N times, the time complexity will be approximately O(N2).

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;

// public class CountSubarraySumk {
//     public static int findAllSubarraysWithGivenSum(int arr[], int k) {
//         int n = arr.length; // size of the given array.
//         int cnt = 0; // Number of subarrays:

//         for (int i = 0 ; i < n; i++) { // starting index i
//             int sum = 0;
//             for (int j = i; j < n; j++) { // ending index j
//                 // calculate the sum of subarray [i...j]
//                 // sum of [i..j-1] + arr[j]
//                 sum += arr[j];

//                 // Increase the count if sum == k:
//                 if (sum == k)
//                     cnt++;
//             }
//         }
//         return cnt;
//     }

//     public static void main(String[] args) {
//         int[] arr = {3, 1, 2, 4};
//         int k = 6;
//         int cnt = findAllSubarraysWithGivenSum(arr, k);
//         System.out.println("The number of subarrays is: " + cnt);
//     }
// }  

// OPTIMAL - APPROACH

import java.util.*;

public class CountSubarraySumk {

    // Function to find the count of all subarrays with a given sum.
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        
        // HashMap to store the cumulative frequency of prefix sums
        Map<Integer, Integer> mpp = new HashMap<>();
        
        // Variables to keep track of prefix sum and count of valid subarrays
        int preSum = 0, cnt = 0;

        // Initialize the map with a prefix sum of 0 having frequency 1
        mpp.put(0, 1);

        // Traverse through the array
        for (int i = 0; i < n; i++) {
            // Add current element to the prefix sum
            preSum += arr[i];

            // Calculate the required sum that would give a subarray with sum `k`
            int remove = preSum - k;

            // If this required sum exists in the map, add its frequency to the count
            cnt += mpp.getOrDefault(remove, 0);

            // Update the frequency of the current prefix sum in the map
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4}; // Sample array
        int k = 6; // Target sum
        int cnt = findAllSubarraysWithGivenSum(arr, k); // Call function
        System.out.println("The number of subarrays is: " + cnt); // Print result
    }

    /*
      Dry Run:
      Array: [3, 1, 2, 4], Target Sum: 6
      Steps:
      - Initialize preSum = 0, cnt = 0, mpp = {0:1}
      - Iterate through each element in the array and update preSum, calculate remove, and update cnt.
      
      Iteration 1:
        - i = 0, arr[i] = 3
        - preSum = 3
        - remove = preSum - k = 3 - 6 = -3 (not in mpp)
        - mpp becomes {0:1, 3:1}
      
      Iteration 2:
        - i = 1, arr[i] = 1
        - preSum = 4
        - remove = preSum - k = 4 - 6 = -2 (not in mpp)
        - mpp becomes {0:1, 3:1, 4:1}
      
      Iteration 3:
        - i = 2, arr[i] = 2
        - preSum = 6
        - remove = preSum - k = 6 - 6 = 0 (0 is in mpp with frequency 1)
        - cnt = cnt + mpp[0] = 0 + 1 = 1
        - mpp becomes {0:1, 3:1, 4:1, 6:1}
      
      Iteration 4:
        - i = 3, arr[i] = 4
        - preSum = 10
        - remove = preSum - k = 10 - 6 = 4 (4 is in mpp with frequency 1)
        - cnt = cnt + mpp[4] = 1 + 1 = 2
        - mpp becomes {0:1, 3:1, 4:1, 6:1, 10:1}

      Result:
      - Final count of subarrays with sum 6 is cnt = 2 (subarrays [3, 1, 2] and [2, 4])
    */
}
