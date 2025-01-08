package BinarySearch;
// Example 1:
// Input Format:
//  N = 6, k = 4, arr[] = {0,3,4,7,10,9}
// Result:
//  3
// Explanation:
//  The maximum possible minimum distance between any two cows will be 3 when 4 cows are 
// placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively.
//  We cannot make the minimum distance greater than 3 in any ways.

// Example 2:
// Input Format:
//  N = 5, k = 2, arr[] = {4,2,1,3,6}
// Result:
//  5
// Explanation:
//  The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at
//  positions {1, 6}. 

// Why do we need to sort the stalls?

// To arrange the cows in a consecutive manner while ensuring a certain distance between them, 
// the initial step is to sort the stalls based on their positions. In a sorted array, the minimum 
// distance will always be obtained from any two consecutive cows. Arranging the cows in a consecutive
//  manner does not necessarily mean placing them in consecutive stalls.



// Brute Force Approach

// Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
// Reason: O(NlogN) for sorting the array. We are using a loop from 1 to max(stalls[])-min(stalls[]) to check all possible distances. Inside the loop, we are calling canWePlace() function for each distance. Now, inside the canWePlace() function, we are using a loop that runs for N times.

// Space Complexity: O(1) as we are not using any extra space to solve this problem.
// import java.util.*;

// public class AggressiveCows {
//     // Method to check if it's possible to place `k` cows in stalls with at least `dist` distance between them.
//     public static boolean canWePlace(int[] stalls, int dist, int cows) {
//         int n = stalls.length; // Size of the stalls array
//         int cntCows = 1; // Start by placing the first cow at the first stall
//         int last = stalls[0]; // Position of the last placed cow (starting with the first stall)

//         // Loop through the rest of the stalls
//         for (int i = 1; i < n; i++) {
//             // Check if the current stall is far enough (>= dist) from the last placed cow
//             if (stalls[i] - last >= dist) {
//                 cntCows++; // Place the next cow
//                 last = stalls[i]; // Update the last placed cow's position
//             }
//             // If all cows are placed successfully, return true
//             if (cntCows >= cows) return true;
//         }
//         // If not all cows can be placed, return false
//         return false;
//     }

//     // Method to find the maximum possible minimum distance between cows
//     public static int aggressiveCows(int[] stalls, int k) {
//         int n = stalls.length; // Size of the stalls array

//         // Sort the stalls in ascending order to facilitate placement of cows
//         Arrays.sort(stalls);

//         // The largest possible distance between cows is the difference between the first and last stall
//         int limit = stalls[n - 1] - stalls[0];
        
//         // Iterate over all possible distances from 1 to the maximum possible distance
//         for (int i = 1; i <= limit; i++) {
//             // Check if it's possible to place `k` cows with at least `i` distance between them
//             if (canWePlace(stalls, i, k) == false) {
//                 return (i - 1); // If not possible, return the previous distance (i-1)
//             }
//         }
//         // If it's possible to place cows with the maximum possible distance, return the maximum limit
//         return limit;
//     }

//     // Main method to run the program
//     public static void main(String[] args) {
//         // Array of stall positions
//         int[] stalls = {0, 3, 4, 7, 10, 9};
//         int k = 4; // Number of cows to place

//         // Call the aggressiveCows method to find the maximum possible minimum distance
//         int ans = aggressiveCows(stalls, k);

//         // Print the result
//         System.out.println("The maximum possible minimum distance is: " + ans);
//     }
//   }




// Optimal approach

import java.util.*;

public class AggressiveCows {
    
    // Method to check if it's possible to place `k` cows in stalls with at least `dist` distance between them.
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
       
      int n = stalls.length; // Size of the array (number of stalls)
        int cntCows = 1; // Start by placing the first cow at the first stall
        int last = stalls[0]; // Position of the last placed cow (starting with the first stall)

        // Loop through the rest of the stalls
        for (int i = 1; i < n; i++) {
            // Check if the current stall is far enough (>= dist) from the last placed cow
            if (stalls[i] - last >= dist) {
                cntCows++; // Place the next cow
                last = stalls[i]; // Update the last placed cow's position
            }
            // If all cows are placed successfully, return true
            if (cntCows >= cows) return true;
        }
        // If not all cows can be placed, return false
        return false;
    }

    // Method to find the maximum possible minimum distance between cows
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length; // Size of the array (number of stalls)

        // Sort the stalls array in ascending order to facilitate proper cow placement
        Arrays.sort(stalls);

        // The largest possible distance between cows is the difference between the first and last stall
        int low = 1, high = stalls[n - 1] - stalls[0]; // Initial distance range (1 to max possible distance)

        // Perform binary search to find the maximum possible minimum distance
        while (low <= high) {
            int mid = (low + high) / 2; // Middle distance to test
            // If it's possible to place `k` cows with at least `mid` distance, try a larger distance
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1; // We can place cows, so move to larger distances
            } else {
                high = mid - 1; // Can't place cows, so reduce the distance
            }
        }
        // Return the largest possible minimum distance where cows can be placed
        return high;
    }

    public static void main(String[] args) {
        // Array of stall positions
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4; // Number of cows to place

        // Call the aggressiveCows method to find the maximum possible minimum distance
        int ans = aggressiveCows(stalls, k);

        // Print the result
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}

