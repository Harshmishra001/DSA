// package BinarySearch;
// Problem Statement: You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days.
// The weights of the packages are given in an array 'of weights'. The packages are loaded on the conveyor belts every day in the same order as they appear in the array. The loaded weights must not exceed the maximum weight capacity of the ship.
// Find out the least-weight capacity so that you can ship all the packages within 'd' days.

// Examples
// Example 1:
// Input Format:
//  N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
// Result:
//  9
// Explanation:
//  If the ship capacity is 9, the shipment will be done in the following manner:
// Day         Weights                Total
// 1        -       5, 4          -         9
// 2        -       5, 2          -         7
// 3        -       3, 4          -         7
// 4        -       5              -        5
// 5        -       6              -        6
// So, the least capacity should be 9.

// Example 2:
// Input Format:
//  N = 10, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 1
// Result:
//  55
// Explanation:
//  We have to ship all the goods in a single day. So, the weight capacity should be the summation of all the weights i.e. 55.

// Observation:

// Minimum ship capacity: The minimum ship capacity should be the maximum value in the given array. Let’s understand using an example. Assume the given weights array is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} and the ship capacity is 8. Now in the question, it is clearly stated that the loaded weights in the ship must not exceed the maximum weight capacity of the ship. For this constraint, we can never ship the weights 9 and 10, if the ship capacity is 8. That is why, in order to ship all the weights, the minimum ship capacity should be equal to the maximum of the weights array i.e. nax(weights[]).
// Maximum capacity: If the ship capacity is equal to the sum of all the weights, we can ship all goods within a single day. Any capacity greater than this will yield the same result. So, the maximum capacity will be the summation of all the weights i.e. sum(weights[]).
// From the observations, it is clear that our answer lies in the range
// [max(weights[]), sum(weights[])].

// How to calculate the number of days required to ship all the weights for a certain ship capacity:

// In order to calculate this, we will write a function findDays(). This function accepts the weights array and a capacity as parameters and returns the number of days required for that particular capacity. The steps will be the following:

// findDays(weights[], cap):

// We will declare to variables i.e. ‘days’(representing the required days) and ‘load’ (representing the loaded weights in the ship). As we are on the first day, ‘days’ should be initialized with 1 and ‘load’ should be initialized with 0.
// Next, we will use a loop(say i) to iterate over the weights. For each weight, weights[i], we will check the following:
// If load+weights[i] > cap: If upon adding current weight with load exceeds the ship capacity, we will move on to the next day(i.e. day = day+1) and then load the current weight(i.e. Set load to weights[i], load = weights[i]).
// Otherwise, We will just add the current weight to the load(i.e. load = load+weights[i]).
// Finally, we will return ‘days’ which represents the number of days required.



// Brute Force Approach

// Time Complexity: O(N * (sum(weights[]) - max(weights[]) + 1)), where sum(weights[]) = summation of all the weights, max(weights[]) = maximum of all the weights, N = size of the weights array.
// Reason: We are using a loop from max(weights[]) to sum(weights[]) to check all possible weights. Inside the loop, we are calling findDays() function for each weight. Now, inside the findDays() function, we are using a loop that runs for N times.

// Space Complexity: O(1) as we are not using any extra space to solve this problem.

// import java.util.*;

// public class CapacityToShippackageWithinDdays {
//     public static int findDays(int[] weights, int cap) {
//         int days = 1; // Start with the first day.
//         int load = 0; // The current load on the ship.
//         int n = weights.length; // Size of the weights array.
        
//         for (int i = 0; i < n; i++) {
//             if (load + weights[i] > cap) {
//                 days += 1; // Move to the next day.
//                 load = weights[i]; // Start the load for the new day with the current package's weight.
//             } else {
//                 load += weights[i]; // Add weight to the current day's load.
//             }
//         }
//         return days; // Return total number of days.
//     }

//     public static int leastWeightCapacity(int[] weights, int d) {
//         int maxi = Integer.MIN_VALUE, sum = 0;
        
//         for (int i = 0; i < weights.length; i++) {
//             sum += weights[i];
//             maxi = Math.max(maxi, weights[i]); // Find the maximum weight.
//         }

//         for (int i = maxi; i <= sum; i++) {
//             if (findDays(weights, i) <= d) {
//                 return i; // Return the minimum capacity that works.
//             }
//         }
//         return -1; // Return -1 if no valid capacity is found.
//     }

//     public static void main(String[] args) {
//         int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
//         int d = 5;
//         int ans = leastWeightCapacity(weights, d);
//         System.out.println("The minimum capacity should be: " + ans);
//     }
// }


// Dry Run:
// Input:
// Weights = {5, 4, 5, 2, 3, 4, 5, 6}
// d = 5
// Step 1: Calculate Maximum and Total Weight
// We first calculate the maximum weight (maxi) and total weight (sum).
// maxi = 6 (maximum weight in the array).
// sum = 34 (total sum of the weights).
// Step 2: Check for Capacities from maxi (6) to sum (34)
// We now check for each capacity, starting from maxi = 6 and going up to sum = 34. We need to find the smallest capacity where we can ship the weights in 5 days or fewer.

// For capacity = 9:
// We run the findDays method with a capacity of 9.

// Day 1:

// Load = 0, add weight 5 → load = 5 (fits within capacity 9).
// Add weight 4 → load = 9 (fits within capacity 9).
// Day 1 ends with a load of 9.
// Day 2:

// Load = 0, add weight 5 → load = 5 (fits within capacity 9).
// Add weight 2 → load = 7 (fits within capacity 9).
// Day 2 ends with a load of 7.
// Day 3:

// Load = 0, add weight 3 → load = 3 (fits within capacity 9).
// Add weight 4 → load = 7 (fits within capacity 9).
// Day 3 ends with a load of 7.
// Day 4:

// Load = 0, add weight 5 → load = 5 (fits within capacity 9).
// Day 4 ends with a load of 5.
// Day 5:

// Load = 0, add weight 6 → load = 6 (fits within capacity 9).
// Day 5 ends with a load of 6.
// Total days = 5
// Since the total days are 5, which is equal to d = 5, this capacity works.

// Final Output:
// The minimum capacity should be: 9
// Dry Run Explanation:
// We checked different capacities starting from 6, and the first capacity that allowed shipping within 5 days was 9.
// When the capacity is 9, we are able to ship the items in exactly 5 days, so the minimum capacity is 9.
// Corrected Dry Run Walkthrough:
/* Dry Run:

Input: 
- weights = {5, 4, 5, 2, 3, 4, 5, 6}
- d = 5 (maximum allowed days)

Step-by-Step Walkthrough:

1. **Calculate maximum weight and total weight:**
   - `maxi = 6`
   - `sum = 34`

2. **Check for each capacity from `maxi = 6` to `sum = 34`:**

   a. **For capacity = 9:**
      - Day 1: Load = 5, 4 → total load = 9 (fits in capacity 9)
      - Day 2: Load = 5, 2 → total load = 7 (fits in capacity 9)
      - Day 3: Load = 3, 4 → total load = 7 (fits in capacity 9)
      - Day 4: Load = 5 → total load = 5 (fits in capacity 9)
      - Day 5: Load = 6 → total load = 6 (fits in capacity 9)
   
   - Total days = 5, which is equal to the allowed `d = 5`.
   
3. **Output the result:**
   - The minimum capacity should be: 9
*/







//Optimal Approach

// Time Complexity: O(N * log(sum(weights[]) - max(weights[]) + 1)), where sum(weights[]) = summation of all the weights, max(weights[]) = maximum of all the weights, N = size of the weights array.
// Reason: We are applying binary search on the range [max(weights[]), sum(weights[])]. For every possible answer ‘mid’, we are calling findDays() function. Now, inside the findDays() function, we are using a loop that runs for N times.

// Space Complexity: O(1) as we are not using any extra space to solve this problem.


import java.util.*;

public class CapacityToShipppackageWithinDDays {

    public static int findDays(int[] weights, int cap) {
        int days = 1; // First day.
        int load = 0;
        int n = weights.length; // Size of the array.
        
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; // Move to the next day.
                load = weights[i]; // Load the weight for the next day.
            } else {
                load += weights[i]; // Add weight on the same day.
            }
        }
        return days;
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]); // Get the maximum weight in the array.
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            
            if (numberOfDays <= d) {
                high = mid - 1; // Eliminate the right half of the search space.
            } else {
                low = mid + 1; // Eliminate the left half of the search space.
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = leastWeightCapacity(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }
}
