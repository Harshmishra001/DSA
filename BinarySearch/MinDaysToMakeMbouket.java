package BinarySearch;


// Problem Statement: You are given 'N’ roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
// You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
// Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.

// Examples
// Example 1:
// Input Format:
//  N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
// Result:
//  12
// Explanation:
//  On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

// Example 2:
// Input Format:
//  N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
// Result:
//  -1
// Explanation:
//  If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.



// Let's grasp the question better with the help of an example. Consider an array: {7, 7, 7, 7, 13, 11, 12, 7}. We aim to create bouquets with k, which is 3 adjacent flowers, and we need to make m, which is 2 such bouquets. Now, if we try to make bouquets on the 11th day, the first 4 flowers and the 6th and the last flowers would have bloomed. So, we will be having 6 flowers in total on the 11th day. However, we require two groups of 3 adjacent flowers each. Although we can form one group with the first 3 adjacent flowers, we cannot create a second group. Therefore, 11 is not the answer in this case.

// If we choose the 12th day, we can make 2 such groups, one with the first 3 adjacent flowers and the other with the last 3 adjacent flowers. Hence, we need a minimum of 12 days to make 2 bouquets.

// Observation: 

// Impossible case: To create m bouquets with k adjacent flowers each, we require a minimum of m*k flowers in total. If the number of flowers in the array, represented by array-size, is less than m*k, it becomes impossible to form m bouquets even after all the flowers have bloomed. In such cases, where array-size < m*k, we should return -1.
//  Maximum possible answer: The maximum potential answer corresponds to the time needed for all the flowers to bloom. In other words, it is the highest value within the given array i.e. max(arr[]).
// Minimum possible answer: The minimum potential answer corresponds to the time needed for atleast one flower to bloom. In other words, it is the smallest value within the given array i.e. min(arr[]).
// Note: From the above observations, we can conclude that our answer lies between the range [min(arr[]), max(arr[])].

// How to calculate the number of bouquets we can make on dth day:

// We will count the number of adjacent bloomed flowers(say cnt) and whenever we get a flower that is not bloomed, we will add the number of bouquets we can make with ‘cnt’ adjacent flowers i.e. floor(cnt/k) to the answer. We will follow the process throughout the array. 

// Now, we will write a function possible(), that will return true if, on a certain day, we can make at least m bouquets otherwise it will return false. The steps will be the following:

// possible(arr[], day, m, k) algorithm:

// We will declare two variables i.e. ‘cnt’ and ‘noOfB’.
// cnt -> the number of adjacent flowers,
// noOfB -> the number of bouquets.
// We will run a loop to traverse the array.
// Inside the loop, we will do the following:
// If arr[i] <= day: This means the ith flower has bloomed. So, we will increase the number of adjacent flowers i.e. ‘cnt’ by 1.
// Otherwise, the flower has not bloomed. Here, we will calculate the number of bouquets we can make with ‘cnt’ adjacent flowers i.e. floor(cnt/k), and add it to the noOfB. Now, as this ith flower breaks the sequence of the adjacent bloomed flowers, we will set the ‘cnt’ 0.
// Lastly, outside the loop, we will calculate the floor(cnt/k) and add it to the noOfB.
// If noOfB >= m: This means, we can make at least m bouquets. So, we will return true.
// Otherwise, We will return false.
// Note: We actually pass a particular day as a parameter to the possible() function. The function returns true if it is possible to make atleast m bouquets on that particular day, otherwise, it returns false.




// Brute Force Approach 


// import java.util.*;

// public class  MinDaysToMakeMbouket{
//     public static boolean possible(int[] arr, int day, int m, int k) {
//         int n = arr.length; // Size of the array
//         int cnt = 0;
//         int noOfB = 0;
//         // Count the number of bouquets:
//         for (int i = 0; i < n; i++) {
//             if (arr[i] <= day) {
//                 cnt++; // If the flower can be picked before or on the 'day', increment cnt.
//             } else {
//                 noOfB += (cnt / k); // If cnt >= k, we can form a bouquet. Increment noOfB.
//                 cnt = 0; // Reset the count as we can't use the current flower to make a bouquet.
//             }
//         }
//         noOfB += (cnt / k); // Handle the remaining flowers that can make a bouquet.
//         return noOfB >= m; // Return true if we can make at least 'm' bouquets.
//     }

//     public static int roseGarden(int[] arr, int k, int m) {
//         long val = (long) m * k; // Calculate total number of flowers needed to make 'm' bouquets.
//         int n = arr.length; // Size of the array
//         if (val > n) return -1; // Impossible case, we don't have enough flowers for 'm' bouquets.
        
//         // Find the minimum and maximum days (flower bloom days):
//         int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             mini = Math.min(mini, arr[i]); // Find the minimum day (earliest flower bloom).
//             maxi = Math.max(maxi, arr[i]); // Find the maximum day (latest flower bloom).
//         }

//         // Now check from day 'mini' to 'maxi' to find the earliest day we can make 'm' bouquets.
//         for (int i = mini; i <= maxi; i++) {
//             if (possible(arr, i, m, k)) // If it's possible to make 'm' bouquets on 'day' i
//                 return i; // Return that day
//         }
//         return -1; // If no such day is found, return -1.
//     }

//     public static void main(String[] args) {
//         int[] arr = {7, 7, 7, 7, 13, 11, 12, 7}; // Flower bloom days
//         int k = 3; // Number of flowers needed to make a bouquet
//         int m = 2; // Number of bouquets to make
//         int ans = roseGarden(arr, k, m); // Find the day when we can make 'm' bouquets
//         if (ans == -1)
//             System.out.println("We cannot make m bouquets.");
//         else
//             System.out.println("We can make bouquets on day " + ans);
//     }
// }
/*
Correct Dry Run for roseGarden:

Input:
- arr = {7, 7, 7, 7, 13, 11, 12, 7}
- k = 3
- m = 2

Key Parameters:
- value = m * k = 6 → We need at least 6 flowers to make m = 2 bouquets with k = 3 flowers each.
- mini = 7 (minimum in the array)
- maxi = 13 (maximum in the array)

Outer Loop (from mini = 7 to maxi = 13):

Day = 7:
Call possible(arr, day = 7, m = 2, k = 3):
- Traverse arr:
  - arr[0] = 7 (≤ 7): cnt = 1
  - arr[1] = 7 (≤ 7): cnt = 2
  - arr[2] = 7 (≤ 7): cnt = 3 → cnt / k = 1 → noOfB = 1, reset cnt = 0.
  - arr[3] = 7 (≤ 7): cnt = 1
  - arr[4] = 13 (> 7): Add cnt / k = 0 → noOfB = 1, reset cnt = 0.
  - arr[5] = 11 (> 7): cnt = 0.
  - arr[6] = 12 (> 7): cnt = 0.
  - arr[7] = 7 (≤ 7): cnt = 1.
- End of loop: Add cnt / k = 0 → noOfB = 1.

Return: noOfB = 1 < m = 2, so possible returns false.

Day = 8 to 11:
- For these days, possible returns false because noOfB does not reach m = 2.

Day = 12:
Call possible(arr, day = 12, m = 2, k = 3):
- Traverse arr:
  - arr[0] = 7 (≤ 12): cnt = 1
  - arr[1] = 7 (≤ 12): cnt = 2
  - arr[2] = 7 (≤ 12): cnt = 3 → cnt / k = 1 → noOfB = 1, reset cnt = 0.
  - arr[3] = 7 (≤ 12): cnt = 1
  - arr[4] = 13 (> 12): Add cnt / k = 0 → noOfB = 1, reset cnt = 0.
  - arr[5] = 11 (≤ 12): cnt = 1
  - arr[6] = 12 (≤ 12): cnt = 2
  - arr[7] = 7 (≤ 12): cnt = 3 → cnt / k = 1 → noOfB = 2.
- End of loop: noOfB = 2.

Return: noOfB = 2 ≥ m = 2, so possible returns true.
- Update Answer: The first day where we can make m bouquets is 12.

Day = 13:
- Not Checked: The loop terminates after finding the first valid day (12).
*/



// optimal approach
// Time Complexity: O(log(max(arr[])-min(arr[])+1) * N), 
// where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum element of the array, N = size of the array}.
// Reason: We are applying binary search on our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer ‘mid’, we will call the possible() function. Inside the possible() function, we are traversing the entire array, which results in O(N).

// Space Complexity: O(1) as we are not using any extra space to solve this problem.

import java.util.*;

public class MinDaysToMakeMbouket{
    // Function to check if it is possible to form 'm' bouquets with 'k' flowers on a given day
    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0; // Counter to count the number of consecutive flowers available to form bouquets
        int noOfB = 0; // Number of bouquets formed
        // Traverse the flower bloom days array
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                // If the flower can be picked on or before the given day, increment the count of consecutive flowers
                cnt++;
            } else {
                // If the flower cannot be picked on this day, form bouquets from the consecutive flowers
                noOfB += (cnt / k);
                cnt = 0; // Reset the counter after forming bouquets
            }
        }
        // After the loop, check if remaining consecutive flowers can form bouquets
        noOfB += (cnt / k);
        return noOfB >= m; // Return true if we can form 'm' bouquets, otherwise false
    }

    // Function to find the earliest day to form 'm' bouquets with 'k' flowers
    public static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k; // Calculate total number of flowers needed to form 'm' bouquets
        int n = arr.length; // Size of the array
        if (val > n) return -1; // If there are not enough flowers, return -1
        
        // Find the minimum and maximum bloom days in the array
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]); // Find the minimum bloom day
            maxi = Math.max(maxi, arr[i]); // Find the maximum bloom day
        }

        // Apply binary search to find the earliest day on which we can form 'm' bouquets
        int low = mini, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2; // Find the middle day
            if (possible(arr, mid, m, k)) {
                // If it is possible to form 'm' bouquets on 'mid' day, try earlier days
                high = mid - 1;
            } else {
                // If not possible, try later days
                low = mid + 1;
            }
        }
        return low; // Return the earliest day found to form 'm' bouquets
    }

    public static void main(String[] args) {
        // Sample input array: bloom days of the flowers
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3; // Number of flowers required to form one bouquet
        int m = 2; // Number of bouquets to form
        
        // Get the earliest day to form 'm' bouquets
        int ans = roseGarden(arr, k, m);
        
        // Print the result
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}