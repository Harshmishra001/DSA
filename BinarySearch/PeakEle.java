package BinarySearch;


/*Problem Statement*: Given an array of length N. Peak element is defined as the element greater than both of its neighbors.
  Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'. 
 Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, 
 return the index of any peak number.
 */ 
// Note: For the first element, the previous element should be considered as negative infinity as well as for the last element, the next element should be considered as negative infinity.

// Pre-requisite: Binary Search Algorithm


// Examples
// Example 1:
// Input Format: arr[] = {1,2,3,4,5,6,7,8,5,1}
// Result: 7
// Explanation: In this example, there is only 1 peak that is at index 7.

// Example 2:
// Input Format: arr[] = {1,2,1,3,5,6,4}
// Result: 1
// Explanation: In this example, there are 2 peak numbers that are at indices 1 and 5. We can consider any of them.

// Example 3:
// Input Format: arr[] = {1, 2, 3, 4, 5}
// Result: 4
// Explanation: In this example, there is only 1 peak that is at the index 4.

// Example 4:
// Input Format: arr[] = {5, 4, 3, 2, 1}
// Result: 0
// Explanation: In this example, there is only 1 peak that is at the index 0.





// *Brute-Force Approach*

// Time Complexity: O(N), N = size of the given array.
// Reason: We are traversing the entire array.

// Space Complexity: O(1) as we are not using any extra space.

// public class PeakEle {
//     public static int findPeakElement(int[] arr) {
//         int n = arr.length; // Size of array.

//         for (int i = 0; i < n; i++) {
//             // Checking for the peak:
//             if ((i == 0 || arr[i - 1] < arr[i]) // Left boundary check or arr[i] > arr[i-1]
//                     && (i == n - 1 || arr[i] > arr[i + 1])) { // Right boundary check or arr[i] > arr[i+1]
//                 return i;
//             }
//         }
//         // Dummy return statement
//         return -1;
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
//         int ans = findPeakElement(arr);
//         System.out.println("The peak is at index: " + ans);
//     }
// }

/*
Dry Run:
Initial Array: [1, 2, 3, 4, 5, 6, 7, 8, 5, 1]

1. i = 0:
   - Left check: (i == 0) is true.
   - Right check: arr[0] < arr[1] (1 < 2), which is true. So, not a peak.

2. i = 1:
   - Left check: arr[0] < arr[1] (1 < 2), which is true.
   - Right check: arr[1] < arr[2] (2 < 3), which is true. So, not a peak.

3. i = 2:
   - Left check: arr[1] < arr[2] (2 < 3), which is true.
   - Right check: arr[2] < arr[3] (3 < 4), which is true. So, not a peak.

4. i = 3:
   - Left check: arr[2] < arr[3] (3 < 4), which is true.
   - Right check: arr[3] < arr[4] (4 < 5), which is true. So, not a peak.

5. i = 4:
   - Left check: arr[3] < arr[4] (4 < 5), which is true.
   - Right check: arr[4] < arr[5] (5 < 6), which is true. So, not a peak.

6. i = 5:
   - Left check: arr[4] < arr[5] (5 < 6), which is true.
   - Right check: arr[5] < arr[6] (6 < 7), which is true. So, not a peak.

7. i = 6:
   - Left check: arr[5] < arr[6] (6 < 7), which is true.
   - Right check: arr[6] < arr[7] (7 < 8), which is true. So, not a peak.

8. i = 7:
   - Left check: arr[6] < arr[7] (7 < 8), which is true.
   - Right check: arr[7] > arr[8] (8 > 5), which is true. This is a peak.

The peak element is at index 7 (value 8).

Output: The peak is at index: 7
*/






// *Optimal approach*

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using binary search to find the minimum.

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


public class PeakEle {
   public static int findPeakElement(int[] arr) {
       int n = arr.length; // Size of array

       // Edge cases:
       if (n == 1) return 0;
       if (arr[0] > arr[1]) return 0;
       if (arr[n - 1] > arr[n - 2]) return n - 1;

       int low = 1, high = n - 2;

       while (low <= high) {
           int mid = (low + high) / 2;

           // If arr[mid] is the peak:
           if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
               return mid;

           // If we are in the left:
           if (arr[mid] > arr[mid - 1]) low = mid + 1;

           // If we are in the right:
           // Or, arr[mid] is a common point:
           else high = mid - 1;
       }
       // Dummy return statement
       return -1;
   }

   public static void main(String[] args) {
       int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
       int ans = findPeakElement(arr);
       System.out.println("The peak is at index: " + ans);
   }
}

/*
Dry Run:
Initial Array: [1, 2, 3, 4, 5, 6, 7, 8, 5, 1]
Size of array (n) = 10

Edge case checks:
- arr[0] < arr[1] -> 1 < 2, so no return.
- arr[9] < arr[8] -> 1 < 5, so no return.
- The array doesn't have a single element, so no return for `n == 1`.

Start the binary search:

1. Set low = 1, high = 8 (n-2).

2. First iteration:
  - mid = (1 + 8) / 2 = 4
  - Check if arr[3] < arr[4] (4 < 5) and arr[4] > arr[5] (5 > 6) -> This is false.
  - Since arr[4] > arr[3] (5 > 4), we move to the right side: `low = mid + 1 = 5`.

3. Second iteration:
  - low = 5, high = 8
  - mid = (5 + 8) / 2 = 6
  - Check if arr[5] < arr[6] (6 < 7) and arr[6] > arr[7] (7 > 8) -> This is false.
  - Since arr[6] > arr[5] (7 > 6), we move to the right side: `low = mid + 1 = 7`.

4. Third iteration:
  - low = 7, high = 8
  - mid = (7 + 8) / 2 = 7
  - Check if arr[6] < arr[7] (7 < 8) and arr[7] > arr[8] (8 > 5) -> This is true.
  - So, index 7 is a peak, and we return 7.

The peak element is at index 7 (value 8).

Output: The peak is at index: 7
*/

