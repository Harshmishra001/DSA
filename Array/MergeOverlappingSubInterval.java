
// Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array
//  of non-overlapping intervals.

// Examples
// Example 1:
// Example 1:
// Input: 
//  intervals=[[1,3],[2,6],[8,10],[15,18]]

// Output:
//  [[1,6],[8,10],[15,18]]

// Explanation:
//  Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
//  intervals.

// Example 2:
// Input:
//  [[1,4],[4,5]]

// Output:
//  [[1,5]]

// Explanation:
//  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].



// BRUTE-FORCE APPROACH
// Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
// Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N2.

// Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.

// import java.util.*;
// public class MergeOverlappingSubInterval {

//     // Function to merge overlapping intervals
//     public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
//         int n = arr.length; // Number of intervals

//         // Step 1: Sort the intervals by their start times
//         // This makes sure overlapping intervals are adjacent.
//         Arrays.sort(arr, new Comparator <int[]> () {
            
//             public int compare(int[] a, int[] b) {
//                 return a[0] - b[0]; // Sort by the start time
//             }

//         });

//         List<List<Integer>> ans = new ArrayList<>(); // List to store merged intervals

//         // Step 2: Loop through each interval and merge
//         for (int i = 0; i < n; i++) {
//             int start = arr[i][0]; // Start of the current interval
//             int end = arr[i][1];   // End of the current interval

//             // Step 3: If the interval is already covered by the last merged interval, skip it
//             if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
//                 // The current interval is already merged, move to the next
//                 continue;
//             }

//             // Step 4: Check if the current interval overlaps with future intervals
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[j][0] <= end) { // Overlap detected
//                     // Extend the end of the interval to cover the overlap
//                     end = Math.max(end, arr[j][1]);
//                 } else {
//                     // No more overlaps, stop checking further
//                     break;
//                 }
//             }

//             // Step 5: Add the merged interval to the result list
//             ans.add(Arrays.asList(start, end));
//         }

//         return ans; // Return the final list of merged intervals
//     }

//     public static void main(String[] args) {
//         // Input intervals
//         int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        
//         // Call the function to merge intervals
//         List<List<Integer>> ans = mergeOverlappingIntervals(arr);

//         // Print the merged intervals
//         System.out.println("The merged intervals are:");
//         for (List<Integer> interval : ans) {
//             System.out.print("[" + interval.get(0) + ", " + interval.get(1) + "] ");
//         }
//         System.out.println(); // For formatting
//     }
// }

/*
DRY RUN:

Input intervals: arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}}

Step 1: Sort intervals by start time:
Sorted arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}

Initial values:
- ans = []

---

**Iteration 1 (i = 0):**
- Current interval: [1, 3]
- ans is empty, so add [1, 3] to ans and start merging from here.
- Check the next intervals:
    - [2, 6] overlaps with [1, 3] (since 2 ≤ 3). Update the end of the interval to max(3, 6) = 6.
- Add [1, 6] to ans.
  ans = [[1, 6]]

---

**Iteration 2 (i = 1):**
- Current interval: [2, 6]
- This interval is already covered by the last merged interval ([1, 6]). Skip it.

---

**Iteration 3 (i = 2):**
- Current interval: [8, 10]
- No overlap with the last merged interval ([1, 6]).
- Add [8, 10] to ans.
  ans = [[1, 6], [8, 10]]

---

**Iteration 4 (i = 3):**
- Current interval: [15, 18]
- No overlap with the last merged interval ([8, 10]).
- Add [15, 18] to ans.
  ans = [[1, 6], [8, 10], [15, 18]]

---

**Final Result:**
The merged intervals are: [[1, 6], [8, 10], [15, 18]]
*/




// OPTIMAL APPROACH

// Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
// Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are just using a single loop that runs for N times. So, the time complexity will be O(N).

// Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.

import java.util.*;

public class MergeOverlappingSubInterval {

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length; // size of the array

        // Step 1: Sort the intervals by their start times
        Arrays.sort(arr, new Comparator <int[]> () {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // Compare the start times of intervals
            }
        });

        List<List<Integer>> ans = new ArrayList<>(); // Result list to store merged intervals

        // Step 2: Process each interval
        for (int i = 0; i < n; i++) {
            // Case 1: If result list is empty or current interval does not overlap
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                // Add current interval as a new interval in the result list
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // Case 2: If the current interval overlaps with the last merged interval
            else {
                // Update the end of the last interval to include the current interval
                ans.get(ans.size() - 1).set(1, Math.max( ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }

        return ans; // Return the merged intervals
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}}; // Input intervals
        List<List<Integer>> ans = mergeOverlappingIntervals(arr); // Call the function

        // Print the merged intervals
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}

/*
DRY RUN:

Input intervals: arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}}

Step 1: Sort intervals by start time:
Sorted arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}

Initial values:
ans = []

Iteration 1 (i = 0):
- Current interval: [1, 3]
- Result list (ans) is empty, so add [1, 3].
- ans = [[1, 3]]

Iteration 2 (i = 1):
- Current interval: [2, 6]
- Start of [2, 6] (2) is ≤ end of [1, 3] (3), so they overlap.
- Merge [1, 3] and [2, 6] by updating the end: max(3, 6) = 6.
- ans = [[1, 6]]

Iteration 3 (i = 2):
- Current interval: [8, 10]
- Start of [8, 10] (8) > end of [1, 6] (6), so no overlap.
- Add [8, 10] to ans.
- ans = [[1, 6], [8, 10]]

Iteration 4 (i = 3):
- Current interval: [15, 18]
- Start of [15, 18] (15) > end of [8, 10] (10), so no overlap.
- Add [15, 18] to ans.
- ans = [[1, 6], [8, 10], [15, 18]]

Final Output:
The merged intervals are: [[1, 6], [8, 10], [15, 18]]
*/
