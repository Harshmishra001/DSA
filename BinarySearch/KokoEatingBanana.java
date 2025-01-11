// package BinarySearch;



// Brute Force approach

// Time Complexity: O(max(a[]) * N), where max(a[]) is the maximum element in the array and N = size of the array.
// Reason: We are running nested loops. The outer loop runs for max(a[]) times in the worst case and the inner loop runs for N times.

// Space Complexity: O(1) as we are not using any extra space to solve this problem.

// import java.util.*;

// public class KokoEatingBanana  {

//     // Method to find the maximum element in the array
//     public static int findMax(int[] v) {
//         int maxi = Integer.MIN_VALUE; // Initialize maxi to the smallest possible value
//         int n = v.length; // Length of the array
//         // Loop through the array to find the maximum value
//         for (int i = 0; i < n; i++) {
//             maxi = Math.max(maxi, v[i]); // Update maxi with the larger of the current maxi and v[i]
//         }
//         return maxi; // Return the maximum value
//     }

//     // Method to calculate the total hours required to eat all bananas at a given hourly rate
//     public static int calculateTotalHours(int[] v, int hourly) {
//         int totalH = 0; // Total hours required
//         int n = v.length; // Length of the array
//         // Loop through the array to calculate the total hours
//         for (int i = 0; i < n; i++) {
//             totalH += Math.ceil((double)(v[i]) / (double)(hourly)); // Round up the division and add to total hours
//         }
//         return totalH; // Return the total hours
//     }

//     // Method to find the minimum hourly rate (bananas per hour) at which Koko can eat all bananas in h hours
//     public static int minimumRateToEatBananas(int[] v, int h) {
//         // Find the maximum number of bananas in the array
//         int maxi = findMax(v);

//         // Binary search for the minimum rate k
//         for (int i = 1; i <= maxi; i++) {
//             // Calculate the total time required to eat all bananas at rate i
//             int reqTime = calculateTotalHours(v, i);
//             // If the total time is less than or equal to h, return the current rate i
//             if (reqTime <= h) {
//                 return i;
//             }
//         }

//         // In case no rate is found, return the maximum value (which is an extreme case)
//         return maxi;
//     }

//     // Main method to test the solution
//     public static void main(String[] args) {
//         int[] v = {7, 15, 6, 3}; // Bananas in different piles
//         int h = 8; // Number of hours available
//         int ans = minimumRateToEatBananas(v, h); // Find the minimum rate
//         System.out.println("Koko should eat at least " + ans + " bananas/hr.");
//     }
// }

/*
Dry Run Walkthrough:

1. **Input:** 
   - v = {7, 15, 6, 3} (Bananas in piles)
   - h = 8 (Koko has 8 hours to eat all the bananas)

2. **First Step - Find Maximum Number of Bananas:**
   - Call `findMax(v)` to find the maximum number of bananas in the piles.
   - The maximum value in the array is 15 (from the pile {15}).
   - So, maxi = 15.

3. **Second Step - Finding the Minimum Rate:**
   - We now try to find the minimum rate `k` where Koko can eat all the bananas in `h` hours.
   - We iterate through possible rates from 1 to 15 (the maximum number of bananas in a pile).

4. **Iteration 1 (i = 1):**
   - Call `calculateTotalHours(v, 1)` to calculate the total time needed if Koko eats 1 banana per hour:
     - For pile {7}, it will take 7 hours (7 / 1 = 7).
     - For pile {15}, it will take 15 hours (15 / 1 = 15).
     - For pile {6}, it will take 6 hours (6 / 1 = 6).
     - For pile {3}, it will take 3 hours (3 / 1 = 3).
     - Total hours = 7 + 15 + 6 + 3 = 31 hours.
   - Since 31 > 8, the rate of 1 banana/hour is too slow, so we continue.

5. **Iteration 2 (i = 2):**
   - Call `calculateTotalHours(v, 2)` to calculate the total time needed if Koko eats 2 bananas per hour:
     - For pile {7}, it will take 4 hours (7 / 2 = 3.5 → rounded up to 4).
     - For pile {15}, it will take 8 hours (15 / 2 = 7.5 → rounded up to 8).
     - For pile {6}, it will take 3 hours (6 / 2 = 3).
     - For pile {3}, it will take 2 hours (3 / 2 = 1.5 → rounded up to 2).
     - Total hours = 4 + 8 + 3 + 2 = 17 hours.
   - Since 17 > 8, the rate of 2 bananas/hour is also too slow, so we continue.

6. **Iteration 3 (i = 3):**
   - Call `calculateTotalHours(v, 3)` to calculate the total time needed if Koko eats 3 bananas per hour:
     - For pile {7}, it will take 3 hours (7 / 3 = 2.33 → rounded up to 3).
     - For pile {15}, it will take 5 hours (15 / 3 = 5).
     - For pile {6}, it will take 2 hours (6 / 3 = 2).
     - For pile {3}, it will take 1 hour (3 / 3 = 1).
     - Total hours = 3 + 5 + 2 + 1 = 11 hours.
   - Since 11 > 8, the rate of 3 bananas/hour is still too slow, so we continue.

7. **Iteration 4 (i = 4):**
   - Call `calculateTotalHours(v, 4)` to calculate the total time needed if Koko eats 4 bananas per hour:
     - For pile {7}, it will take 2 hours (7 / 4 = 1.75 → rounded up to 2).
     - For pile {15}, it will take 4 hours (15 / 4 = 3.75 → rounded up to 4).
     - For pile {6}, it will take 2 hours (6 / 4 = 1.5 → rounded up to 2).
     - For pile {3}, it will take 1 hour (3 / 4 = 0.75 → rounded up to 1).
     - Total hours = 2 + 4 + 2 + 1 = 9 hours.
   - Since 9 > 8, the rate of 4 bananas/hour is still too slow, so we continue.

8. **Iteration 5 (i = 5):**
   - Call `calculateTotalHours(v, 5)` to calculate the total time needed if Koko eats 5 bananas per hour:
     - For pile {7}, it will take 2 hours (7 / 5 = 1.4 → rounded up to 2).
     - For pile {15}, it will take 3 hours (15 / 5 = 3).
     - For pile {6}, it will take 2 hours (6 / 5 = 1.2 → rounded up to 2).
     - For pile {3}, it will take 1 hour (3 / 5 = 0.6 → rounded up to 1).
     - Total hours = 2 + 3 + 2 + 1 = 8 hours.
   - Since 8 <= 8, Koko can finish all the bananas at 5 bananas per hour.

9. **Result:** The minimum rate required is 5 bananas per hour.

10. **Output:** The program prints: "Koko should eat at least 5 bananas/hr." */








// Optimal approach 

import java.util.*;

public class KokoEatingBanana{

    // Method to find the maximum element in the array
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE; // Initialize maxi to the smallest possible value
        int n = v.length; // Length of the array
        // Loop through the array to find the maximum value
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]); // Update maxi with the larger of the current maxi and v[i]
        }
        return maxi; // Return the maximum value
    }

    // Method to calculate the total hours required to eat all bananas at a given hourly rate
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0; // Total hours required
        int n = v.length; // Length of the array
        // Loop through the array to calculate the total hours
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly)); // Round up the division and add to total hours
        }
        return totalH; // Return the total hours
    }

    // Method to find the minimum hourly rate (bananas per hour) at which Koko can eat all bananas in h hours
    public static int minimumRateToEatBananas(int[] v, int h) {
        int low = 1, high = findMax(v); // Set the range for binary search from 1 to the maximum pile size

        // Apply binary search to find the minimum rate
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle value of the current search range
            int totalH = calculateTotalHours(v, mid); // Calculate the total hours needed to eat all bananas at rate mid   mtlb agr mid 6 aaya toh  6 banana per hr khyega koko
            if (totalH <= h) {
                high = mid - 1; // If total hours are less than or equal to h, try a smaller rate (high = mid - 1) coz we need to find min so right parlt eliminated and search in left part
            } else {
                low = mid + 1; // If total hours are more than h, try a larger rate (low = mid + 1)
            }
        }
        return low; // Return the smallest rate that allows Koko to finish all bananas in h hours
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3}; // Bananas in different piles
        int h = 8; // Number of hours available
        int ans = minimumRateToEatBananas(v, h); // Find the minimum rate
        System.out.println("Koko should eat at least " + ans + " bananas/hr."); // Output the result
    }
}

/*
Dry Run Walkthrough:

1. **Input:** 
   - v = {7, 15, 6, 3} (Bananas in piles)
   - h = 8 (Koko has 8 hours to eat all the bananas)

2. **First Step - Find Maximum Number of Bananas:**
   - Call `findMax(v)` to find the maximum number of bananas in the piles.
   - The maximum value in the array is 15 (from the pile with 15 bananas).
   - So, maxi = 15.

3. **Second Step - Binary Search for Minimum Rate:**
   - We now perform a binary search for the minimum hourly rate `k` such that Koko can finish eating all bananas in `h = 8` hours.
   - The binary search will search between 1 and `maxi` (15 in this case).

4. **First Iteration of Binary Search:**
   - Set `low = 1` and `high = 15`.
   - Calculate `mid = (1 + 15) / 2 = 8`.
   - Call `calculateTotalHours(v, 8)` to calculate the total time needed if Koko eats 8 bananas per hour:
     - For pile {7}, it will take 1 hour (7 / 8 = 0.875 → rounded up to 1).
     - For pile {15}, it will take 2 hours (15 / 8 = 1.875 → rounded up to 2).
     - For pile {6}, it will take 1 hour (6 / 8 = 0.75 → rounded up to 1).
     - For pile {3}, it will take 1 hour (3 / 8 = 0.375 → rounded up to 1).
     - Total hours = 1 + 2 + 1 + 1 = 5 hours.
   - Since 5 hours ≤ 8 hours, Koko can finish all bananas at 8 bananas per hour. So, adjust the `high` value: `high = 8 - 1 = 7`.

5. **Second Iteration of Binary Search:**
   - Set `low = 1` and `high = 7`.
   - Calculate `mid = (1 + 7) / 2 = 4`.
   - Call `calculateTotalHours(v, 4)` to calculate the total time needed if Koko eats 4 bananas per hour:
     - For pile {7}, it will take 2 hours (7 / 4 = 1.75 → rounded up to 2).
     - For pile {15}, it will take 4 hours (15 / 4 = 3.75 → rounded up to 4).
     - For pile {6}, it will take 2 hours (6 / 4 = 1.5 → rounded up to 2).
     - For pile {3}, it will take 1 hour (3 / 4 = 0.75 → rounded up to 1).
     - Total hours = 2 + 4 + 2 + 1 = 9 hours.
   - Since 9 hours > 8 hours, the rate of 4 bananas/hour is too slow. So, adjust the `low` value: `low = 4 + 1 = 5`.

6. **Third Iteration of Binary Search:**
   - Set `low = 5` and `high = 7`.
   - Calculate `mid = (5 + 7) / 2 = 6`.
   - Call `calculateTotalHours(v, 6)` to calculate the total time needed if Koko eats 6 bananas per hour:
     - For pile {7}, it will take 2 hours (7 / 6 = 1.1667 → rounded up to 2).
     - For pile {15}, it will take 3 hours (15 / 6 = 2.5 → rounded up to 3).
     - For pile {6}, it will take 1 hour (6 / 6 = 1).
     - For pile {3}, it will take 1 hour (3 / 6 = 0.5 → rounded up to 1).
     - Total hours = 2 + 3 + 1 + 1 = 7 hours.
   - Since 7 hours ≤ 8 hours, Koko can finish all bananas at 6 bananas per hour. So, adjust the `high` value: `high = 6 - 1 = 5`.

7. **Termination of Binary Search:**
   - Now, `low = 5` and `high = 5`.
   - Since `low = high`, the binary search terminates, and the minimum rate is 5 bananas per hour.

8. **Output:** The program prints: "Koko should eat at least 5 bananas/hr."
*/