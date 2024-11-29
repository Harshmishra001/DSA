// Problem statement: You are given a sorted array of integers and a target, your task is to search for
//  the target in the given array. Assume the given array does not contain any duplicate numbers.

// Let’s say the given array is = {3, 4, 6, 7, 9, 12, 16, 17} and target = 6.




// * Iterative Implementation

// *So the overall time complexity is O(logN), where N = size of the given array.


package BinarySearch;

// import java.util.*;

// public class BinarySearchfindXinsorted {

//     public static int binarySearch(int[] nums, int target) {

//         int n = nums.length; // size of the array.
//         int low = 0, high = n - 1;

//         // Perform the steps:
//         while (low <= high) {
//             int mid = (low + high) / 2;
//             if (nums[mid] == target) return mid;
//             else if (target > nums[mid]) low = mid + 1;
//             else high = mid - 1;
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
//         int target = 6;
//         int ind = binarySearch(a, target);
//         if (ind == -1)
//             System.out.println("The target is not present.");
//         else
//             System.out.println("The target is at index: " + ind);
//     }
// }

/*
Dry Run for Target = 6:

Array: {3, 4, 6, 7, 9, 12, 16, 17}
Target: 6

Step 1:
low = 0, high = 7
mid = (0 + 7) / 2 = 3
nums[mid] = 7
6 < 7 -> high = mid - 1 = 2

Step 2:
low = 0, high = 2
mid = (0 + 2) / 2 = 1
nums[mid] = 4
6 > 4 -> low = mid + 1 = 2

Step 3:
low = 2, high = 2
mid = (2 + 2) / 2 = 2
nums[mid] = 6
6 == 6 -> Return mid = 2

Output:
The target is at index: 2
*/







// * Recursive Approach

// So the overall time complexity is O(logN), where N = size of the given array.

import java.util.*;

public class BinarySearchfindXinsorted {

    public static int binarySearch(int[] nums, int low, int high, int target) {
        
        if (low > high) return -1; // Base case.

        // Perform the steps:
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        return binarySearch(nums, low, mid - 1, target);
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        int ind = search(a, target);
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}

/*
Dry Run for Target = 6:

Array: {3, 4, 6, 7, 9, 12, 16, 17}
Target: 6

Recursive Calls:

Call 1:
low = 0, high = 7
mid = (0 + 7) / 2 = 3
nums[mid] = 7
6 < 7 -> binarySearch(nums, 0, 2, 6)

Call 2:
low = 0, high = 2
mid = (0 + 2) / 2 = 1
nums[mid] = 4
6 > 4 -> binarySearch(nums, 2, 2, 6)

Call 3:
low = 2, high = 2
mid = (2 + 2) / 2 = 2
nums[mid] = 6
6 == 6 -> Return 2

Output:
The target is at index: 2
*/
