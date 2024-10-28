
import java.util.*;

// Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
//  in the future to sell that stock. Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.

// Examples
// Example 1:
// Input:
//  prices = [7,1,5,3,6,4]
// Output:
//  5
// Explanation:
//  Buy on day 2 (price = 1) and 
// sell on day 5 (price = 6), profit = 6-1 = 5.

// Note
// : That buying on day 2 and selling on day 1 
// is not allowed because you must buy before 
// you sell.

// Example 2:
// Input:
//  prices = [7,6,4,3,1]
// Output:
//  0
// Explanation:
//  In this case, no transactions are 
// done and the max profit = 0.


// BRUTE-FORCE APPROACH

// Time complexity: O(n^2)
// Space Complexity: O(1)

// public class StockBuyandSell {
//     // Method to calculate the maximum profit from the stock prices
//     static int maxProfit(int[] arr) {
//         int maxPro = 0; // Variable to keep track of the maximum profit

//         // Outer loop to iterate over each day's price
//         for (int i = 0; i < arr.length; i++) {
//             // Inner loop to check prices of the following days
//             for (int j = i + 1; j < arr.length; j++) {
//                 // If the price on day j is higher than day i
//                 if (arr[j] > arr[i]) {
//                     // Calculate potential profit and update maxPro if it's higher
//                     maxPro = Math.max(arr[j] - arr[i], maxPro);
//                 }
//             }
//         }
//         // Return the maximum profit found
//         return maxPro;
//     }
//     public static void main(String[] args) {
//         // Example array representing stock prices on different days
//         int arr[] = {7, 1, 5, 3, 6, 4};
//         // Call the maxProfit method to calculate the maximum profit
//         int maxPro = maxProfit(arr);
//         // Print the result
//         System.out.println("Max profit is: " + maxPro);
//     }
// }

/*
Dry Run Explanation:
Given the array: {7, 1, 5, 3, 6, 4}

1. Start with maxPro = 0.
2. i = 0 (price = 7):
   - j = 1 (price = 1): 1 < 7 (ignore)
   - j = 2 (price = 5): 5 < 7 (ignore)
   - j = 3 (price = 3): 3 < 7 (ignore)
   - j = 4 (price = 6): 6 < 7 (ignore)
   - j = 5 (price = 4): 4 < 7 (ignore)

3. i = 1 (price = 1):
   - j = 2 (price = 5): 5 > 1, profit = 5 - 1 = 4, maxPro = 4
   - j = 3 (price = 3): 3 > 1, profit = 3 - 1 = 2, maxPro remains 4
   - j = 4 (price = 6): 6 > 1, profit = 6 - 1 = 5, maxPro = 5
   - j = 5 (price = 4): 4 > 1, profit = 4 - 1 = 3, maxPro remains 5

4. i = 2 (price = 5):
   - j = 3 (price = 3): 3 < 5 (ignore)
   - j = 4 (price = 6): 6 > 5, profit = 6 - 5 = 1, maxPro remains 5
   - j = 5 (price = 4): 4 < 5 (ignore)

5. i = 3 (price = 3):
   - j = 4 (price = 6): 6 > 3, profit = 6 - 3 = 3, maxPro remains 5
   - j = 5 (price = 4): 4 > 3, profit = 4 - 3 = 1, maxPro remains 5

6. i = 4 (price = 6):
   - j = 5 (price = 4): 4 < 6 (ignore)

7. i = 5 (price = 4): No further days to compare.

Final result: maxPro = 5, which is the maximum profit that can be achieved.
*/


// OPTIMAL APPROACH

import java.util.*;

public class StockBuyandSell {

    // Method to calculate the maximum profit from the stock prices
    static int maxProfit(int[] arr) {
        int maxPro = 0; // Variable to keep track of the maximum profit
        int minPrice = Integer.MAX_VALUE; // Start with the highest possible value 

        // Loop through the array to find the minimum price and calculate profit
        for (int i = 0; i < arr.length; i++) {
            // Update minPrice to the lowest price encountered so far
            minPrice = Math.min(minPrice, arr[i]);
            // Calculate profit by subtracting the minimum price from the current price
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        // Return the maximum profit found
        return maxPro;
    }
    public static void main(String[] args) {
        // Example array representing stock prices on different days
        int arr[] = {7, 1, 5, 3, 6, 4};

        // Call the maxProfit method to calculate the maximum profit
        int maxPro = maxProfit(arr);
        // Print the result
        System.out.println("Max profit is: " + maxPro);
    }
}

/*
Dry Run Explanation:
Given the array: {7, 1, 5, 3, 6, 4}

1. Start with maxPro = 0 and minPrice = Integer.MAX_VALUE.

2. i = 0 (price = 7):
   - minPrice = min(Integer.MAX_VALUE, 7) = 7
   - maxPro = max(0, 7 - 7) = 0

3. i = 1 (price = 1):
   - minPrice = min(7, 1) = 1
   - maxPro = max(0, 1 - 1) = 0

4. i = 2 (price = 5):
   - minPrice = min(1, 5) = 1
   - maxPro = max(0, 5 - 1) = 4

5. i = 3 (price = 3):
   - minPrice = min(1, 3) = 1
   - maxPro = max(4, 3 - 1) = 4

6. i = 4 (price = 6):
   - minPrice = min(1, 6) = 1
   - maxPro = max(4, 6 - 1) = 5

7. i = 5 (price = 4):
   - minPrice = min(1, 4) = 1
   - maxPro = max(5, 4 - 1) = 5

Final result: maxPro = 5, which is the maximum profit that can be achieved.
*/
