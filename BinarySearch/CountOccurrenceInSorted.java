// Problem Statement: You are given a sorted array containing N integers and a number X,
//  you have to find the occurrences of X in the given array.

// Examples
// Example 1:
// Input:
//  N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
// Output
// : 4
// Explanation:
//  3 is occurring 4 times in 
// the given array so it is our answer.

// Example 2:
// Input:
//  N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
// Output
// : 5
// Explanation:
//  2 is occurring 5 times in the given array so it is our answer.



// package BinarySearch;



// brute force approach

// Time Complexity: O(N), N = size of the given array
// Reason: We are traversing the whole array.

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;

//  class  CountOccurrenceInSorted{
//     public static int count(int arr[], int n, int x) {
//         int cnt = 0;
//         for (int i = 0; i < n; i++) {

//             // counting the occurrences:
//             if (arr[i] == x) cnt++;
//         }
//         return cnt;
//     }

//     public static void main(String[] args) {
//         int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
//         int n = 8, x = 8;
//         int ans = count(arr, n, x);
//         System.out.println("The number of occurrences is: " + ans);
//     }
// }








// optimised approach

// Time Complexity:
// - **Binary Search for First Occurrence**: O(log n)
// - **Binary Search for Last Occurrence**: O(log n)
// - Overall Time Complexity: **O(log n)** because each binary search runs independently in logarithmic time.

// Space Complexity:
// - **Auxiliary Space**: O(1), as the extra space used is constant for storing the result of the binary searches and the indices.
// - Overall Space Complexity: **O(1)** (constant space).

class CountOccurrenceInSorted {

    // Function to count the frequency of a target element in a sorted array
    int countFreq(int[] arr, int target) {
        
        // Get the first and last occurrence of the target using binary search
        int first = firstIndexBinarySearch(arr, target);
        int last = lastIndexBinarySearch(arr, target);

        // If either the first or last occurrence is not found, return 0
        if (first == -1 || last == -1) {
            return 0;
        }
        
        // Frequency is the difference between the last and first index + 1
        return (last - first) + 1;
    }

    // Binary search to find the first occurrence of the target
    public int firstIndexBinarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        // Binary search to find the first occurrence of k
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                res = mid;
                end = mid - 1; // Continue searching in the left half
            } else if (arr[mid] > k) {
                end = mid - 1; // Search in the left half
            } else {
                start = mid + 1; // Search in the right half
            }
        }

        return res; // Return the index of the first occurrence, or -1 if not found
    }

    // Binary search to find the last occurrence of the target
    public int lastIndexBinarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        // Binary search to find the last occurrence of k
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                res = mid;
                start = mid + 1; // Continue searching in the right half
            } else if (arr[mid] > k) {
                end = mid - 1; // Search in the left half
            } else {
                start = mid + 1; // Search in the right half
            }
        }

        return res; // Return the index of the last occurrence, or -1 if not found
    }

    // Main method to test the class functionality
    public static void main(String[] args) {
        CountOccurrenceInSorted obj = new CountOccurrenceInSorted();
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        // Get the count of occurrences of target
        int result = obj.countFreq(arr, target);
        System.out.println("Frequency of " + target + " is: " + result);
    }
}

/*
Dry Run:

Input:
arr = {1, 2, 2, 2, 3, 4, 5}, target = 2

Execution:
1. Initialize:
   first = -1, last = -1

2. Call firstIndexBinarySearch:
   - Initial values: start = 0, end = 6, res = -1
   - Iteration 1: mid = 3, arr[3] = 2
       - res = 3, end = 2
   - Iteration 2: mid = 1, arr[1] = 2
       - res = 1, end = 0
   - Iteration 3: mid = 0, arr[0] = 1
       - start = 1
   - Result: first = 1

3. Call lastIndexBinarySearch:
   - Initial values: start = 0, end = 6, res = -1
   - Iteration 1: mid = 3, arr[3] = 2
       - res = 3, start = 4
   - Iteration 2: mid = 5, arr[5] = 4
       - end = 4
   - Iteration 3: mid = 4, arr[4] = 3
       - end = 3
   - Result: last = 3

4. Calculate frequency:
   frequency = (last - first) + 1 = (3 - 1) + 1 = 3

Output:
Frequency of 2 is: 3


*/
