// package BinarySearch;

// Problem Statement: Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.

// Pre-requisite: BS-18. Allocate Books or Book Allocation | Hard Binary Search

// Examples
// Example 1:
// Input Format:
//  N = 4, boards[] = {5, 5, 5, 5}, k = 2
// Result:
//  10
// Explanation:
//  We can divide the boards into 2 equal-sized partitions, so each painter gets 10 units of the board and the total time taken is 10.

// Example 2:
// Input Format:
//  N = 4, boards[] = {10, 20, 30, 40}, k = 2
// Result:
//  60
// Explanation:
//  We can divide the first 3 boards for one painter and the last board for the second painter.





// Brute Force Approach



// Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible values of time. Inside the loop, we are calling the countPainters() function for each number. Now, inside the countPainters() function, we are using a loop that runs for N times.

// Space Complexity:  O(1) as we are not using any extra space to solve this problem.

// import java.util.*;

// public class PaintersPartition {
//     public static int countPainters(ArrayList<Integer> boards, int time) {
//         int n = boards.size(); // size of array.
//         int painters = 1;
//         long boardsPainter = 0;
//         for (int i = 0; i < n; i++) {
//             if (boardsPainter + boards.get(i) <= time) {
//                 // allocate board to current painter
//                 boardsPainter += boards.get(i);
//             } else {
//                 // allocate board to next painter
//                 painters++;
//                 boardsPainter = boards.get(i);
//             }
//         }
//         return painters;
//     }

//     public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
//         int low = Collections.max(boards);
//         int high = boards.stream().mapToInt(Integer::intValue).sum();

//         for (int time = low; time <= high; time++) {
//             if (countPainters(boards, time) <= k) {
//                 return time;
//             }
//         }
//         return low;
//     }

//     public static void main(String[] args) {
//         ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
//         int k = 2;
//         int ans = findLargestMinDistance(boards, k);
//         System.out.println("The answer is: " + ans);
//     }
// }


// Optimal Approach

// Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countPainters() function for the value of ‘mid’. Now, inside the countPainters() function, we are using a loop that runs for N times.

// Space Complexity:  O(1) as we are not using any extra space to solve this problem.

import java.util.*;

public class PaintersPartition {
    public static int countPainters(ArrayList<Integer> boards, int time) {
        int n = boards.size(); // size of array.
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                // allocate board to current painter
                boardsPainter += boards.get(i);
            } else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters(boards, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;
        int ans = findLargestMinDistance(boards, k);
        System.out.println("The answer is: " + ans);
    }
}

