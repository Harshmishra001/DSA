// There are n children standing in a line. Each child is assigned a rating 
// value given in the integer array ratings.

// You are giving candies to these children subjected to the following 
// requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the 
// candies to the children.

 

// Example 1:

// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 
// 2, 1, 2 candies respectively.


import java.util.Arrays;
/*
Time Complexity (TC):
- Filling the candies array with 1: O(n)
- Left-to-right traversal: O(n)
- Right-to-left traversal: O(n)
- Calculating total candies: O(n)
Overall TC: O(n)

Space Complexity (SC):
- candies array of size n: O(n)
Overall SC: O(n)
*/
class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Initialize all candies to 1 (minimum requirement).

        // Traverse from left to right to ensure the increasing rating condition.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left to ensure the decreasing rating condition.
        for (int i = n - 2; i >= 0; i--) {   // Start from n-2 to avoid out of bound error when i+1 is checked
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total candies required.
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Candy solution = new Candy();

        // Example input
        int[] ratings = {1, 0, 2};

        // Call the candy method and print the result
        int result = solution.candy(ratings);
        System.out.println("Minimum candies required: " + result);

        // Dry run example with step-by-step explanation
        /*
        Input: ratings = [1, 0, 2]

        Step 1: Initialize candies array with 1 for each child.
        candies = [1, 1, 1]

        Step 2: Traverse from left to right to satisfy increasing rating condition:
            - i = 1: ratings[1] < ratings[0], no change.
              candies = [1, 1, 1]
            - i = 2: ratings[2] > ratings[1], update candies[2] = candies[1] + 1 = 2.
              candies = [1, 1, 2]

        Step 3: Traverse from right to left to satisfy decreasing rating condition:
            - i = 1: ratings[1] < ratings[2], no change.
              candies = [1, 1, 2]
            - i = 0: ratings[0] > ratings[1], update candies[0] = max(candies[0], candies[1] + 1) = 2.
              candies = [2, 1, 2]

        Step 4: Calculate total candies:
            Total candies = 2 + 1 + 2 = 5

        Output: 5
        */
    }
}

