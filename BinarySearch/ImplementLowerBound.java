// Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

// Pre-requisite: Binary Search algorithm

// Examples
// Example 1:
// Input Format:
//  N = 4, arr[] = {1,2,2,3}, x = 2
// Result:
//  1
// Explanation:
//  Index 1 is the smallest index such that arr[1] >= x.

// Example 2:
// Input Format:
//  N = 5, arr[] = {3,5,8,15,19}, x = 9
// Result:
//  3
// Explanation:
//  Index 3 is the smallest index such that arr[3] >= x.


// package BinarySearch;


// * Brute Force Approach

// Time Complexity: O(N), where N = size of the given array.
// Reason: In the worst case, we have to travel the whole array. This is basically the time complexity of the linear search algorithm.

// Space Complexity: O(1) as we are using no extra space.

// import java.util.*;

// public class ImplementLowerBound {

//     public static int lowerBound(int[] arr, int n, int x) {
//         for (int i = 0; i < n; i++) {

//             if (arr[i] >= x) {
//                 // lower bound found:
//                 return i;
//             }
//         }
//         return n;
//     }

//     public static void main(String[] args) {
//         int[] arr = {3, 5, 8, 15, 19};
//         int n = 5, x = 9;
//         int ind = lowerBound(arr, n, x);
//         System.out.println("The lower bound is the index: " + ind);
//     }
// }

/*
Dry Run for x = 9:

Array: {3, 5, 8, 15, 19}
n = 5, x = 9

Iteration Details:

Step 1:
i = 0
arr[i] = 3
3 < 9 -> Continue

Step 2:
i = 1
arr[i] = 5
5 < 9 -> Continue

Step 3:
i = 2
arr[i] = 8
8 < 9 -> Continue

Step 4:
i = 3
arr[i] = 15
15 >= 9 -> Return i = 3

Output:
The lower bound is the index: 3
*/






// * Optimal Approach

// Time Complexity: O(logN), where N = size of the given array.
// Reason: We are basically using the Binary Search algorithm.

// Space Complexity: O(1) as we are using no extra space.

import java.util.*;

public class ImplementLowerBound {

    public static int lowerBound(int[] arr, int n, int x) {

        int low = 0, high = n - 1;

        int ans = n;  // If no element >= x is found, we return 'n' (end of the array)

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int ind = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}

/*
Dry Run for x = 9:

Array: {3, 5, 8, 15, 19}
n = 5, x = 9

Step-by-step execution:

Step 1:
low = 0, high = 4
mid = (0 + 4) / 2 = 2
arr[mid] = 8
8 < 9 -> low = mid + 1 = 3

Step 2:
low = 3, high = 4
mid = (3 + 4) / 2 = 3
arr[mid] = 15
15 >= 9 -> ans = 3, high = mid - 1 = 2

Step 3:
low = 3, high = 2
(low > high, exit loop)

Output:
The lower bound is the index: 3
*/
