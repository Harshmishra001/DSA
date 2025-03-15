package SlidingWindowTwoPntr;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    /*
    Time Complexity (TC): O(N)
    - The right pointer traverses the array once.
    - The left pointer moves at most once for each right pointer move.
    - Hence, each element is processed at most twice → O(2N) ≈ O(N).

    Space Complexity (SC): O(1)
    - The HashMap stores at most 3 unique keys (since we remove once size > 2).
    - At worst, it holds O(3) elements → O(1).
    */

    int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>(); // To track fruit type and count
        int left = 0, right = 0; // Sliding window pointers
        int maxFruits = 0;       // Maximum number of fruits collected

        for (right = 0; right < fruits.length; right++) {
            // Add the current fruit to the basket
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            // If basket contains more than 2 fruit types, shrink the window
            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[left]);
                if (fruitCount == 1)
                    basket.remove(fruits[left]); // Remove fruit if its count becomes zero
                else
                    basket.put(fruits[left], fruitCount - 1); // Reduce fruit count
                left++; // Move left pointer to shrink the window
            }

            // Update the maximum number of fruits collected
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits; // Return the maximum number of fruits in any valid window
    }

    public static void main(String[] args) {
        FruitIntoBaskets solution = new FruitIntoBaskets();

        // Example test case
        int[] fruits = {1, 2, 1, 2, 3, 2, 2, 3, 4, 4, 3};
        
        // Call the function and print the result
        int result = solution.totalFruit(fruits);
        System.out.println("Maximum number of fruits that can be collected: " + result);
    }
}

// ## **Step-by-Step Dry Run (Execution Walkthrough)**

// ### **Given Input:**
// ```java
// fruits = {1, 2, 1, 2, 3, 2, 2, 3, 4, 4, 3}
// ```
// ### **Initial Variables:**
// - `left = 0`, `right = 0`
// - `basket = {}` (empty)
// - `maxFruits = 0`


// ### **Execution Flow (Step-by-Step)**
// #### **Step 1:** `right = 0`, `fruits[right] = 1`
// - Basket: `{1: 1}`
// - `maxFruits = 1`
// - Move `right++`

// #### **Step 2:** `right = 1`, `fruits[right] = 2`
// - Basket: `{1: 1, 2: 1}`
// - `maxFruits = 2`
// - Move `right++`

// #### **Step 3:** `right = 2`, `fruits[right] = 1`
// - Basket: `{1: 2, 2: 1}`
// - `maxFruits = 3`
// - Move `right++`

// #### **Step 4:** `right = 3`, `fruits[right] = 2`
// - Basket: `{1: 2, 2: 2}`
// - `maxFruits = 4`
// - Move `right++`

// #### **Step 5:** `right = 4`, `fruits[right] = 3`
// - Basket: `{1: 2, 2: 2, 3: 1}` (**More than 2 types**)
// - Shrink window (`left = 0`)
//   - Remove `1` count → `{1: 1, 2: 2, 3: 1}`
//   - `left = 1`
//   - Remove `1` completely → `{2: 2, 3: 1}`
//   - `left = 2`
// - `maxFruits = 3`
// - Move `right++`

// #### **Step 6:** `right = 5`, `fruits[right] = 2`
// - Basket: `{2: 3, 3: 1}`
// - `maxFruits = 4`
// - Move `right++`

// #### **Step 7:** `right = 6`, `fruits[right] = 2`
// - Basket: `{2: 4, 3: 1}`
// - `maxFruits = 5`
// - Move `right++`

// #### **Step 8:** `right = 7`, `fruits[right] = 3`
// - Basket: `{2: 4, 3: 2}`
// - `maxFruits = 6`
// - Move `right++`

// #### **Step 9:** `right = 8`, `fruits[right] = 4`
// - Basket: `{2: 4, 3: 2, 4: 1}` (**More than 2 types**)
// - Shrink window (`left = 3`)
//   - Remove `2` count → `{2: 3, 3: 2, 4: 1}`
//   - `left = 4`
//   - Remove `3` completely → `{2: 3, 4: 1}`
//   - `left = 5`
// - `maxFruits = 4`
// - Move `right++`

// #### **Step 10:** `right = 9`, `fruits[right] = 4`
// - Basket: `{2: 3, 4: 2}`
// - `maxFruits = 5`
// - Move `right++`

// #### **Step 11:** `right = 10`, `fruits[right] = 3`
// - Basket: `{2: 3, 4: 2, 3: 1}` (**More than 2 types**)
// - Shrink window (`left = 6`)
//   - Remove `2` count → `{2: 2, 4: 2, 3: 1}`
//   - `left = 7`
//   - Remove `2` completely → `{4: 2, 3: 1}`
//   - `left = 8`
// - `maxFruits = 4`
// - **End of array**
// ### **Final Output:**
// Maximum number of fruits that can be collected: 6
