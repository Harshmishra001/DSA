// package BinarySearch;



// Problem Statement: You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'.
//  Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, 
// the sum of the division's result is less than or equal to the given threshold value.

// Examples
// Example 1:
// Input Format:
//  N = 5, arr[] = {1,2,3,4,5}, limit = 8
// Result:
//  3
// Explanation:
//  We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
// The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

// Example 2:
// Input Format:
//  N = 4, arr[] = {8,4,2,3}, limit = 10
// Result:
//  2
// Explanation:
//  If we choose 1, we get 17 as the sum. If we choose 2, we get 9(4+2+1+2) <= 10 as the answer. So, 2 is the answer.



// Point to remember:

// While dividing the array elements with a chosen number, we will always take the ceiling value. And then we will consider their summation. For example, 3 / 2 = 2.
// Observation: 

// Minimum possible divisor: We can easily consider 1 as the minimum divisor as it is the smallest positive integer.
// Maximum possible divisor: If we observe, we can conclude the maximum element in the array i.e. max(arr[]) is the maximum possible divisor. Any number > max(arr[]), will give the exact same result as max(arr[]) does. This divisor will generate the minimum possible result i.e. n(1 for each element), where n = size of the array.
// With these observations, we can surely say that our answer will lie in the range 
// [1, max(arr[])].



// Brute Force Approach

// Time Complexity: O(max(arr[])*N), where max(arr[]) = maximum element in the array, N = size of the array.
// Reason: We are using nested loops. The outer loop runs from 1 to max(arr[]) and the inner loop runs for N times.

// Space Complexity: O(1) as we are not using any extra space to solve this problem.



// import java.util.*;

// public class SmallestDivisorGvnThreshold  {
//     // Function to find the smallest divisor such that the sum of the ceiling divisions is <= limit
//     public static int smallestDivisor(int[] arr, int limit) {
//         int n = arr.length; // Size of the array
        
//         // Find the maximum element in the array
//         int maxi = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             maxi = Math.max(maxi, arr[i]);
//         }

//         // Try all divisors from 1 to maxi
//         for (int d = 1; d <= maxi; d++) {
//             int sum = 0;
//             // Calculate the sum of the ceil divisions of each element by d
//             for (int i = 0; i < n; i++) {
//                 sum += Math.ceil((double)(arr[i]) / (double)(d));
//             }

//             // If the sum is less than or equal to the limit, return this divisor
//             if (sum <= limit)
//                 return d;
//         }
//         return -1; // If no divisor satisfies the condition
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5}; // Example array
//         int limit = 8; // Example limit
        
//         // Get the smallest divisor
//         int ans = smallestDivisor(arr, limit);
        
//         // Output the result
//         System.out.println("The minimum divisor is: " + ans);
//     }
// }

/*
Dry Run:

Input: 
arr = {1, 2, 3, 4, 5}
limit = 8

Step 1: Find the maximum element in the array:
- maxi = max(1, 2, 3, 4, 5) = 5

Step 2: Try divisors from 1 to maxi (which is 5)

- **For divisor d = 1**:
  - Calculate the sum of the ceiling of divisions:
    - sum = ceil(1/1) + ceil(2/1) + ceil(3/1) + ceil(4/1) + ceil(5/1)
    - sum = 1 + 2 + 3 + 4 + 5 = 15
  - sum (15) > limit (8), so continue to the next divisor.

- **For divisor d = 2**:
  - Calculate the sum of the ceiling of divisions:
    - sum = ceil(1/2) + ceil(2/2) + ceil(3/2) + ceil(4/2) + ceil(5/2)
    - sum = 1 + 1 + 2 + 2 + 3 = 9
  - sum (9) > limit (8), so continue to the next divisor.

- **For divisor d = 3**:
  - Calculate the sum of the ceiling of divisions:
    - sum = ceil(1/3) + ceil(2/3) + ceil(3/3) + ceil(4/3) + ceil(5/3)
    - sum = 1 + 1 + 1 + 2 + 2 = 7
  - sum (7) <= limit (8), so return d = 3.

Output:
The minimum divisor is: 3
*/



// optimal approach 

// Time Complexity: O(log(max(arr[]))*N), where max(arr[]) = maximum element in the array, N = size of the array.
// Reason: We are applying binary search on our answers that are in the range of [1, max(arr[])]. For every possible divisor ‘mid’, we call the sumByD() function. Inside that function, we are traversing the entire array, which results in O(N).

// Space Complexity: O(1) as we are not using any extra space to solve this problem.

import java.util.*;

public class SmallestDivisorGvnThreshold {
   
  // Function to calculate the sum of the ceiling of the divisions of array elements by the divisor
    public static int sumByD(int[] arr, int div) {
        int n = arr.length; // Size of the array
        int sum = 0;
        // Find the summation of division values:
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div)); // Adding the ceiling of arr[i] divided by div
        }
        return sum; // Return the sum
    }

    // Function to find the smallest divisor that satisfies the condition sum <= limit
    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length; // Size of the array
        if (n > limit) return -1; // If the size of the array is greater than the limit, return -1
        
        // Find the maximum element in the array
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]); // Find the maximum element
        }

        int low = 1, high = maxi; // Start with the lowest divisor 1, and the highest as the max element in the array

        // Apply binary search to find the smallest divisor
        while (low <= high) {
            int mid = (low + high) / 2; // Get the middle divisor
            if (sumByD(arr, mid) <= limit) { // If the sum of divisions is less than or equal to the limit
                high = mid - 1; // Try a smaller divisor
            } else {
                low = mid + 1; // Otherwise, try a larger divisor
            }
        }
        return low; // The smallest divisor that satisfies the condition
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int limit = 8; // Example limit
        
        // Find the smallest divisor
        int ans = smallestDivisor(arr, limit);
        
        // Output the result
        System.out.println("The minimum divisor is: " + ans);
    }
}

/*
Dry Run:

Input: 
arr = {1, 2, 3, 4, 5}
limit = 8

Step 1: Find the maximum element in the array:
- maxi = max(1, 2, 3, 4, 5) = 5

Step 2: Apply binary search to find the smallest divisor between 1 and maxi (which is 5):

- **For divisor d = 3** (mid value):
  - Calculate the sum of ceiling divisions:
    - sum = ceil(1/3) + ceil(2/3) + ceil(3/3) + ceil(4/3) + ceil(5/3)
    - sum = 1 + 1 + 1 + 2 + 2 = 7
  - sum (7) <= limit (8), so move the high pointer to mid - 1: high = 2

- **For divisor d = 2** (new mid value):
  - Calculate the sum of ceiling divisions:
    - sum = ceil(1/2) + ceil(2/2) + ceil(3/2) + ceil(4/2) + ceil(5/2)
    - sum = 1 + 1 + 2 + 2 + 3 = 9
  - sum (9) > limit (8), so move the low pointer to mid + 1: low = 3

- Now, low = 3 and high = 2, so the loop terminates and we return low = 3.

Output:
The minimum divisor is: 3
*/
