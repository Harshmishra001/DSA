// Problem Statement: Given a non-empty array of integers arr, every element appears twice
//  except for one. Find that single one.

// Examples
// Example 1:
// Input Format:
//  arr[] = {2,2,1}
// Result:
//  1
// Explanation:
//  In this array, only the element 1 appear once and so it is the answer.

// Example 2:
// Input Format:
//  arr[] = {4,1,2,1,2}
// Result:
//  4
// Explanation:
//  In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.

import java.util.*;

// SIMILAR XOR OF ALL NO. APPROACH LIKE MISSINGNUMBER
 
// BRUTE-FORCE APPROACH
// T.C->O(N^2)
// S.C->O(1)

// public class WhichNumberAppearedOnes {
//    public static int getSingleElement(int[] arr) {
//         // Size of the array:
//         int n = arr.length;

//         // USE NESTED LOOP
//         for (int i = 0; i < n; i++) {
//             int num = arr[i]; // selected element
//             int count = 0;
//             // find the occurrence using linear search:
//             for (int j = 0; j < n; j++) {
//                 if (arr[j] == num)
//                     count++;
//             }
//             // if the occurrence is 1 return ans:
//             if (count == 1) return num;
//         }

//         // This line will never execute
//         // if the array contains a single element.
//         return -1;
//     }

//     public static void main(String args[]) {
//         int[] arr = {4, 1, 2, 1, 2};
//         int ans = getSingleElement(arr);
//         System.out.println("The single element is: " + ans);
//     }
// }

/*
Dry Run:

1. Input array: arr = {4, 1, 2, 1, 2}
2. n = arr.length => n = 5

First outer loop iteration (i = 0):
- num = arr[0] = 4
- count = 0
- Inner loop:
  - j = 0: arr[0] == 4 -> count = 1
  - j = 1: arr[1] == 4 -> count = 1 (no increment)
  - j = 2: arr[2] == 4 -> count = 1 (no increment)
  - j = 3: arr[3] == 4 -> count = 1 (no increment)
  - j = 4: arr[4] == 4 -> count = 1 (no increment)
- After inner loop: count = 1
- count == 1, so return 4.

Final output: "The single element is: 4"
*/





// OPTIMAL APPROACH

// T.C->O(N)
// S.C->O(1)
public class WhichNumberAppearedOnes {

    public static int getSingleElement(int[] arr) {
        // Size of the array:
        int n = arr.length;

        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }

    public static void main(String args[]) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}

/*
Dry Run:

1. Input array: arr = {4, 1, 2, 1, 2}
2. n = arr.length => n = 5
3. Initialize xorr = 0

Loop through the array and apply XOR:

- i = 0: xorr = 0 ^ arr[0] (4) => xorr = 4
- i = 1: xorr = 4 ^ arr[1] (1) => xorr = 5
- i = 2: xorr = 5 ^ arr[2] (2) => xorr = 7
- i = 3: xorr = 7 ^ arr[3] (1) => xorr = 6
- i = 4: xorr = 6 ^ arr[4] (2) => xorr = 4

Final value of xorr = 4, which is the single element.

Final output: "The single element is: 4"
*/
