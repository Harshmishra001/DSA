// Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.

// Pre-requisite: Binary Search algorithm

// Examples
// Example 1:
// Input Format:
//  N = 4, arr[] = {1,2,2,3}, x = 2
// Result:
//  3
// Explanation:
//  Index 3 is the smallest index such that arr[3] > x.

// Example 2:
// Input Format:
//  N = 6, arr[] = {3,5,8,9,15,19}, x = 9
// Result:
//  4
// Explanation:
//  Index 4 is the smallest index such that arr[4] > x.



// * Brute Force Approach

// Time Complexity: O(N), where N = size of the given array.
// Reason: In the worst case, we have to travel the whole array. This is basically the time complexity of the linear search algorithm.

// Space Complexity: O(1) as we are using no extra space.

// package BinarySearch;

// public class ImplementUpperBound {



//     public static int upperBound(int[] arr, int x, int n) {
//         for (int i = 0; i < n; i++) {
//             if (arr[i] > x) {
//                 // upper bound found:
//                 return i;
//             }
//         }
//         return n;
//     }

//     public static void main(String[] args) {
//         int[] arr = {3, 5, 8, 9, 15, 19};
//         int n = 6, x = 9;
//         int ind = upperBound(arr, x, n);
//         System.out.println("The upper bound is the index: " + ind);
//     }
// }




import java.util.*;

public class ImplementUpperBound  {

    public static int upperBound(int[] arr, int x, int n) {

        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = upperBound(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
    }
}

