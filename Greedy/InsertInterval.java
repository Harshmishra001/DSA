// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the 
// start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given 
// an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
//  still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


public class InsertInterval {   //o(n), o(n)
  // The insert method takes an array of intervals and a new interval as input
  // It returns a new array of intervals after inserting the new interval
  int[][] insert(int[][] intervals, int[] newInterval) {
    // Initialize a result array with size one more than the input intervals array
    int[][] result = new int[intervals.length + 1][2];
    int i = 0, j = 0;

    // Add all intervals that end before the new interval starts
    // These intervals will remain unchanged in the result array
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      result[j++] = intervals[i++];
    }

    // Merge overlapping intervals
    // If the current interval overlaps with the new interval, update the new interval
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
    }

    // Add the updated new interval to the result array
    result[j++] = newInterval;

    // Add remaining intervals
    // These intervals will remain unchanged in the result array
    while (i < intervals.length) {
      result[j++] = intervals[i++];
    }

    // Return the result array, resized to fit the actual number of intervals
    return java.util.Arrays.copyOf(result, j);
  }
  public static void main(String[] args) {
    // Test data
    int[][] intervals = {{1, 3}, {6, 9}};
    int[] newInterval = {2, 5};

    // Call the insert method
    InsertInterval insertInterval = new InsertInterval();
    int[][] result = insertInterval.insert(intervals, newInterval);

    // Print the result
    System.out.println("Original Intervals: ");
    for (int[] interval : intervals) {
      System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }

    System.out.println("\nNew Interval: [" + newInterval[0] + ", " + newInterval[1] + "]");
    System.out.println("\nIntervals after inserting the new interval: ");
    for (int[] interval : result) {
      System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }
  }

}