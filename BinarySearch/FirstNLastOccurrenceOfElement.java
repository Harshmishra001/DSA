
// Given a sorted array arr with possibly some duplicates, the task is to find the first and last occurrences of an element x 
// in the given array.

// Note: If the number x is not found in the array then return both the indices as -1.

// Examples:

// Input: arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
// Output: [2, 5]
// Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5
// Input: arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125], x = 7
// Output: [6, 6]
// Explanation: First and last occurrence of 7 is at index 6
// Input: arr[] = [1, 2, 3], x = 4
// Output: [-1, -1]
// Explanation: No occurrence of 4 in the array, so, output is [-1, -1]


// package BinarySearch;





// brute force approach

// import java.util.ArrayList;

// class FirstNLastOccurrenceOfElement {
//     ArrayList<Integer> find(int arr[], int x) {
//         int first = -1; // Variable to store the first occurrence
//         int last = -1;  // Variable to store the last occurrence

//         // Loop through the array to find the occurrences of x
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == x) {
//                 if (first == -1) {
//                     first = i; // Store the first occurrence
//                 }
//                 last = i; // Update the last occurrence
//             }
//         }

//         // Prepare the result as a list
//         ArrayList<Integer> result = new ArrayList<>();
//         result.add(first);
//         result.add(last);

//         return result;
//     }

//     public static void main(String[] args) {
//         // Example usage
//         FirstNLastOccurrenceOfElement obj = new FirstNLastOccurrenceOfElement();
//         int arr[] = {1, 2, 3, 2, 5, 2, 6};
//         int x = 2;

//         // Call the find method and print the result
//         ArrayList<Integer> result = obj.find(arr, x);
//         System.out.println("First and last occurrence of " + x + ": " + result);
//     }
// }

/* 
Dry Run:

Input:
arr = {1, 2, 3, 2, 5, 2, 6}
x = 2

Execution:
1. Initialize:
   first = -1 (first occurrence index)
   last = -1 (last occurrence index)
   result = [] (empty ArrayList)

2. Iterate through the array:
   - i = 0: arr[0] = 1 (not equal to x). first = -1, last = -1.
   - i = 1: arr[1] = 2 (equal to x).
       - first = 1 (set first occurrence)
       - last = 1 (update last occurrence).
   - i = 2: arr[2] = 3 (not equal to x). first = 1, last = 1.
   - i = 3: arr[3] = 2 (equal to x).
       - last = 3 (update last occurrence).
   - i = 4: arr[4] = 5 (not equal to x). first = 1, last = 3.
   - i = 5: arr[5] = 2 (equal to x).
       - last = 5 (update last occurrence).
   - i = 6: arr[6] = 6 (not equal to x). first = 1, last = 5.

3. Prepare the result:
   Add first and last to result: result = [1, 5].

Output:
First and last occurrence of 2: [1, 5]

Time Complexity:
- O(n), where n is the size of the array.
  The loop iterates through the array once.

Space Complexity:
- O(1) for variables `first` and `last`, as no extra space is used apart from the input array.
- O(2) for the result ArrayList, which is constant space.
  Overall space complexity is O(1).
*/





// optimized approach

// Time Complexity:
// - **Binary Search for First Occurrence**: O(log n)
// - **Binary Search for Last Occurrence**: O(log n)
// - Overall Time Complexity: **O(log n)** because each binary search runs in logarithmic time.

// Space Complexity:
// - **Auxiliary Space**: O(1), as we only use a few extra variables (`start`, `end`, `mid`, `res`) and the result ArrayList of constant size 2.
// - Overall Space Complexity: **O(1)** (constant space).


import java.util.ArrayList;

class FirstNLastOccurrenceBinarySearch {

    ArrayList<Integer> find(int nums[], int x) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        // Handle the edge case where the array is empty
        if (nums.length == 0) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        // Find first and last occurrences using binary search
        ans.add(firstIndexBinarySearch(nums, x));
        ans.add(lastIndexBinarySearch(nums, x));
        return ans;
    }

    // Binary search to find the first occurrence of x
    public int firstIndexBinarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                res = mid;
                end = mid - 1; // Search in the left half for earlier occurrences
            } else if (arr[mid] > k) {
                end = mid - 1; // Search in the left half
            } else {
                start = mid + 1; // Search in the right half
            }
        }

        return res;
    }

    // Binary search to find the last occurrence of x
    public int lastIndexBinarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                res = mid;
                start = mid + 1; // Search in the right half for later occurrences
            } else if (arr[mid] > k) {
                end = mid - 1; // Search in the left half
            } else {
                start = mid + 1; // Search in the right half
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Example usage
        FirstNLastOccurrenceBinarySearch obj = new FirstNLastOccurrenceBinarySearch();
        int nums[] = {1, 2, 2, 2, 3, 4, 5};
        int x = 2;

        // Find the first and last occurrences
        ArrayList<Integer> result = obj.find(nums, x);
        System.out.println("First and last occurrence of " + x + ": " + result);
    }
}

/* 
Dry Run:

Input:
nums = {1, 2, 2, 2, 3, 4, 5}, x = 2

Execution:
1. Initialize:
   ans = []

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

4. Add results to ans:
   ans = [1, 3]

Output:
First and last occurrence of 2: [1, 3]

Time Complexity:
- `O(log n)` for each binary search.
- Overall: `O(log n)`.

Space Complexity:
- O(1) as no additional space is used apart from a constant number of variables.
*/

