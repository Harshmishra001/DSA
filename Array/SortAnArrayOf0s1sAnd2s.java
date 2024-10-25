// Problem Statement: Given an array consisting of only 0s, 1s, and 2s. 
// Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

// Examples
// Input:
//  nums = [2,0,2,1,1,0]
// Output
// : [0,0,1,1,2,2]

// Input:
//  nums = [2,0,1]
// Output:
//  [0,1,2]

// Input:
//  nums = [0]
// Output:
//  [0]

// BRUTE-FORCE APPROACH -> [Naive Approach] Sorting – O(n * log(n)) Time and O(1) Space
// The naive solution is to simply sort the array using a standard sorting algorithm or sort library function.
//  This will simply place all the 0s first, then all 1s and 2s at last. This approach requires O(n * log(n)) time and O(1) space.

// class Solution {
//     // Function to sort an array of 0s, 1s, and 2s
//     public void sort012(int[] arr) {
//         Arrays.sort(arr);
//     }
// }






//BETTER AAPROACH TIME AND SPACE O(N),O(1)   but not one pass

// class Solution {
//     public void sort012(int[] arr) {
//         int ones = 0;
//         int zeros = 0;
//         int twos = 0;
//         for (int num : arr) {
//             if (num == 0) {
//                 zeros++;
//             } else if (num == 1) {
//                 ones++;
//             } else {
//                 twos++;
//             }
//         }
        
//         // Fill in the sorted array with the correct number of 0s, 1s, and 2s
//         int i = 0;
//         while (i < zeros) {
//             arr[i] = 0;
//             i++;
//         }
//         while (i < zeros + ones) {
//             arr[i] = 1;
//             i++;
//         }
//         while (i < zeros + ones + twos) {
//             arr[i] = 2;
//             i++;
//         }
//         // code here
//     }
// }







// OPTIMAL APPROACH -> Dutch National Flag Algorithm – One Pass – O(n) Time and O(1) Space

// Explanation
// Initialize Pointers:

// low: Points to the boundary where 0s should go.
// mid: Used to scan through the array.
// high: Points to the boundary where 2s should go.
// Process Elements:

// When arr[mid] == 0: Swap arr[low] and arr[mid], then increment both low and mid.
// When arr[mid] == 1: Just increment mid (1s are already in place).
// When arr[mid] == 2: Swap arr[mid] and arr[high], then decrement high.
// Time Complexity: O(n)
// Each element is checked and moved at most once, giving an O(n) complexity.
// Space Complexity: O(1)

public class SortAnArrayOf0s1sAnd2s{
    // Function to sort an array of 0s, 1s, and 2s using the Dutch National Flag algorithm
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        // Loop through the array until mid pointer crosses high pointer
        while (mid <= high) {
            if (arr[mid] == 0) {
                // If the element at mid is 0, swap it with the element at low
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // If the element at mid is 1, it is in the correct position
                mid++;
            } else {
                // If the element at mid is 2, swap it with the element at high
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap elements at indices i and j
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test the sort012 function
    public static void main(String[] args) {
        SortAnArrayOf0s1sAnd2s solution = new SortAnArrayOf0s1sAnd2s();
        int[] arr = {2, 0, 2, 1, 1, 0};
        solution.sort012(arr);

        // Print the sorted array    coz void typ h saare function ka isliye vo s.o.p , solution.function name s ni chlega ese hi krna pdega
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

/*
Dry Run Example:

Input array: {2, 0, 2, 1, 1, 0}

Initial State:
- low = 0, mid = 0, high = 5
- Array: [2, 0, 2, 1, 1, 0]

Steps:

1. Iteration 1:
   - arr[mid] is 2 → swap arr[mid] and arr[high].
   - Array after swap: [0, 0, 2, 1, 1, 2]
   - Update pointers: high = 4, mid stays at 0.

2. Iteration 2:
   - arr[mid] is 0 → swap arr[mid] and arr[low].
   - Array after swap: [0, 0, 2, 1, 1, 2]
   - Update pointers: low = 1, mid = 1.

3. Iteration 3:
   - arr[mid] is 0 → swap arr[mid] and arr[low].
   - Array after swap: [0, 0, 2, 1, 1, 2]
   - Update pointers: low = 2, mid = 2.

4. Iteration 4:
   - arr[mid] is 2 → swap arr[mid] and arr[high].
   - Array after swap: [0, 0, 1, 1, 2, 2]
   - Update pointers: high = 3, mid stays at 2.

5. Iteration 5:
   - arr[mid] is 1 → no swap needed.
   - Update pointer: mid = 3.

6. Iteration 6:
   - arr[mid] is 1 → no swap needed.
   - Update pointer: mid = 4.

Loop terminates when mid > high.

Final Sorted Array: [0, 0, 1, 1, 2, 2]
*/

}

    