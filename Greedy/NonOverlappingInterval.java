import java.util.Arrays;

public class NonOverlappingInterval {
    /**
     * Function to find the minimum number of intervals to remove to make the rest
     * non-overlapping.
     * Time Complexity: O(n log n) (due to sorting)
     * Space Complexity: O(1) (in-place operations)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1]; // Track the end of the last non-overlapping interval
        int count = 0; // Count of intervals to remove

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) { // Overlapping interval
                count++;
            } else {
                end = intervals[i][1]; // Update the end to the current interval's end
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NonOverlappingInterval solution = new NonOverlappingInterval();

        int[][] intervals1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println("Minimum intervals to remove: " + solution.eraseOverlapIntervals(intervals1)); // Output: 1

        int[][] intervals2 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        System.out.println("Minimum intervals to remove: " + solution.eraseOverlapIntervals(intervals2)); // Output: 2

        int[][] intervals3 = { { 1, 2 }, { 2, 3 } };
        System.out.println("Minimum intervals to remove: " + solution.eraseOverlapIntervals(intervals3)); // Output: 0
    }
}
// ---

// ### **Example Input**
// ```java
// int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
// ```

// ---

// ### **Step 1: Sort Intervals by End Time**
// We sort the intervals based on their end times:

// **Original:**  
// `[[1,2], [2,3], [3,4], [1,3]]`  

// **Sorted:**  
// `[[1,2], [2,3], [1,3], [3,4]]`  
// (Sorted by the second element in ascending order)

// ---

// ### **Step 2: Iterate Through the Sorted Intervals**
// - **Initialize** `count = 0` (to keep track of removed intervals).  
// - **Set `End = 2`** (end time of the first interval `[1,2]`).  

// 1. **Interval `[2,3]`**
//    - `2 (start) >= 2 (End)`, so there's **no overlap**.
//    - Update `End = 3`.

// 2. **Interval `[1,3]`**
//    - `1 (start) < 3 (End)`, so there's **an overlap**.
//    - **Remove this interval**, increment `count = 1`.
//    - `End` remains `3`.

// 3. **Interval `[3,4]`**
//    - `3 (start) >= 3 (End)`, so there's **no overlap**.
//    - Update `End = 4`.

// ---

// ### **Final Output**
// - **Total removed intervals:** `1`
